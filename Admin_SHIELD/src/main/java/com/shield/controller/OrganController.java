package com.shield.controller;

import com.shield.service.OrganService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.controller
 * @ClassName: OrganController
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 11:40
 * @Description:
 */
@Controller
@RequestMapping("OrganController")
public class OrganController {

    @Resource
    private OrganService organService;


    @RequestMapping("queryOrganZtree")
    @ResponseBody
    public List<Map<String, Object>> queryOrganZtree() {
        return organService.queryOrganZtree();
    }

    @RequestMapping("addRoleToUser")
    @ResponseBody
    public String addRoleToUser(Integer userId, Integer[] roleArr) {
        organService.addRoleToUser(userId, roleArr);
        return "success";
    }

    @RequestMapping("queryOrganTree")
    @ResponseBody
    public List<Map<String, Object>> queryOrganTree(Integer roleId) {
        return organService.queryOrganTree(roleId);
    }


}
