package com.shield.service.impl;

import com.shield.mapper.RolePermissionMapper;
import com.shield.model.Permission;
import com.shield.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.service.impl
 * @ClassName: RolePermissionServiceImpl
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 20:08
 * @Description:
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Resource
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public List<Map<String, Object>> queryRoleZtree() {
        return rolePermissionMapper.queryRoleZtree();
    }

    @Override
    public List<Map<String, Object>> queryPermissionTree(Integer roleId) {
        return  rolePermissionMapper.queryPermissionTree(roleId);
    }
}
