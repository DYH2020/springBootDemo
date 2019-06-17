package com.test.demo.domain.entities.qaentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_config")
public class PaymentConfig {
    @Id
    private Integer id;

    /**
     * 支付代码
     */
    @Column(name = "pay_code")
    private String payCode;

    /**
     * 公众账号ID
     */
    @Column(name = "appid")
    private String appid;

    /**
     * 商户或服务商号
     */
    @Column(name = "mch_id")
    private String mchId;

    /**
     * 子商户公众账号ID
     */
    @Column(name = "sub_appid")
    private String subAppid;

    /**
     * 子商户号
     */
    @Column(name = "sub_mch_id")
    private String subMchId;

    /**
     * 商户KEY
     */
    @Column(name = "mch_key")
    private String mchKey;

    /**
     * 可选支付方式
     */
    @Column(name = "pay_mode")
    private Integer payMode;

    @Column(name = "detail")
    private String detail;

    @Column(name = "use_sandbox")
    private Integer useSandbox;

    @Column(name = "sandbox_mch_key")
    private String sandboxMchKey;

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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }
}
