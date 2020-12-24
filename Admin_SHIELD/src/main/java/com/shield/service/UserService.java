package com.shield.service;

import com.shield.model.User;
import com.shield.utils.poi.poiBean.UserPoiModel;
import com.shield.vo.UserVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {

    UserVo queryUserTable(UserVo userVo);

    List<Map<String, Object>> queryEduList();

    List<Map<String, Object>> queryProvinceList();

    List<Map<String, Object>> queryCityList(String code_p);

    List<Map<String, Object>> queryAreaList(String code_c);

    void addUserData(User user);

    User queryUserById(Integer id);

    void updateUserData(User user);

    void removeUser(Integer id);

    void deleteBatchUserData(Integer[] ids);

    User getUserByUserName(String userName);

    Set<String> getPermissionByUserId(Integer userId);

    Set<String> getRoleByUserId(Integer userId);

    //人事管理 根据id查询
    UserVo queryUserInfoById(Integer userId);

    List<UserPoiModel> queryExportUser(UserVo userVo);
}
