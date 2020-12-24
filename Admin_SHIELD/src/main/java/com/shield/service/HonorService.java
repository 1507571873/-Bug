package com.shield.service;

import com.shield.model.Honor;

import java.util.List;

public interface HonorService {
    //新增
    void addHonor(Honor honor);
    //展示数据
    List<Honor> queryHonorDataByUserId(Integer userId);
    //回显
    Honor queryHonorById(Integer id);
    //修改
    void updateHonor(Honor honor);
    //删除
    void deleteHonorById(Integer id);
}
