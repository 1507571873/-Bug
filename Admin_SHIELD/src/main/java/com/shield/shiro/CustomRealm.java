package com.shield.shiro;

import com.shield.model.User;
import com.shield.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Resource
    private UserService userService; //用于获取用户的信息

    /**
     * 用户授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println("用户授权开始-----------" + user.getUserName() + "-------------------");
        //判断用户是否为空
        if (user != null) {
            //获取用户Id
            Integer userId = user.getId();
            //根据用户的ID获取用户的权限和角色
            Set<String> permissionSet = userService.getPermissionByUserId(userId);
            Set<String> roleSet = userService.getRoleByUserId(userId);
            //将我们的角色和权限交给shiro框架进行管理
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRoles(roleSet);
            simpleAuthorizationInfo.addStringPermissions(permissionSet);
            System.out.println("授权结束--------------" + user.getUserName() + "-----------------");
            return simpleAuthorizationInfo;
        }
        return null;
    }

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        User user = userService.getUserByUserName(userName);
        if (user != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user,
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSaltCode()),
                    getName()
            );
            return authenticationInfo;
        } else {
            throw new UnknownAccountException();
        }
    }
}
