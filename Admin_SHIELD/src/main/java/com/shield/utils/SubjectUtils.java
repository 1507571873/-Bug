package com.shield.utils;

import com.shield.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


public class SubjectUtils {

    public static String getKeyAndUserName(String key){
        User subject = (User) SecurityUtils.getSubject().getPrincipal();
        return key+subject.getUserName();
    }

    public static User getUsersubject(){
        User subject = (User) SecurityUtils.getSubject().getPrincipal();
        return subject;
    }

    public static Integer getAuditType(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("boss")){
            return ConstuntUtils.LEAVE_AUDIT_COMPANY;
        }else if(subject.hasRole("manager")){
            return ConstuntUtils.LEAVE_AUDIT_DEPT;
        }else if(subject.hasRole("grouper")){
            return ConstuntUtils.LEAVE_AUDIT_GROUP;
        }else {
            return ConstuntUtils.LEAVE_SUBMIT;
        }
    }

    public static Integer getLeaveAuditType(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("boss")){
            return ConstuntUtils.LEAVE_AUDIT_DEPT;
        }else if(subject.hasRole("manager")){
            return ConstuntUtils.LEAVE_AUDIT_GROUP;
        }else if(subject.hasRole("grouper")){
            return ConstuntUtils.LEAVE_SUBMIT;
        }else {
            return 0;
        }
    }


    //根据天数决定审批人的权限
    public static Integer getLeaveAuditType(double days){
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("boss")){
            return ConstuntUtils.LEAVE_AUDIT_COMPANY;
        }else if(subject.hasRole("manager")){
            if (days <=3d){
                return ConstuntUtils.LEAVE_AUDIT_COMPANY;
            }
            return ConstuntUtils.LEAVE_AUDIT_DEPT;
        }else if(subject.hasRole("grouper")){
            if (days <=1d){
                return ConstuntUtils.LEAVE_AUDIT_COMPANY;
            }
            return ConstuntUtils.LEAVE_AUDIT_GROUP;
        }else {
            return 0;
        }
    }
}
