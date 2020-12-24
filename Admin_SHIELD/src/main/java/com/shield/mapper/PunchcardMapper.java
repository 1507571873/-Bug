package com.shield.mapper;

import com.shield.model.Punchcard;

public interface PunchcardMapper {

    Long isChcarTime(Integer userId);
    //上班打卡新增
    void addPunchcard(Punchcard punchcard);
}
