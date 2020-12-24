package com.shield.mapper;

import com.shield.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.mapper
 * @ClassName: PermissionMapper
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 20:37
 * @Description:
 */
public interface PermissionMapper {

    List<Permission> queryPermissionZtree();

    Permission queryByIdZTree(Integer id);

    void updateUserData(Permission permission);

    void saveUserData(Permission permission);

    List<Map<String,Object>> queryPermissionTree(Integer userId);

    void addRolePermission(@Param("roleId") Integer roleId, @Param("permissionId") Integer[] permissionId);


    List<Permission> queryMenuListByUserId(Integer id);

    void removePermission(Integer roleId);
}
