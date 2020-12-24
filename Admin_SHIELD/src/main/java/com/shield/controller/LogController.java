package com.shield.controller;

import com.shield.model.Logs;
import com.shield.service.LogService;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("LogController")
public class LogController {

    @Resource
    private LogService logService;

    @RequestMapping("queryLogsTable")
    @ResponseBody
    public Logs queryLogsTable(Logs log){
        return logService.queryLogsTable(log);
    }

    @RequestMapping("rushBDate")
    @ResponseBody
    public Map<String,Object> rushBDate(){
        return logService.rushBDate();
    }
}
