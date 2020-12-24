package com.shield.service.impl;

import com.shield.mapper.HistoryAuditMapper;
import com.shield.model.AuditChecking;
import com.shield.model.Leave;
import com.shield.model.User;
import com.shield.service.HistoryAuditService;
import com.shield.utils.ConstuntUtils;
import com.shield.utils.SubjectUtils;
import com.shield.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HistoryAuditServiceImpl implements HistoryAuditService {

    @Resource
    private HistoryAuditMapper historyAuditMapper;

    /**
     * 查询历史审核记录
     * @param userVo
     */
    @Override
    public void queryHistoryAuditPage(UserVo userVo) {
        Integer auditType = SubjectUtils.getAuditType();
        User user = SubjectUtils.getUsersubject();
        Integer userId = user.getId();
        //查询总条数
        Long count = historyAuditMapper.queryHistoryAuditCount(userVo,auditType,userId, ConstuntUtils.LEAVE_AUDIT_PASS);
        userVo.setCount(count);
        userVo.chaxunIndex();
        List<Leave> list = historyAuditMapper.queryHistoryAuditPage(userVo,auditType,userId, ConstuntUtils.LEAVE_AUDIT_PASS);
        userVo.setData(list);
    }
}
