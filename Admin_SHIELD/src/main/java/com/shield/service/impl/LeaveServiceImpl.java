package com.shield.service.impl;

import com.shield.mapper.CheckingSettingMapper;
import com.shield.mapper.LeaveMapper;
import com.shield.model.Leave;
import com.shield.model.User;
import com.shield.service.AuditCkeckingService;
import com.shield.service.LeaveService;
import com.shield.utils.CommonsReturn;
import com.shield.utils.ConstuntUtils;
import com.shield.utils.ReturnCode;
import com.shield.utils.SubjectUtils;
import com.shield.vo.UserVo;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Resource
    private LeaveMapper leaveMapper;
    @Resource
    private CheckingSettingMapper checkingSettingMapper;
    @Resource
    private AuditCkeckingService auditCkeckingService;
    @Override
    public UserVo queryLeavePage(UserVo userVo) {
        User user = SubjectUtils.getUsersubject();
        Integer userId = user.getId();
        Long count = leaveMapper.queryLeaveCount(userId);
        userVo.setCount(count);
        userVo.chaxunIndex();
        List<Leave> list = leaveMapper.queryLeavePage(userVo, userId);
        userVo.setData(list);
        return userVo;
    }

    @Override
    public CommonsReturn addLeave(Leave leave) {
        User user = SubjectUtils.getUsersubject();
        leave.setUserId(user.getId());
        leave.setRealName(user.getRealName());
        leave.setDeptId(user.getDeptId());
        leave.setAuditStatus(SubjectUtils.getAuditType());

        //计算请假天数
        getleaveDays(leave);
        if (leave.getLeaveDays()==0.0d){
            return CommonsReturn.error(ReturnCode.LEAVE_TIME_ERROR);
        }
        //开始保存
        leaveMapper.addLeaveData(leave);

        //发起请假的审批流程
        auditCkeckingService.addLeaveAudit(leave);
        return CommonsReturn.success();
    }

    //计算请假天数    我们的请假天数是以半天为单位的 也就是说 一天被分为上半天和下半天
    private void getleaveDays(Leave leave) {
        try {
            Integer startType = leave.getStartType();
            Integer endType = leave.getEndType();
            String startDate = DateFormatUtils.format(leave.getStartTime(), "yyyy-MM-dd");
            String endDate = DateFormatUtils.format(leave.getEndTime(), "yyyy-MM-dd");
            //判断请假是上半天开始还是下半天 当type==1的时候说明就是从上半天开始请 否则就是下半天
            if (startType == 1) {
                leave.setStartTime(DateUtils.parseDate(startDate + " 08:00:00", ConstuntUtils.parsePatterns));
            } else {
                leave.setStartTime(DateUtils.parseDate(startDate + " 14:00:00", ConstuntUtils.parsePatterns));
            }
            //再判断返回时间就是请假的结束时间是上半天还是下半天 当type==1时说明是到上半天 否则就是下半天
            if (endType == 1) {
                leave.setEndTime(DateUtils.parseDate(endDate + " 12:00:00", ConstuntUtils.parsePatterns));
            } else {
                leave.setEndTime(DateUtils.parseDate(endDate + " 18:00:00", ConstuntUtils.parsePatterns));
            }

         //现在为同一天的情况
            //判断是否为同一天 为了防止时间错乱 今天的下午开始请假 当天的上午返回
            if (startDate.equals(endDate)) {
                //当请假时间的开始和结束为同一天  开始时间为 下午 返回时间为上午则进入if判断
                if (endType == 2 && startType == 1) {
                    //如果是这种情况则请假天数 设置为零 然后可以进行判断
                    leave.setLeaveDays(0d);
                    //程序走到这里 就没有走下去的必要了 所以直接return结束程序
                    return;
                    //请假的开始时间和结束时间都为上午或者下午 就说明是请了半天假 所以记0.5天
                } else if (startType==endType) {
                    //记0.5天
                    leave.setLeaveDays(0.5d);
                    //否则就是上午8.开始请假到下午的18. 记为1天
                }else {
                    //记1天
                    leave.setLeaveDays(1.0d);
                }
            }else {
                //不是同一天的情况  不同天的 要排除不考勤日期
                double days=0.0d;
                //dateList 里放的都是需要考勤的日期
                List<String> dateList=getDateList(startDate,endDate);
                //对dateList进行循环
                for(String day:dateList){
                    //判断day是否等于请假的开始时间
                    if (day.equals(startDate)){
                        //在进行判断是否为上班天
                        if(startType == 1){
                            //上半天加1天
                            days+=1d;
                        }else {
                            //下半天加0.5天
                            days+=0.5d;
                        }
                        //判断day是否等于请假的结束时间
                    }else if (day.equals(endDate)){
                        //在进行判断是否为上班天
                        if(endType == 1){
                            //上半天加0.5天
                            days+=0.5d;
                        }else {
                            //下半天加1天
                            days+=1d;
                        }
                    }else{
                        //既不是开始时间也不是结束时间 说明是中间的整天 所以 +1
                        days+=1d;
                    }
                };
                leave.setLeaveDays(days);

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public List<String> getDateList(String startDate,String endDate){
        try {
            Date sDate=DateUtils.parseDate(startDate,ConstuntUtils.parsePatterns);
            Date eDate=DateUtils.parseDate(endDate,ConstuntUtils.parsePatterns);
            //java 日历函数
            Calendar calendar=Calendar.getInstance();
            //设置开始时间  然后循环 然后每间隔一天就+1 加到结束时间为止
            calendar.setTime(sDate);
            List<String> dayList=new ArrayList<>();
            //如果现在的时间在结束时间的前面就可以进入循环
            while (!calendar.getTime().after(eDate)) {
                String leaveDate = DateFormatUtils.format(calendar.getTime(),"yyyy-MM-dd");
                Long count = checkingSettingMapper.getCount(leaveDate);
                if(count == 0 ){
                    dayList.add(leaveDate);
                }
                //每次循环天数加1
                calendar.add(Calendar.DAY_OF_MONTH,1);
            }
            return dayList;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
