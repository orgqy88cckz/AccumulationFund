package com.aaa.af.controller;

import com.aaa.af.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/13 20:26
 */
@Controller
@RequestMapping("/power")
public class PowerController {
    @Autowired
    private PowerService powerService;
    /**
     * 跳转后台权限管理
     * @return
     */
    @RequestMapping("/toPowers")
    public String toPowers(){
        return "power/index";
    }
    /**
     * 获取权限列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPowers")
    public Object getPowers(@RequestBody Map map){
        Map resulMap=new HashMap();
        resulMap.put("pageData",powerService.getPowers(map));
        resulMap.put("total",powerService.getPageCount(map));
        return resulMap;
    }
    /**
     * 获取父节点列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/parents")
    public Object getParents(){
        return powerService.getParents();
    }
    /**
     * 添加权限
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addInformation(@RequestBody Map map){
        return powerService.add(map);
    }
    /**
     * 删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map map){
        return powerService.delete(Integer.valueOf(map.get("treeId")+""));
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/batchDel/{ids}")
    public Object batchDel(@PathVariable String ids){
        return powerService.batchDelete(ids);
    }
    /**
     * 修改前台信息
     * @param map
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return powerService.update(map);
    }
}
