package com.shield.service;

import com.shield.vo.UserVo;

public interface HistoryAuditService {
    //查询历史审核记录
    void queryHistoryAuditPage(UserVo userVo);
}
