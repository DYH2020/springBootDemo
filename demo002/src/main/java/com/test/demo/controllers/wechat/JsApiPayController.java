package com.test.demo.controllers.wechat;

import com.test.demo.core.config.AppProperties;
import com.test.demo.core.exceptions.AppMessageException;
import com.test.demo.domain.entities.qaentities.*;
import com.test.demo.models.BaseResponse;
import com.test.demo.models.enums.PaymentStatusEnum;
import com.test.demo.models.enums.TerminalEnum;
import com.test.demo.services.IdGenerator;
import com.test.demo.services.wechat.JsApiPayService;
import com.test.demo.utils.Checker;
import com.test.demo.utils.DateUtil;
import com.test.demo.utils.RandomUtil;
import com.test.demo.utils.StringHelper;
import com.test.demo.utils.serializers.JsonSerializer;
import com.test.demo.utils.wxpay.sdk.WXPay;
import com.test.demo.utils.wxpay.sdk.WXPayUtil;
import com.test.demo.utils.wxpay.sdk.YWTWXPayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jsapi")
public class JsApiPayController {

    private static final Logger logger = LoggerFactory.getLogger(JsApiPayController.class);

    @Autowired
    private JsApiPayService jsApiPayService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private PaymentConfigRepository paymentConfigRepository;

    @Autowired
    private WxPaymentLogsRepository wxPaymentLogsRepository;

    @Autowired
    private AppProperties appProperties;


    /**
     * 得到微信支付，调用统一下单接口
     */
    @RequestMapping(value = "/getWxPaymentInfo", method = RequestMethod.POST)
    public BaseResponse demo(@RequestBody Map<String, Integer> map) throws Exception {
        BaseResponse response = new BaseResponse();
        Integer orderId = map.getOrDefault("orderId", 0);
        // 支付金额
        Integer amount = map.getOrDefault("amount", 0);
        Integer insuranceType = map.getOrDefault("insuranceType", 0);
        Integer freight = map.getOrDefault("freight", 0);

        if (Checker.getIntegerValue(orderId) == 0) {
            return response.failedWithParameterError("订单ID有误");
        }
        if (Checker.getIntegerValue(amount) <= 0) {
            return response.failedWithParameterError("支付金额有误");
        }
        if (Checker.getIntegerValue(freight) < 0) {
            return response.failedWithParameterError("运费金额有误");
        }
        int userId = 4;
        int terminal = TerminalEnum.PatientWxApp.getValue();
        String openId = "oJFgS0clT_KX5N61Uw2DkEBCoYxg";
        String ip = "";// InetAddress.getLocalHost().getHostAddress();
        System.out.println(ip);

        // 判断 orderType，看走哪一种支付方式，//处方订单支付、咨询订单支付、线下就诊订单支付、远程会诊订单支付走支付中心方式
        // 先看下支付中心方式的
        response = wechatPayment("", ip, openId, amount + freight, terminal, orderId, userId);
        System.out.println("response:" + response.toString());
        return response;
    }

    /**
     * 调用order-center-service
     *
     * @param body
     * @param ip
     * @param openId
     * @param amount
     * @param terminal
     * @param orderId
     * @param userId
     * @return
     */
    private BaseResponse wechatPayment(String body, String ip, String openId, int amount, int terminal, int orderId, int userId) throws Exception {
        logger.info("wechatPayment(orderId: {}, userId: {}, terminal: {}, ip: {}, openId: {}, amount: {})", orderId, userId, terminal, ip, openId, amount);

        Order order = orderRepository.findOne(orderId);
        if (order == null || order.getDeleted()) {
            throw new AppMessageException("订单不存在");
        }

        if (BigDecimal.ZERO.compareTo(order.getOrderAmount()) == 0) {
            throw new AppMessageException("订单金额不正确");
        }

        if (order.getPaymentStatus() == PaymentStatusEnum.Success.getValue()) {
            throw new AppMessageException("该订单已经支付，请勿重复操作");
        }

        if (order.getOrderAmount().doubleValue() != (amount / 100d)) {
            throw new AppMessageException("支付金额不正确。");
        }

        String payCode = order.getPayCode();
        if (Checker.isNone(payCode)) {
            throw new AppMessageException("当前订单没有支付代码");
        }

        if (StringHelper.isNullOrEmpty(ip)) {
            ip = "0.0.0.0";
        }
        String paymentNo = order.getOrderNo();  //支付流水号 genPaymentNo("");
        body = Checker.getStringValue(order.getPayBody());

        // todo 这里可以加个锁，在信号不好的情况下，可能会发起重复支付

        // 微信统一下单接口
        BaseResponse response = weChatPay(payCode, body, paymentNo, amount, ip, openId, "paymentNo=" + paymentNo, "/com.ywt.gapi.ordercenter.OrderCenterService/WechatPaymentNotify", 1);
        return response;
    }

