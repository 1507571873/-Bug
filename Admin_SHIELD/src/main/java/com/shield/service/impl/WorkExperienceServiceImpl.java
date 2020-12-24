package com.shield.service.impl;

import com.shield.mapper.WorkExperienceMapper;
import com.shield.model.WorkExperience;
import com.shield.service.WorkExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {
    @Resource
    private WorkExperienceMapper workExperienceMapper;

    @Override
    public void addWorkExData(WorkExperience workExperience) {
        if (workExperience.getWorkExId()!=null){
            workExperienceMapper.deleteWorkExData(workExperience.getWorkExId());
            workExperienceMapper.addWorkExData(workExperience);
        }else {
            workExperienceMapper.addWorkExData(workExperience);
        }

    }

    @Override
    public WorkExperience queryWorkExById(Integer userId) {
        return workExperienceMapper.queryWorkExById(userId);
    }
}
