package com.shield.service.impl;

import com.shield.mapper.MyCheckingMapper;
import com.shield.model.Punchcard;
import com.shield.model.User;
import com.shield.service.MyCheckingService;
import com.shield.utils.SubjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MyCheckingServiceImpl implements MyCheckingService {

    @Resource
    private MyCheckingMapper myCheckingMapper;

    private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

    @Override
    public List<Punchcard> queryCheckingByMonth(String month) {
        //获取用户信息
        User user = SubjectUtils.getUsersubject();
        Integer userId = user.getId();
        return myCheckingMapper.queryCheckingByMonth(month,userId);
    }

    @Override
    public void addAfterWorkTime(String afterWorkTime) {
        Integer afterStatus = afterWorkStatus(afterWorkTime);
        User user = SubjectUtils.getUsersubject();
        Integer userId = user.getId();
        myCheckingMapper.updateAfterTime(userId,afterWorkTime,afterStatus);
    }

    private Integer  afterWorkStatus(String afterWorkTime){
        String yyyyMMdd = DateFormatUtils.format(new Date(),"yyyy-MM-dd");
        String afterDate = yyyyMMdd+" 18:00:00";
        try {
            Long afterTime = DateUtils.parseDate(afterWorkTime,parsePatterns).getTime();
            Long goTime = DateUtils.parseDate(afterDate,parsePatterns).getTime();
            if (afterTime>=goTime){
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 2;
    }
}
