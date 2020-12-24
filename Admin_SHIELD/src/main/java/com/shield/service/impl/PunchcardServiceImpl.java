package com.shield.service.impl;

import com.shield.mapper.PunchcardMapper;
import com.shield.model.Punchcard;
import com.shield.model.User;
import com.shield.service.PunchcardService;
import com.shield.utils.SubjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

@Service
public class PunchcardServiceImpl implements PunchcardService {

    @Resource
    private PunchcardMapper punchcardMapper;

    private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

    @Override
    public void addClockTime() throws ParseException {
        //获取用户信息
        User user = SubjectUtils.getUsersubject();
        Integer userId = user.getId();
        //判断用户当天是否有打卡记录
        Long count = punchcardMapper.isChcarTime(userId);
        if (count == 0){
            Punchcard punchcard = new Punchcard();
            punchcard.setUserId(userId);
            punchcard.setDeptId(user.getDeptId());
            punchcard.setRealName(user.getRealName());
            punchcard.setClockInTime(new Date());
            punchcard.setClockStatus(clockStatus());
            punchcardMapper.addPunchcard(punchcard);
        }
    }

    private Integer clockStatus() throws ParseException {
        String yyyyMMdd = DateFormatUtils.format(new Date(),"yyyy-MM-dd");
        String clockDate = yyyyMMdd+" 08:02:00";
        String absentDate = yyyyMMdd+" 10:00:00";
        //获取毫秒值
        Long clockTime = DateUtils.parseDate(clockDate,parsePatterns).getTime();
        Long absentTime = DateUtils.parseDate(absentDate,parsePatterns).getTime();
        //当前时间毫秒值
        Long nowTime = System.currentTimeMillis();
        if (nowTime>absentTime){
            return 3;
        }
        if(nowTime>clockTime){
            return 2;
        }else {
            return 1;
        }
    }
}
