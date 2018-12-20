package com.aaa.af.controller;


import com.aaa.af.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/08 14:17
 */
@Controller
@RequestMapping("/unit")
public class UnitController {

    /**
     * 依赖注入
     */
    @Autowired
    private UnitService unitService;

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/toUnit")
    public Object unit(){
        return "company/unit";
    }

    /**
     * 添加方法
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Map map){
        return unitService.add(map);
    }
}
