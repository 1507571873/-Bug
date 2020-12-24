package com.shield.controller;

import com.shield.model.Personnel;
import com.shield.service.EmployeeService;
import com.shield.utils.CommonsReturn;
import com.shield.utils.ReturnCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("EmployeeController")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 新增
     * @param personnel
     * @return
     */
    @RequestMapping("saveEmployeeData")
    @ResponseBody
    public CommonsReturn saveEmployeeData (Personnel personnel){
        employeeService.saveEmployeeData(personnel);
        return CommonsReturn.success(ReturnCode.SUCCESS);
    }

    /**
     * 查询民族
     * @return
     */
    @RequestMapping("queryMz")
    @ResponseBody
    public CommonsReturn queryMz (){
        List<Map<String,Object>> mz = employeeService.queryMz();
        return CommonsReturn.success(ReturnCode.SUCCESS,mz);
    }

    /**
     * 回显
     * @param userId
     * @return
     */
    @RequestMapping("queryEmployeeById")
    @ResponseBody
    public CommonsReturn queryEmployeeById(Integer userId){
        Personnel personnel = employeeService.queryEmployeeById(userId);
        return CommonsReturn.success(ReturnCode.SUCCESS,personnel);
    }
}
