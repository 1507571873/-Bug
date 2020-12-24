package com.shield.service;

import com.shield.model.Health;

import java.util.List;

public interface HealthService {
    //展示健康信息数据
    Health  queryHealthData(Integer userId);
    //保存的方法
    void saveHealthData(Health health);
}
