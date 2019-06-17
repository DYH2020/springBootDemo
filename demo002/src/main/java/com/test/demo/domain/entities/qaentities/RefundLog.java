package com.test.demo.domain.entities.qaentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "refund_log")
public class RefundLog {
    @Id
    private Integer id;

    @Column(name = "internal_pay_no")
    private String internalPayNo;

    @Column(name = "refund_no")
    private String refundNo;

    @Column(name = "refund_fee")
    private int refundFee;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "out_order_no")
    private String outOrderNo;

    @Column(name = "refund_desc")
    private String desc;

    @Column(name = "response")
    private String response;

    @Column(name = "refund_status")
    private int status;

    @Column(name = "callback_time")
    private Date callbackTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "callback_method")
    private String callbackMethod;

    @Column(name = "request_data")
    private String requestData;

    @Column(name = "refund_id")
    private String refundId;

    @Column(name = "success_time")
    private String successTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInternalPayNo() {
        return internalPayNo;
    }

    public void setInternalPayNo(String internalPayNo) {
        this.internalPayNo = internalPayNo;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(int refundFee) {
        this.refundFee = refundFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getCallbackMethod() {
        return callbackMethod;
    }

    public void setCallbackMethod(String callbackMethod) {
        this.callbackMethod = callbackMethod;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }
}
