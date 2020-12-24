package com.shield.service.impl;

import com.shield.mapper.PermissionMapper;
import com.shield.model.Permission;
import com.shield.service.PermissionService;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.service.impl
 * @ClassName: PermissionServiceImpl
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 20:36
 * @Description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Map<String,Object>> queryPermissionZtree() {
        List<Permission> list = permissionMapper.queryPermissionZtree();
        return getqueryPermissionZtree(list, 0);
    }

    @Override
    public Permission queryByIdZTree(Integer id) {
        return permissionMapper.queryByIdZTree(id);
    }

    @Override
    public void updateUserData(Permission permission) {
        permissionMapper.updateUserData(permission);
    }

    @Override
    public void saveUserData(Permission permission) {
        permissionMapper.saveUserData(permission);
    }

    @Override
    public List<Map<String,Object>> queryPermissionTree(Integer userId) {
        return permissionMapper.queryPermissionTree(userId);
    }

    @Override
    public void addRolePermission(Integer roleId, Integer[] permissionId) {
        permissionMapper.removePermission(roleId);
        if (permissionId !=null){
            permissionMapper.addRolePermission(roleId,permissionId);
        }

    }

    @Override
    public List<Map<String, Object>> queryMenuList(Integer id) {
        List<Permission> list = permissionMapper.queryMenuListByUserId(id);
        return getRightTree(list,0);
    }

    private List<Map<String,Object>> getRightTree(List<Permission> plist,Integer pid){
        List<Map<String,Object>> list = new ArrayList<>();
        plist.forEach(permission -> {
            Map<String,Object> map = null;
            if (pid.equals(permission.getPid())){
                map = new HashMap<>();
                map.put("pname",permission.getPname());
                map.put("purl",permission.getPurl());
                map.put("children",getRightTree(plist,permission.getId()));
            }
            if (map !=null){
                list.add(map);
            }
        });
        return list;
    }

    private List<Map<String,Object>> getqueryPermissionZtree(List<Permission> list,Integer pid){
        List<Map<String,Object>> list1 = new ArrayList<>();
         list.forEach(permission -> {
            Map<String,Object> map = null;
            if (pid.equals(permission.getPid())){
                map = new HashMap<>();
                map.put("id",permission.getId());
                map.put("name",permission.getPname());
                map.put("children",getqueryPermissionZtree(list,permission.getId()));
            }
            if (map!=null){
                list1.add(map);
            }
        });
        return list1;
    }
}
