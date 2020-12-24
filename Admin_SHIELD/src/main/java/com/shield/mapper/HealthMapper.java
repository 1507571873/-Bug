package com.shield.mapper;

import com.shield.model.Health;



public interface HealthMapper {
    //展示健康数据
    Health  queryHealthData(Integer userId);
    //保存的方法
    void saveHealthData(Health health);
    //删除
    void deleteHealthData(Integer id);
}
