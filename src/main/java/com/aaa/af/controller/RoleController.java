package com.aaa.af.controller;

import com.aaa.af.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/15 8:28
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    /**
     * 跳转角色管理页面
     * @return
     */
    @RequestMapping("/toRole")
    public String toRole(){
        return "power/role";
    }
    /**
     * 获取权限列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRoles")
    public Object getRoles(@RequestBody Map map){
        return roleService.getRoles(map);
    }
    /**
     * 添加角色
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addInformation(@RequestBody Map map){
        return roleService.add(map);
    }
    /**
     * 删除角色
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map map){
        return roleService.delete(Integer.valueOf(map.get("roleId")+""));
    }
    /**
     * 修改角色信息
     * @param map
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return roleService.update(map);
    }
    /**
     * 获得角色权限ID
     * @param map
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/getTreeid")
    public Object getTreeid(@RequestBody Map map){
        return roleService.getTreeid(map);
    }
    /**
     * 修改权限
     * @param map
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/updateTree")
    public int updateTree(@RequestBody Map map){
        return roleService.updataTree(map);
    }
}
