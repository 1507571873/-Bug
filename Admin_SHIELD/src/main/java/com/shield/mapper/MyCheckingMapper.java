package com.shield.mapper;

import com.shield.model.Punchcard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyCheckingMapper {

    List<Punchcard> queryCheckingByMonth(@Param("month") String month,@Param("userId")  Integer userId);

    void updateAfterTime(@Param("userId")Integer userId,@Param("afterWorkTime") String afterWorkTime,@Param("afterStatus") Integer afterStatus);
}
