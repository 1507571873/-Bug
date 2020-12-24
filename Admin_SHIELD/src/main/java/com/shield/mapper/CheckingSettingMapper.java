package com.shield.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckingSettingMapper {
    //新增
    void addNoCheckingDate(@Param("year") String year,@Param("dates") List<String> dates,@Param("userId") Integer userId);
    //删除
    void deleteCheckingDate(String year);

    List<String> selectNoCheckingDate(String year);

    //请假用
    Long getCount(String leaveDate);

}
