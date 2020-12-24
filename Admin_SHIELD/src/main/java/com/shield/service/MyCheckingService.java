package com.shield.service;

import com.shield.model.Punchcard;

import java.util.List;

public interface MyCheckingService {
    List<Punchcard> queryCheckingByMonth(String month);

    void addAfterWorkTime(String afterWorkTime);
}
