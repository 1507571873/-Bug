package com.shield.controller;

import com.shield.service.HistoryAuditService;
import com.shield.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("HistoryAuditController")
public class HistoryAuditController {

    @Resource
    private HistoryAuditService historyAuditService;

    /**
     * 查询历史审核记录
     * @param userVo
     * @return
     */
    @RequestMapping("queryHistoryAuditPage")
    @ResponseBody
    public UserVo queryHistoryAuditPage(UserVo userVo){
        historyAuditService.queryHistoryAuditPage(userVo);
        return userVo;
    }
}
