package com.aaa.af.controller;


import com.aaa.af.service.UnitService;
import com.aaa.af.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
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
     * 依赖注入
     */
    @Autowired
    private FtpUtil ftpUtil;

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

    /**
     * 上传方法
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("/upLoadPic")
    public Object upLoadPic(@RequestParam MultipartFile file){
        System.out.println(file);
        String s = ftpUtil.upLoad(file);
        return s;
    }

    /**
     * 公司名称唯一性验证
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/uname/{uname}")
    public Object name(@PathVariable("uname") String name){
        return unitService.uname(name);
    }

    /**
     * 法人身份证验证
     * @param card
     * @return
     */
    @ResponseBody
    @RequestMapping("/idCard/{card}")
    public Object idCard(@PathVariable("card") String card){
        return unitService.idCard(card);
    }

    /**
     * 经办人身份证验证
     * @param card
     * @return
     */
    @ResponseBody
    @RequestMapping("/idCard1/{card}")
    public Object idCard1(@PathVariable("card") String card){
        return unitService.idCard1(card);
    }

    @ResponseBody
    @RequestMapping("/phone/{num}")
    public Object phoneNum(@PathVariable("num") String num){
        return unitService.phone(num);
    }


    /**
     * 明细查询（公司）
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("detail")
    public Object detail(@RequestBody Map map){
        //System.out.println(map.get("start")+""+map.get("end")+"------");
        HashMap hashMap = new HashMap();
        hashMap.put("pageData",unitService.detail(map));
        hashMap.put("total",unitService.count(map));
        //System.out.println(unitService.detail(map)+"------------------");
        return hashMap;
    }

    /**
     *  跳转到明细查询页面
     * @return
     */
   @RequestMapping("toRecord")
    public String toRecord(){
        return "company/record";
    }

}
