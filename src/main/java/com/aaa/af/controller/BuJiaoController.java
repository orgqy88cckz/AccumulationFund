package com.aaa.af.controller;

import com.aaa.af.service.BuJiaoService;
import com.aaa.af.service.HuiJiaoService;
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
@RequestMapping("/bujiao")
public class BuJiaoController {

    @Autowired
    private BuJiaoService buJiaoService;

    /**
     * 转到挂账页面
     *
     * @return
     */
    @RequestMapping("/toBuJiao")
    public Object guaZhang() {
        return "company/bujiao";
    }

    @ResponseBody
    @RequestMapping("/page")
    public Object select(@RequestBody Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("pageData", buJiaoService.getPageByParm(map));
        hashMap.put("total", buJiaoService.getPageCount(map));
        return hashMap;
    }

    /*@ResponseBody
    @RequestMapping("/select/{DWZH}")
    public Object getSelect(@PathVariable("DWZH") String map){
        return buJiaoService.getSelect(map);
    }*/
    @ResponseBody
    @RequestMapping("/select")
    public Object getSelect(@RequestBody Map map) {
        return buJiaoService.getSelect(map);
    }

    @ResponseBody
    @RequestMapping("/getbyid/{DWZH}")
    public Object getById(@PathVariable("DWZH") String id) {
        System.out.println("111111111111111111111111111111111111");
        return buJiaoService.getById(id);
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map) {
        return buJiaoService.update(map);
    }
}
