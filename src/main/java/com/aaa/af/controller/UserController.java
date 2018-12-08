package com.aaa.af.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.Map;

/**
 * className:UserController
 * discription:
 * author:Cheng Fangying
 * createTime:2018-11-30 14:40
 */
@Controller
public class UserController {
    /**
     * 测试方法
     */
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        System.out.println("UserController.hello()");
        return "ok";
    }

    @RequestMapping("add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("toIndex")
    public String toTest(){
        return "index";
    }

    @RequestMapping("noAuth")
    public String noAuth(){
        return "noAuth";
    }

    /**
     * 登陆成功返回数据到登陆页面并跳转到主页面
     */
    @ResponseBody
    @RequestMapping("testThymeleaf")
    public Object testThymeleaf(){
        return 1;
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login(@RequestBody Map map,Model model){
        /**
         * 使用shiro编写认证操作
         */
        //1,获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2,封装用户数据
        String name = map.get("name").toString();
        String password = map.get("password").toString();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //3,执行登录方法
        try {
            subject.login(token);
            //登录成功
            //跳转到test.html
            return "forward:/testThymeleaf";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
