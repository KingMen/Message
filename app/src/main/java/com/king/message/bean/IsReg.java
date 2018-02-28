package com.king.message.bean;

/**
 * Created by 陈尘 on 2018/2/24.
 */

public class IsReg {

    /**
     * result : false
     * message : 手机号未被注册
     * status : 0003
     */

    private boolean result;
    private String message;
    private String status;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
