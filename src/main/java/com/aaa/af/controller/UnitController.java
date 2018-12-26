package com.aaa.af.controller;


import com.aaa.af.service.UnitService;
import com.aaa.af.util.FtpConfig;
import com.aaa.af.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private FtpUtil ftpUtil;
    @Autowired
    private FtpConfig ftpConfig;
    @Autowired
    private ResourceLoader resourceLoader;

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

}
