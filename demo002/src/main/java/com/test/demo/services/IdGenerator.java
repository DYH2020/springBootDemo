package com.test.demo.services;

import com.test.demo.domain.entities.qaentities.SequenceRepository;
import com.test.demo.utils.DateUtil;
import com.test.demo.utils.RandomUtil;
import com.test.demo.utils.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class IdGenerator {
    /**
     * 订单表名
     */
    private final String ORDER_TABLE_NAME = "order";

    /**
     * 订单号标志
     */
    private final String ORDER_NO_TAG_NAME = "orderno";

    private final String ORDER_PAYMENT_TABLE_NAME = "order_payment";

    /**
     * 支付流水号
     */
    private final String PAYMENT_NO_TAG_NAME = "payment_no";

    @Autowired
    private SequenceRepository sequenceRepository;

    /**
     * 生成订单Id
     *
     * @return
     */
    public int generateOrderId() {
        return sequenceRepository.gen(ORDER_TABLE_NAME);
    }

    /**
     * 生成订单编号
     *
     * @return
     */
    public String generateOrderNo(String prefix) {
        if (StringHelper.isNullOrEmpty(prefix)) {
            prefix = "";
        }

        Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        int sn = sequenceRepository.generateSn(ORDER_NO_TAG_NAME);
        return prefix + format.format(currentDate) + String.format("%04d", sn);
    }

    public int genPaymentNo() {
        return sequenceRepository.generateSn(PAYMENT_NO_TAG_NAME);
    }

    /**
     * 生成支付流水号（微信支付，商户订单号总长度不能超过32位）
     * prefix + yyyyMMddHHmmssSSS + 0001(四位唯一标识码) + 321(三位随机数)
     *
     * @param prefix
     * @return
     */
    public String genPaymentNo(String prefix) {
        StringBuilder paymentNo = new StringBuilder();

        if (!StringHelper.isNullOrWhiteSpace(prefix)) {
            paymentNo.append(prefix);
        }

        paymentNo.append(DateUtil.convertToString(new Date(), "yyyyMMddHHmmssSSS"));
        paymentNo.append(String.format("%04d", genPaymentNo()));
        paymentNo.append(RandomUtil.getRandomCode(3, 1));

        return paymentNo.toString();
    }

    /**
     * 订单支付流水表
     *
     * @return
     */
    public int genOrderPaymentId() {
        return sequenceRepository.gen(ORDER_PAYMENT_TABLE_NAME);
    }

    /**
     * 生成订单退款日志表id
     * @return
     */
    public int genOrderRefundLogId() {
        return sequenceRepository.gen("order_refund_log");
    }

    public Integer getWxPaymentLogsId() {
        return sequenceRepository.gen("wx_payment_logs");
    }

}
