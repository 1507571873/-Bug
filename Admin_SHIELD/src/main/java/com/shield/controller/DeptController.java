package com.shield.controller;

import com.shield.model.Dept;
import com.shield.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("DeptController")
public class DeptController {

    @Resource
    private DeptService deptService;

    //查询
    @RequestMapping("queryZTree")
    @ResponseBody
    public List<Map<String,Object>> queryZTree(){
        return deptService.queryZTree();
    }

    //删除
    @RequestMapping("removeMenu")
    @ResponseBody
    public Map<String,Object> removeMenu(Integer id){
        Map<String,Object> map = new HashMap<>();
        deptService.removeMenu(id);
        map.put("code",400);
        return map;
    }

    //修改
    @RequestMapping("updateUserData")
    @ResponseBody
    public Map<String,Object> updateUserData(Dept dept){
        Map<String,Object> map = new HashMap<>();
        deptService.updateUserData(dept);
        map.put("code",400);
        return map;
    }

    //新增
    @RequestMapping("saveUserData")
    @ResponseBody
    public Map<String,Object> saveUserData(Dept dept){
        Map<String,Object> map = new HashMap<>();
        deptService.saveUserData(dept);
        map.put("code",400);
        return map;
    }

    //根据Id查询
    @RequestMapping("queryByIdZTree")
    @ResponseBody
    public Dept queryByIdZTree(Integer id){
        return deptService.queryByIdZTree(id);
    }
}
