package com.test.demo.domain.entities.qaentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "wx_payment_logs")
public class WxPaymentLogs {
    @Id
    private Integer id;

    @Column(name = "pay_code")
    private String payCode;

    @Column(name = "total_fee")
    private Integer totalFee;

    @Column(name = "spbill_create_ip")
    private String spbillCreateIp;

    @Column(name = "openid")
    private String openid;

    @Column(name = "body")
    private String body;

    @Column(name = "out_trade_no")
    private String outTradeNo;

    @Column(name = "internal_attach")
    private String internalAttach;

    @Column(name = "callBack_method")
    private String callBackMethod;

    @Column(name = "pay_type")
    private Integer payType;

    @Column(name = "callback_time")
    private Date callbackTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "prepay_id")
    private String prepayId;

    @Column(name = "unified_order_data")
    private String unifiedOrderData;

    @Column(name = "callback_data")
    private String callbackData;

    @Column(name = "mch_key")
    private String mchKey;

    @Column(name = "use_sandbox")
    private Integer useSandbox;

    @Column(name = "sandbox_mch_key")
    private String sandboxMchKey;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "mch_id")
    private String mchId;

    @Column(name = "sub_app_id")
    private String subAppId;

    @Column(name = "sub_mch_id")
    private String subMchId;
    /**
     * 证书路径
     */
    @Column(name = "cert_path")
    private String certPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getInternalAttach() {
        return internalAttach;
    }

    public void setInternalAttach(String internalAttach) {
        this.internalAttach = internalAttach;
    }

    public String getCallBackMethod() {
        return callBackMethod;
    }

    public void setCallBackMethod(String callBackMethod) {
        this.callBackMethod = callBackMethod;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public String getUnifiedOrderData() {
        return unifiedOrderData;
    }

    public void setUnifiedOrderData(String unifiedOrderData) {
        this.unifiedOrderData = unifiedOrderData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public Integer getUseSandbox() {
        return useSandbox;
    }

    public void setUseSandbox(Integer useSandbox) {
        this.useSandbox = useSandbox;
    }

    public String getSandboxMchKey() {
        return sandboxMchKey;
    }

    public void setSandboxMchKey(String sandboxMchKey) {
        this.sandboxMchKey = sandboxMchKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }
}
