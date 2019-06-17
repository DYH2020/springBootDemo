package com.test.demo.core.config;

import com.test.demo.utils.Checker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppProperties {

    @Value("${skip.wechat.corppay}")
    private String skipWechatCorppay;

    @Value("${wxpay.notify.url}")
    private String wxpayNotifyUrl;

    public boolean isSkipWechatCorppay() {
        if (!Checker.isNone(skipWechatCorppay) && skipWechatCorppay.equals("true")){
            return true;
        }
        return false;
    }

    public String getWxpayNotifyUrl() {
        return wxpayNotifyUrl;
    }
}
