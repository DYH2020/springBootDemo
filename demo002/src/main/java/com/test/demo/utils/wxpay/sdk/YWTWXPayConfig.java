package com.test.demo.utils.wxpay.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class YWTWXPayConfig extends WXPayConfig {
    private String appID;
    private String mchID;
    private String key;
    private String certFileName;

    @Override
    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String appID){
        this.appID = appID;
    }

    @Override
    public String getMchID() {
        return this.mchID;
    }

    public void setMchID(String mchID){
        this.mchID = mchID;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    public void setKey(String key){
        this.key = key;
    }

    @Override
    public InputStream getCertStream() {
        File file = new File(this.certFileName);
        InputStream certStream = null;
        try {
            certStream = new FileInputStream(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return certStream;
    }

    public void setCertFileName(String certFileName) {
        this.certFileName = certFileName;
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        return YWTWXPayDomainSimpleImpl.instance();
    }
}
