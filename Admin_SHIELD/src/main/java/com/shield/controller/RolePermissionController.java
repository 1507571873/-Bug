package com.shield.controller;

import com.shield.service.RolePermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.controller
 * @ClassName: RolePermissionController
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 20:06
 * @Description:
 */
@Controller
@RequestMapping("RolePermissionController")
public class RolePermissionController {

    @Resource
    RolePermissionService rolePermissionService;

    @RequestMapping("queryRoleZtree")
    @ResponseBody
    public List<Map<String,Object>> queryRoleZtree(){
        return rolePermissionService.queryRoleZtree();
    }

    @RequestMapping("queryPermissionTree")
    @ResponseBody
    public List<Map<String,Object>> queryPermissionTree(Integer roleId){
        return rolePermissionService.queryPermissionTree(roleId);
    }
}
