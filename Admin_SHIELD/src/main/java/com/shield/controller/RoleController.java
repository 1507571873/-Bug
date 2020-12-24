package com.shield.controller;

import com.shield.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.controller
 * @ClassName: RoleController
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 17:21
 * @Description:
 */
@Controller
@RequestMapping("RoleController")
public class RoleController {

    @Resource
    RoleService roleService;

    @RequestMapping("queryRoleTree")
    @ResponseBody
    public List<Map<String,Object>> queryRoleTree(Integer userId){
        return roleService.queryRoleTree(userId);
    }
}
