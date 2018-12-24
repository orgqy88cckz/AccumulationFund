package com.aaa.af.controller;

import com.aaa.af.service.BiLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/bili")
public class BiLiController {

    @Autowired
    private BiLiService biLiService;

    /**
     * 转到比例页面
     * @return
     */
    @RequestMapping("/toBiLi")
    public Object guaZhang(){
        return "company/bili";
    }

    /**
     * 分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object select(@RequestBody Map map){
        HashMap hashMap = new HashMap();
        hashMap.put("pageData",biLiService.getPageByParm(map));
        hashMap.put("total",biLiService.getPageCount(map));
        return hashMap;
    }

    /**
     * 更改
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return biLiService.update(map);
    }

}
