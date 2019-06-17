package com.test.demo.domain.entities.qaentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 咨询订单
 */
@Entity
@Table(name = "consult_order")
public class ConsultOrder {

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 用户Id
     */
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    /**
     * 姓名
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 电话
     */
    @Column(name = "mobile", nullable = false)
    private String mobile;

    /**
     * 年龄
     */
    @Column(name = "age", nullable = false)
    private Integer age;

    /**
     * 性别
     */
    @Column(name = "sex", nullable = false)
    private Integer sex;

    /**
     * 病情描述
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * 医生Id
     */
    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;

    /**
     * 医院Id
     */
    @Column(name = "hospital_id", nullable = false)
    private Integer hospitalId;

    /**
     * 科室Id
     */
    @Column(name = "dept_id", nullable = false)
    private Integer deptId;

    /**
     * 咨询费用，单位：分
     */
    @Column(name = "amount", nullable = false)
    private Integer amount;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 会话Id
     */
    @Column(name = "session_id", nullable = false)
    private String sessionId;

    /**
     * 支付状态
     */
    @Column(name = "payment_status", nullable = false)
    private Integer paymentStatus;

    /**
     * 咨询状态
     */
    @Column(name = "consult_status", nullable = false)
    private Integer consultStatus;

    /**
     * 是否删除
     */
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    /**
     * 接诊时间
     */
    @Column(name = "accept_time")
    private Date acceptTime;

    /**
     * 患者id
     */
    @Column(name = "patient_id", nullable = false)
    private Integer patientId;

    /**
     * 微信商户Id
     */
    @Column(name = "wx_merchant_id")
    private String wxMerchantId;

    /**
     * 内部支付实现唯一编码
     */
    @Column(name = "wx_internal_pay_no")
    private String wxInternalPayNo;

    /**
     * 微信支付订单号
     */
    @Column(name = "wx_transaction_id")
    private String wxTransactionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getConsultStatus() {
        return consultStatus;
    }

    public void setConsultStatus(Integer consultStatus) {
        this.consultStatus = consultStatus;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getWxMerchantId() {
        return wxMerchantId;
    }

    public void setWxMerchantId(String wxMerchantId) {
        this.wxMerchantId = wxMerchantId;
    }

    public String getWxInternalPayNo() {
        return wxInternalPayNo;
    }

    public void setWxInternalPayNo(String wxInternalPayNo) {
        this.wxInternalPayNo = wxInternalPayNo;
    }

    public String getWxTransactionId() {
        return wxTransactionId;
    }

    public void setWxTransactionId(String wxTransactionId) {
        this.wxTransactionId = wxTransactionId;
    }
}
