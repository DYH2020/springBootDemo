package com.test.demo.domain.entities.qaentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "wechart_corppay_logs")
public class WechartCorppayLogs {
    @Id
    private Integer id;

    @Column(name = "pay_code")
    private String payCode;

    @Column(name = "mch_id")
    private String mchId;

    @Column(name = "partner_trade_no")
    private String partnerTradeNo;

    @Column(name = "openid")
    private String openid;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "req_data")
    private String reqData;

    @Column(name = "resp_data")
    private String respData;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "cert_path")
    private String certPath;

    @Column(name = "payment_no")
    private String paymentNo;

    @Column(name = "payment_time")
    private String paymentTime;

    @Column(name = "skip_wechat_corppay")
    private Integer skipWechatCorppay;

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

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getReqData() {
        return reqData;
    }

    public void setReqData(String reqData) {
        this.reqData = reqData;
    }

    public String getRespData() {
        return respData;
    }

    public void setRespData(String respData) {
        this.respData = respData;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getSkipWechatCorppay() {
        return skipWechatCorppay;
    }

    public void setSkipWechatCorppay(Integer skipWechatCorppay) {
        this.skipWechatCorppay = skipWechatCorppay;
    }
}

