package com.aaa.af.controller;

import com.aaa.af.service.AccountService;
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
 * className:DeptTest
 * discription:r:mx
 * createTime:2018/12/18 15:29
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private FtpUtil ftpUtil;
    @Autowired
    private FtpConfig ftpConfig;
    @Autowired
    private ResourceLoader resourceLoader;
    /**
     * 跳转个人信息
     * @return
     */
    @RequestMapping("/person")
    public String toPerson(){
        return "account/person";
    }
    /**
     * 获取个人信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPerson")
    public Object getPerson(@RequestBody Map map){
        return accountService.getPersons(map);
    }
    /**
     * 修改个人信息
     * @param map
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return accountService.update(map);
    }
    /**
     * 跳转公司信息
     * @return
     */
    @RequestMapping("/unit")
    public String toUnit(){
        return "account/unit";
    }
    /**
     * 获取单位信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUnit")
    public Object getUnit(@RequestBody Map map){
        System.out.println(map);
        return accountService.getUnitInfo(map);
    }
    /**
     * 修改单位信息
     * @param map
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/updateUnit")
    public Object updateUnit(@RequestBody Map map){
        return accountService.updateUnit(map);
    }
    /**
     * 上传方法
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("/upLoadPic")
    public Object upLoadPic(@RequestParam MultipartFile file){
        String s = ftpUtil.upLoad(file);
        return s;
    }
    /**
     * 显示Ftp图片
     * @param fileName
     * @return
     */
    @RequestMapping("/show")
    public ResponseEntity show(String fileName){
        try {
            return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpConfig.getFtpUserName()+":"+ftpConfig.getFtpPassWord()+"@"+ ftpConfig.getRemoteIp()+ftpConfig.getRemotePath() + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
