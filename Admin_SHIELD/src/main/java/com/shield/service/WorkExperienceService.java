package com.shield.service;

import com.shield.model.WorkExperience;

public interface WorkExperienceService {
    void addWorkExData(WorkExperience workExperience);

    WorkExperience queryWorkExById(Integer userId);
}