    /**
     * 调用统一下单接口
     *
     * @param payCode        支付码
     * @param body           body
     * @param paymentNo      支付流水号
     * @param amount         支付金额（单位：分）
     * @param ip             ip地址
     * @param openId         用户的openId
     * @param attach         附加信息
     * @param callBackMethod 返回方法
     * @param payType        支付类型
     * @return {@link BaseResponse}
     */
    private BaseResponse weChatPay(String payCode, String body, String paymentNo, int amount, String ip, String openId,
                                   String attach, String callBackMethod, int payType) throws Exception {

        PaymentConfig paymentConfig = paymentConfigRepository.findByPayCode(payCode);
        if (paymentConfig == null) {
            throw new AppMessageException(String.format("支付代码(%s)不存在", payCode));
        }

        //写入支付日志
        WxPaymentLogs wxPaymentLogs = new WxPaymentLogs();
        wxPaymentLogs.setId(idGenerator.getWxPaymentLogsId());
        wxPaymentLogs.setPayCode(payCode);
        wxPaymentLogs.setTotalFee(amount);
        wxPaymentLogs.setSpbillCreateIp(ip);
        wxPaymentLogs.setOpenid(openId);
        wxPaymentLogs.setBody(body);
        wxPaymentLogs.setOutTradeNo(paymentNo);
        wxPaymentLogs.setInternalAttach(attach);
        wxPaymentLogs.setCallBackMethod(callBackMethod);
        wxPaymentLogs.setPayType(payType);
        wxPaymentLogs.setCreateTime(new Date());
        wxPaymentLogs.setMchKey(paymentConfig.getMchKey());
        wxPaymentLogs.setSandboxMchKey(paymentConfig.getSandboxMchKey());

        if (Checker.getIntegerValue(paymentConfig.getUseSandbox()) == 1) { //使用沙箱
            wxPaymentLogs.setUseSandbox(1);
            //wxPaymentLogs.setMchKey(paymentConfig.getSandboxMchKey());
        } else {
            wxPaymentLogs.setUseSandbox(0);
        }
        // 记录appId,mchId,subAppId,subMchId等
        wxPaymentLogs.setAppId(paymentConfig.getAppid());
        wxPaymentLogs.setMchId(paymentConfig.getMchId());
        wxPaymentLogs.setSubAppId(paymentConfig.getSubAppid());
        wxPaymentLogs.setSubMchId(paymentConfig.getSubMchId());
//        wxPaymentLogsRepository.save(wxPaymentLogs);

        System.out.println(JsonSerializer.toJson(paymentConfig));

        YWTWXPayConfig ywtwxPayConfig = new YWTWXPayConfig();
        ywtwxPayConfig.setAppID(paymentConfig.getAppid());
        ywtwxPayConfig.setKey(paymentConfig.getMchKey());
        ywtwxPayConfig.setMchID(paymentConfig.getMchId());

        WXPay wxPay = new WXPay(ywtwxPayConfig, appProperties.getWxpayNotifyUrl(), Checker.getIntegerValue(paymentConfig.getUseSandbox()) == 1);

        Map<String, String> map = new HashMap<>(16);
        map.put("appid", paymentConfig.getAppid());
//        map.put("mch_id", paymentConfig.getMchId());
        map.put("sub_mch_id", paymentConfig.getSubMchId());
        // 如果不为空则认为是子商户，需要传递相关的参数
        if (!StringHelper.isNullOrEmpty(paymentConfig.getSubAppid())) {
            map.put("sub_appid", paymentConfig.getSubAppid());
        }
        if (!StringHelper.isNullOrEmpty(paymentConfig.getSubMchId())) {
            map.put("sub_mch_id", paymentConfig.getSubMchId());
        }
        // 随机字符串 随机字符串，长度要求在32位以内。推荐随机数生成算法
        String nonceStr = WXPayUtil.generateNonceStr();
        map.put("nonce_str", nonceStr);
        map.put("body", body);
        // 附加数据	必传：否
        map.put("attach", attach);
        map.put("out_trade_no", paymentNo);
        map.put("total_fee", String.valueOf(amount));
        map.put("spbill_create_ip", ip);
        // 通知地址
        String notifyUrl = "";
//        map.put("notify_url", notifyUrl);
        // 交易类型, 默认：JSAPI
        String tradeType = "JSAPI";
        map.put("trade_type", tradeType);

        // map.put("openid", openId); // todo 如果是服务商的情况下，
        map.put("sub_openid", openId);
        map.put("sub_appid", paymentConfig.getSubAppid());

        Map<String, String> result = wxPay.unifiedOrder(map);
        String returnCode = result.get("return_code");

        return new BaseResponse().succeed(result);

    }


    /**
     * 生成支付流水号（微信支付，商户订单号总长度不能超过32位）
     * prefix + yyyyMMddHHmmssSSS + 0001(四位唯一标识码) + 321(三位随机数)
     *
     * @param prefix
     * @return
     */
    private String genPaymentNo(String prefix) {
        StringBuilder paymentNo = new StringBuilder();

        if (!StringHelper.isNullOrWhiteSpace(prefix)) {
            paymentNo.append(prefix);
        }

        paymentNo.append(DateUtil.convertToString(new Date(), "yyyyMMddHHmmssSSS"));
        paymentNo.append(String.format("%04d", idGenerator.genPaymentNo()));
        paymentNo.append(RandomUtil.getRandomCode(3, 1));

        return paymentNo.toString();
    }


}
