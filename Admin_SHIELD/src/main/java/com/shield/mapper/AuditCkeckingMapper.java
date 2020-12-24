package com.shield.mapper;

import com.shield.model.AuditChecking;
import com.shield.model.Leave;
import com.shield.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuditCkeckingMapper {
    //请假
    void addLeaveAudit(AuditChecking auditChecking);


//----------------------------------请假审核------------------------------
    //总条数
    Long queryLeaveAuditCount(@Param("deptIds") List<Integer> deptIds,@Param("type") Integer type);
    //分页
    List<Leave> queryLeaveAuditPage(@Param("userVo") UserVo userVo,@Param("deptIds")  List<Integer> deptIds,@Param("type") Integer type);

    List<Integer> queryDeptChildrenId(Integer deptId);
//----------------------------------请假审核------------------------------
}
