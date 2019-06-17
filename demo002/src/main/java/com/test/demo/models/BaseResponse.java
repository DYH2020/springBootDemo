package com.test.demo.models;

import java.io.Serializable;

public class BaseResponse implements Serializable {
    public static final int SUCCEED = 0;//成功
    /**
     * 参数错误
     */
    public static final int PARAMETER_ERROR = 1;//参数错误
    /**
     * 签名错误
     */
    public static final int SIGN_EEROR = 2;//签名错误
    /**
     * 应用级别错误
     */
    public static final int APP_ERROR = 3;//应用级别错误
    /**
     * 应用级别异常
     */
    public static final int APP_EXCEPTION = 4;//应用级别异常
    /**
     * 其他错误
     */
    public static final int OTHER_ERROR = 5;//其他错误

    /**
     * 不合法的权限
     */
    public static final int NO_RIGHT = 6;//不合法的权限

    /**
     * 未登录
     */
    public static final int NOT_LOGGED_IN = 7;

    /**
     * 支付金额错误
     */
    public static final int PAYMENT_AMOUNT_ERROR = 8;

    /**
     * 对象不存在
     */
    public static final int OBJECT_IS_NOT_EXISTS = 9;

    private int code;
    private String info = "";
    private Object data;

    public int getCode() {
        return code;
    }

    public BaseResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public BaseResponse setInfo(String info) {
        this.info = info;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseResponse succeed() {
        this.code = BaseResponse.SUCCEED;
        this.info = "处理成功";
        return this;
    }

    public BaseResponse succeed(String info) {
        this.code = BaseResponse.SUCCEED;
        this.info = info;
        return this;
    }

    public BaseResponse succeed(Object data) {
        this.code = BaseResponse.SUCCEED;
        this.info = "处理成功";
        this.data = data;
        return this;
    }

    public BaseResponse succeed(String info, Object data) {
        this.code = BaseResponse.SUCCEED;
        this.info = info;
        this.data = data;
        return this;
    }

    public BaseResponse failed(int code) {
        this.code = code;
        return this;
    }

    public BaseResponse failed(int code, String info) {
        this.code = code;
        this.info = info;
        return this;
    }

    public BaseResponse failed(int code, String info, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
        return this;
    }

    public BaseResponse failedWithParameterError(){
        this.code = BaseResponse.PARAMETER_ERROR;
        this.info = "参数错误";
        return this;
    }

    public BaseResponse failedWithParameterError(String info){
        this.code = BaseResponse.PARAMETER_ERROR;
        this.info = info;
        return this;
    }

    public BaseResponse failedWithAppError(){
        this.code = BaseResponse.APP_ERROR;
        this.info = "处理失败";
        return this;
    }

    public BaseResponse failedWithAppError(String info){
        this.code = BaseResponse.APP_ERROR;
        this.info = info;
        return this;
    }

    public BaseResponse error() {
        this.code = BaseResponse.APP_EXCEPTION;
        this.info = "系统开小差，请稍后重试";
        return this;
    }

    public BaseResponse error(String info) {
        this.code = BaseResponse.APP_EXCEPTION;
        this.info = info;
        return this;
    }


}
