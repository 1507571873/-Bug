package com.shield.mapper;

import com.shield.model.Permission;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.mapper
 * @ClassName: RolePermissionMapper
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 20:10
 * @Description:
 */
public interface RolePermissionMapper {

    List<Map<String, Object>> queryRoleZtree();

    List<Map<String, Object>> queryPermissionTree(Integer roleId);
}
