package com.shield.service;

import java.util.List;

public interface CheckingSettingService {
    void addNoCheckingDate(String year, String dates);

    List<String> selectNoCheckingDate(String year);
}
