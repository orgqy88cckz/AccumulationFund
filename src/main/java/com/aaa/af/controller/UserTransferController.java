package com.aaa.af.controller;

import com.aaa.af.service.UserTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:UserTransfer
 * discription:人员转移
 * author:wqy
 * createTime:2018-12-11 14:23
 */
@Controller
@RequestMapping("/userTransfer")
public class UserTransferController {

    @Autowired
    private UserTransferService userTransferService;
    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "person/UserTransfer";
    }
//    /**
//     * 跳转列表页面---测试
//     * @return
//     */
//    @RequestMapping("/toList2")
//    public String toList2(){
//        return "person/test";
//    }
    /**
     * 分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object list(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",userTransferService.getPageByParam(map));
        map1.put("total",userTransferService.getPageCount(map));
        return map1;
    }

    /**
     * 提交审核  根据这条信息取到在职公司单位
     * @return
     */
    @ResponseBody
    @RequestMapping("/transfer/{tb_pname}")
    public Object text(@PathVariable String tb_pname) {//试一试------@RequestBody
        Map name = userTransferService.selectByName(tb_pname);
        return name;
    }

    /**
     * 获取查询到的下拉框的转为单位的所有名称 然后跳转到页面
     * @return
     */
    @ResponseBody
    @RequestMapping("/select")
    public Object select() {
        List list=new ArrayList(20);//扩容
        return userTransferService.getUnit();
    }

    /**
     * 下拉框选中公司 获取ID  查询公司的受托银行
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/Trustee/{id}")
    public Object Trustee(@PathVariable Integer id) {
        Map uintById = userTransferService.getUintById(id);
        return uintById;
    }
    /**
     * 添加
     * @param map
     * @return
     * RequestBody该方法接收的数据对象为json对象
     * ResponseBody返回值为json对象
     */
    @ResponseBody
    @RequestMapping("/submit")
    public Object add(@RequestBody Map map){
        return userTransferService.add(map);
    }
    /**
     * 分页------待转移人员
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page2")
    public Object list2(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",userTransferService.getPageByParam2(map));
        map1.put("total",userTransferService.getPageCount2(map));
        return map1;
    }

    /**
     * 审核，提交申请只能一次
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/submitVerify/{TB_IDNUMBER}")
    public Object submitVerify(@PathVariable("TB_IDNUMBER") String idnumber){
       // System.out.println(idnumber+"**********************");
        Map map = userTransferService.submitVerify(idnumber);
       // System.out.println(map+"是");
        Map mapParam=new HashMap();
        if(map==null){//为空，没有查到数据
           //  System.out.println("返回");
             mapParam.put("r",0);
        }else{
            mapParam.put("r",1);
        }
        return mapParam;
    }
}
