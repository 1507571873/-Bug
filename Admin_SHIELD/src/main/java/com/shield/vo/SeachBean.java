package com.shield.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SeachBean {

    private String userName;
    private Integer sex;
    private Integer eduId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//条件查询 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//条件查询 结束时间

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getEduId() {
        return eduId;
    }

    public void setEduId(Integer eduId) {
        this.eduId = eduId;
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
}
