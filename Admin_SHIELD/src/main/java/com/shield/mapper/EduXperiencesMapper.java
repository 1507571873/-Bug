package com.shield.mapper;

import com.shield.model.EduXperience;

import java.util.List;

public interface EduXperiencesMapper {
    //数据展示
    List<EduXperience> queryEduXperData(Integer userId);
    //新增
    void addEduXper(EduXperience eduXperience);
    //删除
    void deleteEduXper(Integer id);
    //回显
    EduXperience queryEduXperById(Integer id);
    //修改
    void updateEduXper(EduXperience eduXperience);
}
