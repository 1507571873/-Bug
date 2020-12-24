package com.shield.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("JumpController")
public class JumpController {

    @RequestMapping("loginover")
    public String loginover(){
        return "system/loginover";
    }

    //用户页面
    @RequestMapping("toUser")
    @RequiresPermissions("queryuser")
    public String toUser(){
        return "system/user";
    }

    //组织
    @RequestMapping("toOrgan")
    public String toOrgan(){
        return "system/organ";
    }


    //权限
    @RequestMapping("toPermission")
    @RequiresPermissions("permission")
    public String toPermission(){
        return "system/permission";
    }

    //用户角色
    @RequestMapping("toUserRole")
    public String toUserRole(){
        return "system/userRole";
    }


    //角色权限
    @RequestMapping("toRolePermission")
    @RequiresPermissions("role")
    public String toRolePermission(){
        return "system/rolepermission";
    }


    //人事管理-----------------------------------------------------------------------------------------

    //跳转基本信息
    @RequestMapping("toEmployeeFile")
    @RequiresPermissions("employeeFile")
    public String toEmployeeFile(){
        return "personnel/employeeFile";
    }

    //跳转到人员信息
    @RequestMapping("toEmpInfo")
    public String toEmpInfo(){
        return "personnel/employeeInfo";
    }

    //跳转工作经历
    @RequestMapping("toWorkExperience")
    public String toWorkExperience(){
        return "personnel/workexperience";
    }

    //跳转到教育经历
    @RequestMapping("toContactAddress")
    public String toContactAddress(){
        return "personnel/ContactAddress";
    }

    //跳转到个人荣誉
    @RequestMapping("toHonor")
    public String toHonor(){
        return "personnel/honor";
    }

    //跳转到日志管理
    @RequestMapping("toLogs")
    public String toLogs(){
        return "system/logs";
    }

    //跳转到日志展示
    @RequestMapping("toShowLogs")
    public String toShowLogs(){
        return "system/showlogs";
    }

    //跳转到性能统计
    @RequestMapping("toRushB")
    public String toRushB(){
        return "system/rushb";
    }

    //跳转到健康检查
    @RequestMapping("toHealth")
    public String toHealth(){
        return "personnel/health";
    }

    //跳转到教育经理
    @RequestMapping("toEduXperiences")
    public String toEduXperiences(){
        return "personnel/eduxperiences";
    }

    //---------------------------------------------考勤------------------------------------------------

    //跳转到考勤
    @RequestMapping("toChecking")
    public String toChecking(){
        return "checking/checking";
    }

    //跳转到我的考勤
    @RequestMapping("toMyChecking")
    public String toMyChecking(){
        return "checking/mychecking";
    }

    //跳转到个人请假
    @RequestMapping("toLeave")
    public String toLeave(){
        return "checking/myleave";
    }

    //跳转到考勤考核
    @RequestMapping("toCheckingAudit")
    public String toCheckingAudit(){
        return "checking/auditchecking";
    }
}
