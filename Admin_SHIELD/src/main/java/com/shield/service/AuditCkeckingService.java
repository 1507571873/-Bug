package com.shield.service;

import com.shield.model.Leave;
import com.shield.vo.UserVo;

public interface AuditCkeckingService {
    void addLeaveAudit(Leave leave);

    void queryLeaveAuditPage(UserVo userVo);

    //请假审批流程
    void addAudit(Integer ywId, Integer isAgree, String remark);
}
