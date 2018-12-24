package com.aaa.af.controller;

import com.aaa.af.service.HuiJiaoService;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/20 18:42
 */
@Controller
@RequestMapping("/huijiao")
public class HuiJiaoController {

    //依赖注入
    @Autowired
    private HuiJiaoService huiJiaoService;

    /**
     * 转到汇缴页面
     * @return
     */
    @RequestMapping("/toHuiJiao")
    public Object guaZhang(){
        return "company/huijiao";
    }

    /**
     * 分页方法
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object select(@RequestBody Map map){
        HashMap hashMap = new HashMap();
        hashMap.put("pageData",huiJiaoService.getPageByParm(map));
        hashMap.put("total",huiJiaoService.getPageCount(map));
        return hashMap;
    }

    /**
     * 根据个人账号查询信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/select/{DWZH}")
    public Object getSelect(@PathVariable("DWZH") String map){
        return huiJiaoService.getSelect(map);
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return huiJiaoService.update(map);
    }
}
