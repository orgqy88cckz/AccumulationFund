package com.aaa.af.controller;

import com.aaa.af.service.GuaZhangService;
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
 * @Date: 2018/12/19 09:48
 */
@Controller
@RequestMapping("/guazhang")
public class GuaZhangController {

    /**
     * 依赖注入
     */
    @Autowired
    private GuaZhangService guaZhangService;

    /**
     * 转到挂账页面
     * @return
     */
    @RequestMapping("/toGuaZhang")
    public Object guaZhang(){
        return "company/guazhang";
    }

    /**
     * 查询分页数据
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object select(@RequestBody Map map){
        HashMap hashMap = new HashMap();
        hashMap.put("pageData",guaZhangService.getPageByParm(map));
        hashMap.put("total",guaZhangService.getPageCount(map));
        return hashMap;
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return guaZhangService.update(map);
    }
}
