package com.shield.mapper;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.mapper
 * @ClassName: RoleMapper
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 17:24
 * @Description:
 */
public interface RoleMapper {
    List<Map<String, Object>> queryRoleTree(Integer userId);
}
