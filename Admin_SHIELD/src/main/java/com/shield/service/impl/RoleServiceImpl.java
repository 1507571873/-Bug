package com.shield.service.impl;

import com.shield.mapper.RoleMapper;
import com.shield.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.service.impl
 * @ClassName: RoleServiceImpl
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 17:22
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<Map<String, Object>> queryRoleTree(Integer userId) {
        return roleMapper.queryRoleTree(userId);
    }
}
