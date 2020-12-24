package com.shield.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Health {
    private Integer id;//主键Id
    private Integer userId;//用户Id
    private Integer operatorId;//操作员id
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date examineTime;//体检时间
    private String staure;//身高
    private String weight;//体重
    private Integer healthStatus;//健康状态
    private Integer isCCVD;//是否有心脑血管疾病
    private Integer isGeneticDisease;//是否有遗传疾病
    private Integer isContagion;//是否有传染病
    private String medicalHistory;//病例史
    private String diseaseDescription;//病情描述

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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public String getStaure() {
        return staure;
    }

    public void setStaure(String staure) {
        this.staure = staure;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Integer getIsCCVD() {
        return isCCVD;
    }

    public void setIsCCVD(Integer isCCVD) {
        this.isCCVD = isCCVD;
    }

    public Integer getIsGeneticDisease() {
        return isGeneticDisease;
    }

    public void setIsGeneticDisease(Integer isGeneticDisease) {
        this.isGeneticDisease = isGeneticDisease;
    }

    public Integer getIsContagion() {
        return isContagion;
    }

    public void setIsContagion(Integer isContagion) {
        this.isContagion = isContagion;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getDiseaseDescription() {
        return diseaseDescription;
    }

    public void setDiseaseDescription(String diseaseDescription) {
        this.diseaseDescription = diseaseDescription;
    }
}
