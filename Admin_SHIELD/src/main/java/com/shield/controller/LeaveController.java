package com.shield.controller;

import com.shield.model.Leave;
import com.shield.service.LeaveService;
import com.shield.utils.CommonsReturn;
import com.shield.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("LeaveController")
public class LeaveController {

    @Resource
    private LeaveService leaveService;

    @RequestMapping("queryLeavePage")
    @ResponseBody
    public UserVo queryLeavePage(UserVo userVo){
        leaveService.queryLeavePage(userVo);
        return userVo;
    }

    @RequestMapping("addLeave")
    @ResponseBody
    public CommonsReturn addLeave(Leave leave){
        return CommonsReturn.success(leaveService.addLeave(leave));
    }
}
