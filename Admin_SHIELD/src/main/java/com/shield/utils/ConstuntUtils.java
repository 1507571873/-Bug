package com.shield.utils;

public class ConstuntUtils {

    //用户的session key
    public static final String shiro_session_prefix = "shield-session:";
    //权限的前缀
    public static final String prefix="SHIELD_PERMISSION:";
    //session失效时间
    public static final int SESSION_TIMEOUT=300;
    //已提交
    public static final int LEAVE_SUBMIT=100;
    //组长审批通过
    public static final int LEAVE_AUDIT_GROUP=200;
    //部门经理审批通过
    public static final int LEAVE_AUDIT_DEPT=300;
    //公司领导审批通过
    public static final int LEAVE_AUDIT_COMPANY=400;
    //审批不通过
    public static final int LEAVE_AUDIT_PASS=500;

    public static final String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };
}
