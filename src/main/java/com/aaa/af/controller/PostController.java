package com.aaa.af.controller;

import com.aaa.af.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/17 11:36
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    /**
     * 跳转岗位管理
     * @return
     */
    @RequestMapping("/toPost")
    public String toPowers(){
        return "power/post";
    }
    /**
     * 获取用户列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUsers")
    public Object getUsers(@RequestBody Map map){
        return postService.getUsers(map);
    }
    /**
     * 获取父节点列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRoles")
    public Object getRoles(){
        return postService.getRoles();
    }
    /**
     * 添加用户
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addUser(@RequestBody Map map){
        return postService.add(map);
    }
    /**
     * 删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map map){
        return postService.delete(Integer.valueOf(map.get("Id")+""));
    }
    /**
     * 修改用户信息
     * @param map
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return postService.update(map);
    }
}
