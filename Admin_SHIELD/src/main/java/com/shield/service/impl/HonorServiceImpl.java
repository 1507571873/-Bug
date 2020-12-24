package com.shield.service.impl;

import com.shield.mapper.HonorMapper;
import com.shield.model.Honor;
import com.shield.service.HonorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HonorServiceImpl implements HonorService {

    @Resource
    private HonorMapper honorMapper;

    /**
     * 新增
     * @param honor
     */
    @Override
    public void addHonor(Honor honor) {
        honorMapper.addHonor(honor);
    }

    /**
     * 展示数据
     * @param userId
     * @return
     */

    @Override
    public List<Honor> queryHonorDataByUserId(Integer userId) {
        return honorMapper.queryHonorDataByUserId(userId);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @Override
    public Honor queryHonorById(Integer id) {
        return honorMapper.queryHonorById(id);
    }

    /**
     * 修改
     * @param honor
     */
    @Override
    public void updateHonor(Honor honor) {
        honorMapper.updateHonor(honor);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteHonorById(Integer id) {
        honorMapper.deleteHonorById(id);
    }
}
