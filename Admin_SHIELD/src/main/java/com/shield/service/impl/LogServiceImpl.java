package com.shield.service.impl;

import com.shield.mapper.LogMapper;
import com.shield.model.Logs;
import com.shield.service.LogService;
import com.shield.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public void addLogsInfo(Logs logs) {
        logMapper.addLogsInfo(logs);
    }

    /**
     * 条件查询
     * @param logs
     * @return
     */
    @Override
    public Logs queryLogsTable(Logs logs) {
        //查询总条数
        Long count = logMapper.queryLogsCount(logs);
        logs.setCount(count);
        //计算其实下表
        logs.chaxunIndex();
        //查询数据
        List<UserVo> list = logMapper.queryLogsTable(logs);
        logs.setData(list);
        return logs;
    }

    @Override
    public Map<String, Object> rushBDate() {
        Map<String,Object> map = new HashMap<>();
        List<String> list = logMapper.queryRushBMethobName();
        List<Long> list1 = logMapper.queryRushBRunTime();
        map.put("xAxis",list);
        map.put("series",list1);
        return map;
    }
}
