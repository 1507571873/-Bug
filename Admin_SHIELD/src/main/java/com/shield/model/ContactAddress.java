package com.shield.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ContactAddress {

    private Integer id;//主键Id
    private String  residentialAddress;//居住地址
    private String  phone;//电话号码手机号
    private String  exigencyContacts;//紧急联系人
    private String  exigencyPhone;//紧急联系人电话
    private String  postCode;//邮政编码
    private Integer  userId;//用户Id
    private Integer operatorId;//操作人员ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    createDate;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    updateDate;//修改时间


    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExigencyContacts() {
        return exigencyContacts;
    }

    public void setExigencyContacts(String exigencyContacts) {
        this.exigencyContacts = exigencyContacts;
    }

    public String getExigencyPhone() {
        return exigencyPhone;
    }

    public void setExigencyPhone(String exigencyPhone) {
        this.exigencyPhone = exigencyPhone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date creatDate) {
        this.createDate = creatDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
