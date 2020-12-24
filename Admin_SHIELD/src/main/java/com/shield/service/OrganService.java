package com.shield.service;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.service
 * @ClassName: OrganService
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 11:41
 * @Description:
 */
public interface OrganService {


    List<Map<String, Object>> queryOrganZtree();

    void addRoleToUser(Integer userId, Integer[] roleArr);

    List<Map<String, Object>> queryOrganTree(Integer roleId);
}
