package com.shield.mapper;

import com.shield.model.User;
import com.shield.utils.poi.poiBean.UserPoiModel;
import com.shield.vo.UserVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserMapper {
    //查询总条数
    Long queryUserCount(UserVo userVo);
    //查询数据
    List<UserVo> queryUserTable(UserVo userVo);
    //查询学历下拉框
    List<Map<String, Object>> queryEduList();
    //查询省份的下拉框
    List<Map<String, Object>> queryProvinceList();
    //查询市/区的下拉框
    List<Map<String, Object>> queryCityList(String code_p);
    //查询县的下拉框
    List<Map<String, Object>> queryAreaList(String code_c);
    //新增数据
    void addUserData(User user);
    //根据用户Id回显
    User queryUserById(Integer id);
    //修改数据
    void updateUserData(User user);
    //删除
    void removeUser(Integer id);
    //plsc
    void deleteBatchUserData(Integer[] ids);

    //登录  根据用户名 查询
    User getUserByUserName(String userName);

    //根据用户Id获取用户的权限关键字
    Set<String> getPermissionByUserId(Integer userId);
    //根据用户Id获取用户的角色关键字
    Set<String> getRoleByUserId(Integer userId);

    //人事管理 根据Id查询
    UserVo queryUserInfoById(Integer userId);

    List<UserPoiModel> queryExportUser(UserVo userVo);
}
