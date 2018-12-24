package com.aaa.af.controller;

import com.aaa.af.service.MergeService;
import com.aaa.af.service.TransferAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:UserTransfer
 * discription:封存 销户 启封     明细查询
 * author:wqy
 * createTime:2018-12-11 14:23
 */
@Controller
@RequestMapping("/merge")
public class MergeController {

    @Autowired
    private MergeService mergeService;
    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "person/Sealed_unsealed";
    }
    /**
     * 跳转列表页面
     * 明细查询
     * @return
     */
    @RequestMapping("/toList2")
    public String toList2(){
        return "person/detail";
    }
    /**
     * 分页------待转移人员
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object list(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",mergeService.getPageByParam(map));
        map1.put("total",mergeService.getPageCount(map));
        return map1;
    }
    /**
     * 页面的编辑界面，
     * 封存 启封 销户  操作弹出层查询信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/edit")
    public Object edit(@RequestBody Map map){
        Map verification = mergeService.verification(map.get("GRZH") + "");//查询到  封存 启封 销户 审核表信息待审核
        Map loansVerification = mergeService.loansVerification(map.get("GRZH") + "");//校验贷款的人 不能封存和销户  查询贷款人员信息
        Map maps=new HashMap();
        if(loansVerification!=null&&loansVerification.size()>0){ //判断按照GRZH查询贷款人 如有贷款人 进去 把这条信息传到前台 前台进行判断
            maps.put("daikan",1);
        }
        if(verification!=null&&verification.size()>0){ //判断按照GRZH查询封存 销户 启封 是否重复操作 查询是否有这条信息 在判断
            maps.put("grzh",1);
        }

        return maps;
    }

    /**
     * 封存 销户 启封 提交审核到审核表中
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/submit")
    public Object submit(@RequestBody Map map){
        return mergeService.add(map);
    }
    /**
     * 分页------明细查询
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page2")
    public Object list2(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",mergeService.getPageByParam2(map));
        map1.put("total",mergeService.getPageCount2(map));
        return map1;
    }

}
