package com.shield.controller;

import com.shield.model.Permission;
import com.shield.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.controller
 * @ClassName: PermissionController
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 20:35
 * @Description:
 */
@Controller
@RequestMapping("PermissionController")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @RequestMapping("queryPermissionZtree")
    @ResponseBody
    public List<Map<String, Object>> queryPermissionZtree() {
        return permissionService.queryPermissionZtree();
    }

    @RequestMapping("queryByIdZTree")
    @ResponseBody
    public Permission queryByIdZTree(Integer id) {
        return permissionService.queryByIdZTree(id);
    }

    //修改
    @RequestMapping("updateUserData")
    @ResponseBody
    public Map<String,Object> updateUserData(Permission permission){
        Map<String,Object> map = new HashMap<>();
        permissionService.updateUserData(permission);
        map.put("code",400);
        return map;
    }

    //新增
    @RequestMapping("saveUserData")
    @ResponseBody
    public Map<String,Object> saveUserData(Permission permission){
        Map<String,Object> map = new HashMap<>();
        permissionService.saveUserData(permission);
        map.put("code",400);
        return map;
    }

    //查询用户的权限
    @RequestMapping("queryPermissionTree")
    @ResponseBody
    public List<Map<String,Object>> queryPermissionTree(Integer userId){
        List<Map<String, Object>> maps = permissionService.queryPermissionTree(userId);
        return maps;
    }

    //给用户新增权限
    @RequestMapping("addRolePermission")
    @ResponseBody
    public Map<String,Object> addRolePermission(Integer roleId,Integer[] permissionId){
        Map<String,Object> map = new HashMap<>();
        permissionService.addRolePermission(roleId,permissionId);
        map.put("code",400);
        return map;
    }
}