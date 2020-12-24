package com.shield.mapper;

import com.shield.model.WorkExperience;

public interface WorkExperienceMapper {
    void addWorkExData(WorkExperience workExperience);

    WorkExperience queryWorkExById(Integer userId);

    void deleteWorkExData(Integer workExId);
}
