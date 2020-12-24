package com.shield.mapper;

import com.shield.model.Logs;
import com.shield.vo.UserVo;

import java.util.List;

public interface LogMapper {

    void addLogsInfo(Logs logs);

    Long queryLogsCount(Logs logs);

    List<UserVo> queryLogsTable(Logs logs);

    List<String> queryRushBMethobName();

    List<Long> queryRushBRunTime();
}
