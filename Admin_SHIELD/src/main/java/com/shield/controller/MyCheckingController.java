package com.shield.controller;

import com.shield.model.Punchcard;
import com.shield.service.MyCheckingService;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("MyCheckingController")
public class MyCheckingController {

    @Resource
    private MyCheckingService myCheckingService;

    @RequestMapping("queryCheckingByMonth")
    @ResponseBody
    public List<Punchcard> queryCheckingByMonth(String month){
       return myCheckingService.queryCheckingByMonth(month);
    }

    @RequestMapping("addAfterWorkTime")
    @ResponseBody
    public CommonsReturn addAfterWorkTime(String afterWorkTime){
        myCheckingService.addAfterWorkTime(afterWorkTime);
        return CommonsReturn.success();
    }
}
