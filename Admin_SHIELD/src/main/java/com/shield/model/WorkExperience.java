package com.shield.model;

import java.util.Date;

public class WorkExperience {

    private Integer workExId;
    private Integer userId;
    private Integer operatorId;
    private Date    createDate;
    private Date    updateDate;
    private String  workExData1;
    private String  workExData2;
    private String  workExData3;
    private String  workExData4;

    public Integer getWorkExId() {
        return workExId;
    }

    public void setWorkExId(Integer workExId) {
        this.workExId = workExId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getWorkExData1() {
        return workExData1;
    }

    public void setWorkExData1(String workExData1) {
        this.workExData1 = workExData1;
    }

    public String getWorkExData2() {
        return workExData2;
    }

    public void setWorkExData2(String workExData2) {
        this.workExData2 = workExData2;
    }

    public String getWorkExData3() {
        return workExData3;
    }

    public void setWorkExData3(String workExData3) {
        this.workExData3 = workExData3;
    }

    public String getWorkExData4() {
        return workExData4;
    }

    public void setWorkExData4(String workExData4) {
        this.workExData4 = workExData4;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
