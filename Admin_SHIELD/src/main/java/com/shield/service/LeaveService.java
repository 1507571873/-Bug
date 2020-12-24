package com.shield.service;

import com.shield.model.Leave;
import com.shield.utils.CommonsReturn;
import com.shield.vo.UserVo;

public interface LeaveService {
    UserVo queryLeavePage(UserVo userVo);

    CommonsReturn addLeave(Leave leave);
}
