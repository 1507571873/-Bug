package com.shield.service.impl;

import com.shield.mapper.AuditCkeckingMapper;
import com.shield.mapper.LeaveMapper;
import com.shield.model.AuditChecking;
import com.shield.model.Leave;
import com.shield.model.User;
import com.shield.service.AuditCkeckingService;
import com.shield.utils.CommonsReturn;
import com.shield.utils.ConstuntUtils;
import com.shield.utils.SubjectUtils;
import com.shield.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditCkeckingServiceImpl implements AuditCkeckingService {

    @Resource
    private AuditCkeckingMapper auditCkeckingMapper;

    @Resource
    private LeaveMapper leaveMapper;

    //请假审批
    public static final Integer LEAVE=1;
    //加班审批
    public static final Integer ADDWORD=2;
    //补签审批
    public static final Integer PETROACTIVE=3;

    @Override
    public void addLeaveAudit(Leave leave) {
        AuditChecking auditChecking = new AuditChecking();
        auditChecking.setDeptId(leave.getDeptId());
        auditChecking.setUserId(leave.getUserId());
        auditChecking.setBusinessId(leave.getId());
        auditChecking.setBusunessType(LEAVE);
        auditChecking.setAuditType(SubjectUtils.getAuditType());
        auditCkeckingMapper.addLeaveAudit(auditChecking);
    }


    /**
     * 请假审核
     * @param userVo
     */
    @Override
    public void queryLeaveAuditPage(UserVo userVo) {
        User user = SubjectUtils.getUsersubject();
        Integer deptId = user.getDeptId();
        List<Integer> deptIds = auditCkeckingMapper.queryDeptChildrenId(deptId);
        if (CollectionUtils.isEmpty(deptIds)){
            deptIds =new ArrayList<>();
        }
        deptIds.add(deptId);
        Integer type = SubjectUtils.getLeaveAuditType();
        Long count = auditCkeckingMapper.queryLeaveAuditCount(deptIds,type);
        userVo.setCount(count);
        userVo.chaxunIndex();
        List<Leave> list = auditCkeckingMapper.queryLeaveAuditPage(userVo,deptIds,type);
        userVo.setData(list);
    }


    /**
     * 请假审批流程
     * @param ywId
     * @param isAgree
     * @param remark
     * @param ywlx
     */
    @Override
    public void addAudit(Integer ywId, Integer isAgree, String remark) {
        AuditChecking auditChecking = new AuditChecking();
        //判断审批是否同意
        if(isAgree==2){
            //审核不同意直接 不同意的状态
            auditChecking.setAuditType(ConstuntUtils.LEAVE_AUDIT_PASS);
        }else {
            //获取请假天数
            Leave leave = leaveMapper.queryLeaveDay(ywId);
            //调用封装的方法 根据请假天数去判断审核的状态
            auditChecking.setAuditType(SubjectUtils.getLeaveAuditType(leave.getLeaveDays()));
        }
        auditChecking.setBusunessType(1);
        auditChecking.setBusinessId(ywId);
        auditChecking.setAuditIdea(remark);
        //获取用户对象
        User user = SubjectUtils.getUsersubject();
        //这个是审批人的部门Id
        auditChecking.setDeptId(user.getDeptId());
        //这个id的作用是审批人的Id 并不是被审批人的Id
        auditChecking.setUserId(user.getId());
        //刷新数据库数据
        auditCkeckingMapper.addLeaveAudit(auditChecking);
        //修改请假审批 的状态
        leaveMapper.updateLeaveType(ywId,auditChecking.getAuditType());
    }


}
