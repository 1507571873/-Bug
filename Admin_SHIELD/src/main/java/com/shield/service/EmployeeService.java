package com.shield.service;

import com.shield.model.Personnel;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    //新增
    void saveEmployeeData(Personnel personnel);

    //查询民族
    List<Map<String,Object>> queryMz();

    //回显
    Personnel queryEmployeeById(Integer userId);
}
