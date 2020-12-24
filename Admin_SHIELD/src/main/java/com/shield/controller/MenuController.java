package com.shield.controller;

import com.shield.model.User;
import com.shield.service.PermissionService;
import com.shield.utils.CommonsReturn;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("MenuController")
public class MenuController {

    @Resource
    private PermissionService permissionService;

    @RequestMapping("menuList")
    @RequiresPermissions("admin")
    public CommonsReturn menuList(){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        List<Map<String,Object>> menuList =permissionService.queryMenuList(user.getId());
        return CommonsReturn.success(menuList);
    }
}
