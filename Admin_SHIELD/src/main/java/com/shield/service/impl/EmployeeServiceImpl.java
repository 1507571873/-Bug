package com.shield.service.impl;

import com.shield.mapper.EmployeeMapper;
import com.shield.model.Personnel;
import com.shield.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 新增
     * @param personnel
     */
    @Override
    public void saveEmployeeData(Personnel personnel) {
        if (personnel.getId()!=null){
            employeeMapper.deleteEmployeeData(personnel.getId());
            employeeMapper.saveEmployeeData(personnel);
        }else{
            employeeMapper.saveEmployeeData(personnel);
        }

    }


    /**
     * 查询民族
     * @return
     */
    @Override
    public List<Map<String,Object>> queryMz() {
        return employeeMapper.queryMz();
    }

    /**
     * 回显
     * @param userId
     * @return
     */
    @Override
    public Personnel queryEmployeeById(Integer userId) {
        return employeeMapper.queryEmployeeById(userId);
    }
}
