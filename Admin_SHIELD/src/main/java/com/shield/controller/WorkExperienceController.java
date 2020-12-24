package com.shield.controller;

import com.shield.model.WorkExperience;
import com.shield.service.WorkExperienceService;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("WorkExperienceController")
public class WorkExperienceController {

    @Resource
    private WorkExperienceService workExperienceService;

    @RequestMapping("addWorkExData")
    @ResponseBody
    public CommonsReturn addWorkExData(WorkExperience workExperience){
        workExperienceService.addWorkExData(workExperience);
        return CommonsReturn.success();
    }

    @RequestMapping("queryWorkExById")
    @ResponseBody
    public CommonsReturn queryWorkExById(Integer userId){
        WorkExperience workExperience = workExperienceService.queryWorkExById(userId);
        return CommonsReturn.success(workExperience);
    }

}
