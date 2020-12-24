package com.shield.vo;

import com.shield.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class UserVo extends User implements Serializable {
    private Long count;//总条数
    private int  code;//前端需要返回的状态码
    private Object data;//放入查询数据
    private String msg;//查询后返的
    private Integer page;//当前页
    private Integer limit;//每页条数

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//条件查询 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//条件查询 结束时间
    private Integer startIndex;//开始下标

    //计算开始下标
    public void chaxunIndex(){
        this.startIndex =(this.page-1)*this.limit;
    }


    private String p_code;
    private String c_code;
    private String a_code;
    private String e_code;
    private String d_code;



    public String getD_code() {
        return d_code;
    }

    public void setD_code(String d_code) {
        this.d_code = d_code;
    }

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getA_code() {
        return a_code;
    }

    public void setA_code(String a_code) {
        this.a_code = a_code;
    }

    public String getE_code() {
        return e_code;
    }

    public void setE_code(String e_code) {
        this.e_code = e_code;
    }


    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }
}
