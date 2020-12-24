package com.shield.controller;

import com.shield.service.PunchcardService;
import com.shield.utils.CommonsReturn;
import com.shield.utils.ReturnCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("loginController")
public class loginController {

    @Resource
    private PunchcardService punchcardService;

    //登录的方法
    @RequestMapping("doLogin")
    @ResponseBody
    public CommonsReturn doLogin (@RequestParam("userName")String userName,@RequestParam("password") String password) throws ParseException {
        Map<String,Object> map = new HashMap<>();
        if (StringUtils.isBlank(userName)|| StringUtils.isBlank(password)){
            return CommonsReturn.error(ReturnCode.USERNAME_PASSWORD_NULL);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        }catch (UnknownAccountException e){
            return CommonsReturn.error(ReturnCode.USERNAME_NOEXIST);
        }catch (IncorrectCredentialsException e){
            return CommonsReturn.error(ReturnCode.PASSWORD_ERROR);
        }
        //记录上班时间
        punchcardService.addClockTime();

        return CommonsReturn.success(ReturnCode.LOGIN_OVER);
    }

}
