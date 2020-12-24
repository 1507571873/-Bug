package com.shield.service.impl;

import com.alibaba.fastjson.JSON;
import com.shield.mapper.CheckingSettingMapper;
import com.shield.model.User;
import com.shield.service.CheckingSettingService;
import com.shield.utils.SubjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CheckingSettingServiceImpl implements CheckingSettingService {

    @Resource
    private CheckingSettingMapper checkingSettingMapper;

    @Override
    public void addNoCheckingDate(String year, String dates) {
            //根据年份删除之前的设置
            checkingSettingMapper.deleteCheckingDate(year);
            //判断前台是否传空值
        if(!dates.equals("[]")){
            //增加设置
            List<String> list = JSON.parseArray(dates,String.class);
            User user = SubjectUtils.getUsersubject();
            checkingSettingMapper.addNoCheckingDate(year,list,user.getId());
        }


    }

    @Override
    public List<String> selectNoCheckingDate(String year) {
        return checkingSettingMapper.selectNoCheckingDate(year);
    }
}
