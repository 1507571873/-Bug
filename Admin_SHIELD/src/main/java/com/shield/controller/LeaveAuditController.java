package com.shield.controller;

import com.shield.service.AuditCkeckingService;
import com.shield.utils.CommonsReturn;
import com.shield.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("LeaveAuditController")
public class LeaveAuditController {

    @Resource
    private AuditCkeckingService auditCkeckingService;

    @RequestMapping("queryLeaveAuditPage")
    @ResponseBody
    public UserVo queryLeaveAuditPage(UserVo userVo){
        auditCkeckingService.queryLeaveAuditPage(userVo);
        return userVo;
    }

    @RequestMapping("addLeaveAudit")
    @ResponseBody
    public CommonsReturn addAudit(Integer ywId,Integer isAgree,String remark,Integer ywlx){
        if (ywlx == 1){
            auditCkeckingService.addAudit(ywId,isAgree,remark);
        }
        return CommonsReturn.success();
    }
}
