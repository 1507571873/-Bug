package com.shield.aop;

import com.alibaba.fastjson.JSON;
import com.shield.model.Logs;
import com.shield.model.User;
import com.shield.service.LogService;
import com.shield.utils.IpUtil;
import com.shield.utils.SubjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

@Aspect
@Component
@Order(3)
public class LogHandlerAop {

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Resource
    private LogService logService;

    @Pointcut("execution(* com.shield.controller..*.*(..))")
    public void logPointCut(){
    }


    //环绕通知
    @Around("logPointCut() && @annotation(logsAnnotation)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint,LogsAnnotation logsAnnotation) throws Throwable {
        Object obj=null;
        Logs logs = new Logs();
        //获取当前访问的用户信息
        User user = SubjectUtils.getUsersubject();
        logs.setUserId(user.getId());
        logs.setRealName(user.getRealName());
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String args = JSON.toJSONString(joinPoint.getArgs());
        String ipAddr = IpUtil.getIpAddr(httpServletRequest);
        System.out.println(ipAddr);
        logs.setUserIp(ipAddr);
        logs.setClassName(className);
        logs.setMethodName(methodName);
        logs.setArgs(args);
        logs.setCreateTime(new Date());
        logs.setDescribeInfo(logsAnnotation.value());
        long startTime = System.currentTimeMillis();
        try {
            logs.setType(1);
            obj=joinPoint.proceed();
        } catch (Throwable throwable) {
            logs.setType(2);
            throwable.printStackTrace();
            logs.setErrorInfo(exception(throwable));
            throw throwable;
        }finally {
            logs.setRunTime(System.currentTimeMillis()-startTime);
            logService.addLogsInfo(logs);
        }
        return obj;
    }

    /**
     * 将异常信息转化成字符串
     *
     * @param t
     * @return
     * @throws IOException
     */
    private static String exception(Throwable t) throws IOException {
        if (t == null){
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            t.printStackTrace(new PrintStream(baos));
        } finally {
            baos.close();
        }
        return baos.toString();
    }
}