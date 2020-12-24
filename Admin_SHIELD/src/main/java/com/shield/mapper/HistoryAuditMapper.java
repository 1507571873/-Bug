package com.shield.mapper;

import com.shield.model.AuditChecking;
import com.shield.model.Leave;
import com.shield.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryAuditMapper {

    Long queryHistoryAuditCount(@Param("userVo") UserVo userVo,@Param("auditType") Integer auditType, @Param("userId")Integer userId,@Param("leaveAuditPass") int leaveAuditPass);

    List<Leave> queryHistoryAuditPage(@Param("userVo")UserVo userVo, @Param("auditType") Integer auditType, @Param("userId") Integer userId, @Param("leaveAuditPass") int leaveAuditPass);
}
