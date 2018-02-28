package com.king.message.bean;

/**
 *  可用功能 ： 注册、忘记密码、修改个人信息、修改头像、发送验证码
 */


public class CommonBean {
    /**
     * message : 注册码发送成功
     * status : 0000
     */

    private String message;
    private String status;

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
