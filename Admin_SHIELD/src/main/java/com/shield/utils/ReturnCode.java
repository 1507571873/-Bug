package com.shield.utils;

public enum ReturnCode {
    SUCCESS(200,"操作成功"),
    ERROR(400,"操作失败"),
    USERNAME_PASSWORD_NULL(5001,"用户名密码不能为空"),
    USERNAME_NOEXIST(5002,"用户名不存在"),
    PASSWORD_ERROR(5003,"密码错误"),
    LOGIN_OVER(2000,"登录成功"),
    LOGIN_ERROR(2001,"登录失败"),
    SYSTEM_ERROR(500,"代码执行异常"),
    LEAVE_TIME_ERROR(111,"请假时间有误"),
    ;

    ReturnCode(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    private Integer code;
    private String  msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
