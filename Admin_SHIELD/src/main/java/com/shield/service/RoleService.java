package com.shield.service;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.service
 * @ClassName: RoleService
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 17:22
 * @Description:
 */
public interface RoleService {
    List<Map<String, Object>> queryRoleTree(Integer userId);
}
