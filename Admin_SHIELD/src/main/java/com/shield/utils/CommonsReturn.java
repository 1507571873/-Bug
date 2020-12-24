package com.shield.utils;

public class CommonsReturn {

    private Integer code;
    private String  msg;
    private Object  data;


    private CommonsReturn(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    private CommonsReturn(Integer code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
    private CommonsReturn(){}

    public  static  CommonsReturn success(){
        return new CommonsReturn(ReturnCode.SUCCESS.getCode(),ReturnCode.SUCCESS.getMsg());
    }
    public  static  CommonsReturn success(Object data){
        return new CommonsReturn(ReturnCode.SUCCESS.getCode(),ReturnCode.SUCCESS.getMsg(),data);
    }
    public  static  CommonsReturn success(ReturnCode returnCode){
        return new CommonsReturn(returnCode.getCode(),returnCode.getMsg());
    }
    public  static  CommonsReturn success(ReturnCode returnCode,Object data){
        return new CommonsReturn(returnCode.getCode(),returnCode.getMsg(),data);
    }

    public  static  CommonsReturn error(){
        return new CommonsReturn(ReturnCode.ERROR.getCode(),ReturnCode.ERROR.getMsg());
    }
    public  static  CommonsReturn error(Object data){
        return new CommonsReturn(ReturnCode.ERROR.getCode(),ReturnCode.ERROR.getMsg(),data);
    }
    public  static  CommonsReturn error(ReturnCode returnCode){
        return new CommonsReturn(returnCode.getCode(),returnCode.getMsg());
    }
    public  static  CommonsReturn error(ReturnCode returnCode,Object data){
        return new CommonsReturn(returnCode.getCode(),returnCode.getMsg(),data);
    }


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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
