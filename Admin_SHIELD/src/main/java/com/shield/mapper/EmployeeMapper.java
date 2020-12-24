package com.shield.mapper;

import com.shield.model.Personnel;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //新增
    void saveEmployeeData(Personnel personnel);

    //查询民族
    List<Map<String, Object>> queryMz();

    //删除
    void deleteEmployeeData(Integer id);

    //回显
    Personnel queryEmployeeById(Integer userId);
}
