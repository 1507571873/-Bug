package com.shield.controller;

import com.shield.service.CheckingSettingService;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.com.event.COMEventHandler;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 唐吉诃德
 */
@Controller
@RequestMapping("CheckingSettingController")
public class CheckingSettingController {

    @Resource
    private CheckingSettingService checkingSettingService;

    @RequestMapping("addNoCheckingDate")
    @ResponseBody
    public CommonsReturn addNoCheckingDate(String year,String dates){
        checkingSettingService.addNoCheckingDate(year,dates);
        return CommonsReturn.success();
    }

    @RequestMapping("selectNoCheckingDate")
    @ResponseBody
    public List<String> selectNoCheckingDate(String year){
        return checkingSettingService.selectNoCheckingDate(year);
    }


}
