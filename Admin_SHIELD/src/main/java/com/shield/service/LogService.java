package com.shield.service;

import com.shield.model.Logs;

import java.util.List;
import java.util.Map;

public interface LogService {

    void addLogsInfo(Logs logs);

    Logs queryLogsTable(Logs logs);


    Map<String, Object> rushBDate();
}
