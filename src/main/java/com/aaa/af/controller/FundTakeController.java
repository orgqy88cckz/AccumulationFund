package com.aaa.af.controller;

import com.aaa.af.service.FundTakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:FundTakeController
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-18 19:30
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("fundTake")
public class FundTakeController {

    @Autowired
    private FundTakeService fundTakeService;

    /**
     * 查询公积金部分提取全部人员分页列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("selectFundPart")
    public Object selectFundPart(@RequestBody Map map){
        Map resultMap=new HashMap();
        resultMap.put("pageData",fundTakeService.selectFundPart(map));
        resultMap.put("total",fundTakeService.selectFundCount(map));
        return resultMap;
    }

    /**
     * -----跳转到公积金部分提取列表页面
     * @return
     */
    @RequestMapping("tofundPart")
    public String toLoanCheck(){
        return "fundTakeOut/fundPart";
    }

    /**
     * 查询公积金部分提取弹框信息
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping("selectFormInfo/{PID}")
    public Object selectFormInfo(@PathVariable ("PID") Integer pid){
        return fundTakeService.selectFormInfo(pid);
    }

    /**
     * 提取公积金提交信息并且更新账户表中的公积金余额
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("takeSubmit")
    public Object takeSubmit(@RequestBody Map map){
        return fundTakeService.takeSubmit(map);
    }

    /**
     * 查询申请是否重复提交
     * @return
     */
    @ResponseBody
    @RequestMapping("applitation/{GRZH}")
    public Object applitation(@PathVariable("GRZH") String GRZH){
        return fundTakeService.applitation(GRZH);
    }

    /**
     * -----跳转到公积金提取申请审核
     * @return
     */
    @RequestMapping("toSelectFundCheck")
    public String toSelectFundCheck(){
        return "fundTakeOut/fundPartCheck";
    }

    /**
     * 公积金提取申请审核
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("selectFundCheck")
    public Object selectFundCheck(@RequestBody Map map){
        Map resultMap=new HashMap();
        resultMap.put("pageData",fundTakeService.selectFundCheck(map));
        resultMap.put("total",fundTakeService.selectCheckCount(map));
        return resultMap;
    }
}
