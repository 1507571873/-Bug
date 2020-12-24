package com.shield.service.impl;

import com.shield.mapper.UserMapper;
import com.shield.model.User;
import com.shield.service.UserService;
import com.shield.utils.MD5Util;
import com.shield.utils.SalfUtil;
import com.shield.utils.poi.poiBean.UserPoiModel;
import com.shield.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询用户表数据
     * @param userVo
     * @return
     */
    @Override
    public UserVo queryUserTable(UserVo userVo) {
        //查询总条数
       Long count = userMapper.queryUserCount(userVo);
        userVo.setCount(count);
        //计算其实下表
        userVo.chaxunIndex();
        //查询数据
        List<UserVo> list = userMapper.queryUserTable(userVo);
        userVo.setData(list);
        return userVo;
    }

    /**
     * 查询学历下拉框
     * @return List<Map<String, Object>>
     */
    @Override
    public List<Map<String, Object>> queryEduList() {
        return userMapper.queryEduList();
    }

    /**
     * 查询省
     * @return
     */
    @Override
    public List<Map<String, Object>> queryProvinceList() {
        return userMapper.queryProvinceList();
    }

    /**
     * 查询市
     * @param code_p
     * @return
     */
    @Override
    public List<Map<String, Object>> queryCityList(String code_p) {
        return userMapper.queryCityList(code_p);
    }

    /**
     * 查询县
     * @param code_c
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAreaList(String code_c) {
        return userMapper.queryAreaList(code_c);
    }

    /**
     * 新增
     * @param user
     */
    @Override
    public void addUserData(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setSaltCode(uuid);
        user.setPassword(SalfUtil.md5(MD5Util.MD5Encode("123456"),uuid));
        userMapper.addUserData(user);
    }

    /**
     * 根据Id查询单条数据回显
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    /**
     * 修改
     * @param user
     */
    @Override
    public void updateUserData(User user) {
        userMapper.updateUserData(user);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void removeUser(Integer id) {
        userMapper.removeUser(id);
    }

    @Override
    public void deleteBatchUserData(Integer[] ids) {
        userMapper.deleteBatchUserData(ids);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public Set<String> getPermissionByUserId(Integer userId) {
        return userMapper.getPermissionByUserId(userId);
    }

    @Override
    public Set<String> getRoleByUserId(Integer userId) {
        return userMapper.getRoleByUserId(userId);
    }

    //人事管理 根据id查询
    @Override
    public UserVo queryUserInfoById(Integer userId) {
        return userMapper.queryUserInfoById(userId);
    }

    @Override
    public List<UserPoiModel> queryExportUser(UserVo userVo) {
        return userMapper.queryExportUser(userVo);
    }

}
