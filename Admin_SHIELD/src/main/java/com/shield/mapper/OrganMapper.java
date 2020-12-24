package com.shield.mapper;

import com.shield.model.Organ;
import com.shield.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package: com.shield.mapper
 * @ClassName: OrganMapper
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 11:42
 * @Description:
 */
public interface OrganMapper {
    List<Organ> queryOrganZtree();

    void addRoleToUser(@Param("userId") Integer userId,@Param("roleArr") Integer[] roleArr);

    void removeRoleToUser(Integer userId);

    List<Organ> queryOrganTree(Integer roleId);

    User getUserById(Integer userId);
}
