package com.shield.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Punchcard {

    private Integer id;
    private Integer userId;
    private String realName;
    private Integer deptId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date clockInTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date afterWorkTime;
    private Integer clockStatus;
    private Integer afterWorkStatus;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(Date clockInTime) {
        this.clockInTime = clockInTime;
    }

    public Date getAfterWorkTime() {
        return afterWorkTime;
    }

    public void setAfterWorkTime(Date afterWorkTime) {
        this.afterWorkTime = afterWorkTime;
    }

    public Integer getClockStatus() {
        return clockStatus;
    }

    public void setClockStatus(Integer clockStatus) {
        this.clockStatus = clockStatus;
    }

    public Integer getAfterWorkStatus() {
        return afterWorkStatus;
    }

    public void setAfterWorkStatus(Integer afterWorkStatus) {
        this.afterWorkStatus = afterWorkStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
