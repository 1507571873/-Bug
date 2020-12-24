package com.shield.service.impl;

import com.shield.mapper.HealthMapper;
import com.shield.model.Health;
import com.shield.service.HealthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HealthServiceImpl implements HealthService {

    @Resource
    private HealthMapper healthMapper;

    /**
     * 展示健康信息数据
     * @return
     */
    @Override
    public Health  queryHealthData(Integer userId) {
        return healthMapper.queryHealthData(userId);
    }

    /**
     * 保存的方法
     * @param health
     */
    @Override
    public void saveHealthData(Health health) {
        if (health.getId()!=null){
            healthMapper.deleteHealthData(health.getId());
            healthMapper.saveHealthData(health);
        }else {
            healthMapper.saveHealthData(health);
        }

    }
}
