package com.aaa.af.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * className:ShiroConfig
 * discription:
 * author:Cheng Fangying
 * createTime:2018-11-30 15:10
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro内置过滤器
        /**
         * 添加shiro内置过滤器,可以实现全线相关的拦截器
         *        常用的过滤器:
         *              anon:无须认证(登陆)可以访问
         *              authc:必须认证才可以访问
         *              user:如果使用rememberMe的功能可以直接访问
         *              perms:该资源必须得到资源权限才可以访问
         *              role:该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap=new LinkedHashMap<String, String>();

        /*filterMap.put("/add","authc");
        filterMap.put("/update","authc");*/

        //filterMap.put("/testThymeleaf","anon");
        //方形login.html页面
        filterMap.put("/toLogin","anon");
        //filterMap.put("/toIndex","anon");
        filterMap.put("/home/*","anon");
        filterMap.put("/yingyeting/*","anon");
        //授权过滤器
        //注意，当前授权拦截后，shiro会自动跳转到未授权页面
        /*filterMap.put("/add","perms[1]");
        filterMap.put("/update","perms[2]");*/


        filterMap.put("/*/*","authc");
        //filterMap.put("/*","authc");


        //修改跳转的登陆页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("UserRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return  securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "UserRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
