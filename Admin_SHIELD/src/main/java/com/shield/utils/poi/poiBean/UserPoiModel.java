package com.shield.utils.poi.poiBean;

import com.shield.utils.poi.ExcelDescribeAnon;
import com.shield.utils.poi.ExcelFieldDescribeAnno;

import java.util.Date;
@ExcelDescribeAnon(title = "用户信息查看",sheetName = "用户信息查看")
public class UserPoiModel {

    @ExcelFieldDescribeAnno(columnName = "姓名")
    private String realName;//姓名
    @ExcelFieldDescribeAnno(columnName = "联系电话")
    private String phone;//联系电话
    @ExcelFieldDescribeAnno(columnName = "邮箱")
    private String email;//邮箱
    @ExcelFieldDescribeAnno(columnName = "身份证号")
    private String idCard;//身份证号
    @ExcelFieldDescribeAnno(columnName = "性别")
    private String  sexName;//性别
    @ExcelFieldDescribeAnno(columnName = "生日",patten = "yyyy-MM-dd")
    private Date birthday;//生日
    @ExcelFieldDescribeAnno(columnName = "学历")
    private String eduName;
    @ExcelFieldDescribeAnno(columnName = "省")
    private String provinceName;
    @ExcelFieldDescribeAnno(columnName = "市")
    private String cityName;
    @ExcelFieldDescribeAnno(columnName = "县/区")
    private String areaName;
    @ExcelFieldDescribeAnno(columnName = "部门名称")
    private String deptName;
    @ExcelFieldDescribeAnno(columnName = "创建时间",patten = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间
    @ExcelFieldDescribeAnno(columnName = "修改时间",patten = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;//修改时间

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
