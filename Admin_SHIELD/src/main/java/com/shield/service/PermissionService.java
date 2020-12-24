package com.shield.service;

import com.shield.model.Permission;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.service
 * @ClassName: PermissionService
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 20:36
 * @Description:
 */
public interface PermissionService {
    List<Map<String,Object>> queryPermissionZtree();

    Permission queryByIdZTree(Integer id);

    void updateUserData(Permission permission);

    void saveUserData(Permission permission);

    List<Map<String,Object>> queryPermissionTree(Integer userId);

    void addRolePermission(Integer roleId, Integer[] permissionId);

    List<Map<String, Object>> queryMenuList(Integer id);
}
