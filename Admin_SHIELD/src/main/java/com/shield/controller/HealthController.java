package com.shield.controller;

import com.shield.model.Health;
import com.shield.service.HealthService;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("HealthController")
public class HealthController {

    @Resource
    private HealthService healthService;

    /**
     * 展示健康信息数据
     * @return
     */
    @RequestMapping("queryHealthData")
    @ResponseBody
    public CommonsReturn queryHealthData(Integer userId){
        Health health =  healthService.queryHealthData(userId);
        return CommonsReturn.success(health);
    }

    /**
     * 保存的方法
     * @param health
     * @return
     */
    @RequestMapping("saveHealthData")
    @ResponseBody
    public CommonsReturn saveHealthData(Health health){
        healthService.saveHealthData(health);
        return CommonsReturn.success();
    }
}
