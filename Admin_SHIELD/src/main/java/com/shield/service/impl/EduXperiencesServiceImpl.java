package com.shield.service.impl;

import com.shield.mapper.EduXperiencesMapper;
import com.shield.model.EduXperience;
import com.shield.service.EduXperiencesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EduXperiencesServiceImpl implements EduXperiencesService {

    @Resource
    private EduXperiencesMapper eduXperiencesMapper;

    /**
     * 数据展示
     * @param userId
     * @return
     */
    @Override
    public List<EduXperience> queryEduXperData(Integer userId) {
        return eduXperiencesMapper.queryEduXperData(userId);
    }

    /**
     * 新增
     * @param eduXperience
     */
    @Override
    public void addEduXper(EduXperience eduXperience) {
        eduXperiencesMapper.addEduXper(eduXperience);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteEduXper(Integer id) {
        eduXperiencesMapper.deleteEduXper(id);
    }

    /**
     *  回显
     * @param id
     * @return
     */
    @Override
    public EduXperience queryEduXperById(Integer id) {
        return eduXperiencesMapper.queryEduXperById(id);
    }

    /**
     *  修改
     * @param eduXperience
     */
    @Override
    public void updateEduXper(EduXperience eduXperience) {
        eduXperiencesMapper.updateEduXper(eduXperience);
    }
}
