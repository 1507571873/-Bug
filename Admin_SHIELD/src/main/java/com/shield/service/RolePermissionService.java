package com.shield.service;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.service
 * @ClassName: RolePermissionService
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 20:08
 * @Description:
 */
public interface RolePermissionService {

    List<Map<String, Object>> queryRoleZtree();

    List<Map<String, Object>> queryPermissionTree(Integer roleId);
}
