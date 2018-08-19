package com.bobo.springboot.lean.commons;

/**
 * @author wuxiaobo@didachuxing.com
 */

public class ResultInfo {

    public final static int SUCCESS_CODE=200;

    private int code;
    private Object data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultInfo() {
        this.code = SUCCESS_CODE;
    }

    public ResultInfo(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
