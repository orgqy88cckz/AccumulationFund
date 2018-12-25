package com.aaa.af.controller;

import com.aaa.af.service.ApprovalService;
import com.aaa.af.service.MergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:UserTransfer
 * discription:查看审批
 * author:wqy
 * createTime:2018-12-11 14:23
 */
@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;
    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "person/approval";
    }
    /**
     * 分页查看审批----------需要更改----工作量未写
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object list(@RequestBody Map map){
        int accraditationCount = approvalService.accraditationCount();//查询到个人贷款
        approvalService.addAccraditationCount(accraditationCount,"个人贷款");//把信息个数   存入个人贷款类型信息
        int accraditationCountb = approvalService.accraditationCountb();//查询到个人转移
        approvalService.addAccraditationCount(accraditationCountb,"人员转移审批");
        int accraditationCountt = approvalService.accraditationCountt();//查询到公积金提取 记录表
        approvalService.addAccraditationCount(accraditationCountt,"公积金提取");//把信息个数   存入公积金提取类型信息
        int accraditationCounts = approvalService.accraditationCounts();//封存，启封，销户
        approvalService.addAccraditationCount(accraditationCounts,"封存、启封、销户审批");
        Map map1=new HashMap();
        map1.put("pageData",approvalService.getPageByParam(map));
        map1.put("total",approvalService.getPageCount(map));
        return map1;
    }
    /**
     * 分页----
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageR")
    public Object listR(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",approvalService.getPageByParamR(map));
        map1.put("total",approvalService.getPageCountR(map));
        return map1;
    }

    /**
     * 封，启，贷款
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageF")
    public Object listF(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",approvalService.getPageByParamF(map));
        map1.put("total",approvalService.getPageCountF(map));
        return map1;
    }

    /**
     * 个人贷款
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageG")
    public Object listG(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",approvalService.getPageByParamG(map));
        map1.put("total",approvalService.getPageCountG(map));
        return map1;
    }
    /**
     * 公积金提取
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageGJ")
    public Object listGJ(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",approvalService.getPageByParamGJ(map));
        map1.put("total",approvalService.getPageCountGJ(map));
        return map1;
    }

}
