package com.aaa.af.controller;

import com.aaa.af.service.JiShuService;
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
 * @Date: 2018/12/19 09:48
 */
@Controller
@RequestMapping("/jishu")
public class JiShuController {

    @Autowired
    private JiShuService jiShuService;

    /**
     * 转到基数页面
     * @return
     */
    @RequestMapping("/toJiShu")
    public Object jiShu(){
        return "company/jishu";
    }

    /**
     * 公司分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object page(@RequestBody Map map){
        HashMap hashMap = new HashMap();
        hashMap.put("pageData",jiShuService.getPageByParm(map));
        hashMap.put("total",jiShuService.getPageCount(map));
        return hashMap;
    }

    /**
     * 公司员工分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page1")
    public Object page1(@RequestBody Map map){
        HashMap map2 = new HashMap();
        map2.put("pageData1",jiShuService.getPageByParm1(map));
        map2.put("total1",jiShuService.getPageCount1(map));
        return map2;
    }

    /**
     * 根据个人账号 查询个人信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/select/{row}")
    public Object getSelect(@PathVariable("row") String map){
        return jiShuService.getSelect(map);
    }

    /**
     * 更改数据库信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("update1")
    public Object update1(@RequestBody Map map){
        return  jiShuService.update1(map);
    }
}
