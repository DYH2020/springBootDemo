package com.test.demo.domain.entities.qaentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Integer id;

    /**
     * 订单编号
     */
    @Column(name = "order_no", nullable = false)
    private String orderNo;

    /**
     * 订单状态
     */
    @Column(name = "order_status", nullable = false)
    private Integer orderStatus;

    /**
     * 用户Id
     */
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    /**
     * 订单金额
     */
    @Column(name = "order_amount", nullable = false)
    private BigDecimal orderAmount;

    /**
     * 支付状态（0-支付处理中，1-支付成功，2-支付失败）
     */
    @Column(name = "payment_status", nullable = false)
    private Integer paymentStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false)
    private Date createTime;

//    /**
//     * 是否删除（标识物理删除）
//     */
//    @Column(name = "is_deleted", nullable = false)
//    private boolean isDeleted;


    @Column(name = "order_type", nullable = false)
    private Integer orderType;

    @Column(name = "business_id", nullable = false)
    private Integer businessId;

    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;

    @Column(name = "title")
    private String title;

    /**
     * 订单编号
     */
    @Column(name = "patient_mobile", nullable = false)
    private String patientMobile;

    @Column(name = "prepay_id")
    private String prepayId;


    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "terminal")
    private Integer terminal;

    /**
     *
     */
    @Column(name = "payment_callback_method")
    private String paymentCallbackMethod;

    @Column(name = "custom")
    private String custom;

    @Column(name = "pay_code")
    private String payCode;

    @Column(name = "pay_body")
    private String payBody;

    /**
     * 支付流水号
     */
    @Column(name = "payment_no", nullable = false)
    private String paymentNo;

    @Column(name = "refunded_amount")
    private Integer refundedAmount;

    @Column(name = "pay_time")
    private Date payTime;

    @Column(name = "payment_callback_rest_url")
    private String paymentCallbackRestUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

//    public boolean isDeleted() {
//        return isDeleted;
//    }
//
//    public void setIsDeleted(boolean deleted) {
//        isDeleted = deleted;
//    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public String getPaymentCallbackMethod() {
        return paymentCallbackMethod;
    }

    public void setPaymentCallbackMethod(String paymentCallbackMethod) {
        this.paymentCallbackMethod = paymentCallbackMethod;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getPayBody() {
        return payBody;
    }

    public void setPayBody(String payBody) {
        this.payBody = payBody;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Integer refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPaymentCallbackRestUrl() {
        return paymentCallbackRestUrl;
    }

    public void setPaymentCallbackRestUrl(String paymentCallbackRestUrl) {
        this.paymentCallbackRestUrl = paymentCallbackRestUrl;
    }
}
