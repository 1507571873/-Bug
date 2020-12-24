package com.shield.controller;

import com.shield.utils.CommonsReturn;
import com.shield.utils.ReturnCode;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHendler {

    @ExceptionHandler(AuthorizationException.class)
    public void noRightException(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (isAjax(request)){
            response.getWriter().print("noRight");
        }else {
            response.sendRedirect("/noRight.html");
        }
    }

    //全局异常处理
    /*@ExceptionHandler(Exception.class)
    public CommonsReturn exceptionHandler(Exception e) throws IOException {
        e.printStackTrace();
        return CommonsReturn.error(ReturnCode.SYSTEM_ERROR);
    }*/

    private static boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header)) {
            return true;
        }
        return false;
    }
}
