package com.aaa.af.shiro;

import com.aaa.af.entity.User;
import com.aaa.af.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * className:UserRealm
 * discription:
 * author:Cheng Fangying
 * createTime:2018-11-30 15:14
 */
public class UserRealm extends AuthorizingRealm{
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:add");

        //到数据库查询当前用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        User dbUser = userService.findById(user.getUserId());
        info.addStringPermission(dbUser.getRoleId());

        return info;
    }

    //注入业务
    @Autowired
    private UserService userService;

    /**
     * 执行认证逻辑
     * @param arg0
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token=(UsernamePasswordToken) arg0;
        User user = userService.findByName(token.getUsername());

        if(user==null){
            //用户名不存在
            return null;//shiro底层会抛出UnKnowAccountException
        }

        //2,判断密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
