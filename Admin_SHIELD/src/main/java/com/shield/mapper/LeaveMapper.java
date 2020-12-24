package com.shield.mapper;

import com.shield.model.Leave;
import com.shield.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveMapper {
    Long queryLeaveCount(Integer userId);

    List<Leave> queryLeavePage(@Param("userVo") UserVo userVo,@Param("userId") Integer userId);
    //保存请假的数据
    void addLeaveData(Leave leave);

    Leave queryLeaveDay(Integer ywId);

    //修改请假审批的状态
    void updateLeaveType(@Param("ywId") Integer ywId, @Param("auditType") Integer auditType);
}
