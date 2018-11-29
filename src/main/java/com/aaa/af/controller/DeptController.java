package com.aaa.af.controller;

import com.aaa.af.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * className:DeptController
 * discription:
 * author:zz
 * createTime:2018-11-21 11:32
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    //依赖注入
    @Autowired
    private DeptService deptService;

    /**
     * 部门列表方法
     * @return
     */
    @RequestMapping("/list")
    public Object list(){
        return deptService.getList();
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @RequestMapping("/add")
    public Object add(@RequestParam Map map){
        System.out.println(map.get("dname")+"-----"+map.get("loc"));
        int i = deptService.addDept(map);
        Map map1=new HashMap();
        if(i>0){
            map1.put("msg","true");
        }else {
            map1.put("msg","failed");
        }
        return map1;
    }

    /**
     * 跳转到更新页面
     * @param deptNo
     * @return
     */
    @RequestMapping("toEdit")
    public Object toEdit(int deptNo){
        Map listById = deptService.getListById(deptNo);
        if (listById!=null&&listById.size()>0){
            listById.put("msg","true");
        }else {
            listById.put("msg","failed");
        }
        return listById;
    }

    /**
     * 更新部门列表
     * @param map
     * @return
     */
    @RequestMapping("update")
    public Object update(@RequestParam Map map){

        System.out.println(map.get("dname")+"---"+map.get("deptNo")+"---"+map.get("loc"));
        int i = deptService.update(map);
        Map map1=new HashMap();
        if (i>0){
            map1.put("msg","true");
        }else{
            map1.put("msg","failed");
        }
        return map1;
    }

    /**
     * 删除部门
     * @param deptNo
     * @return
     */
    @RequestMapping("delete")
    public Object delete(int deptNo){
        System.out.println(deptNo);
        int i = deptService.delete(deptNo);
        System.out.println(i);
        Map map1=new HashMap();
        if (i>0){
            map1.put("msg","true");
        }else{
            map1.put("msg","failed");
        }
        return map1;
    }
}
