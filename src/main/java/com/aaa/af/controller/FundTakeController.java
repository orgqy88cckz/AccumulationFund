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
        System.out.println(map+"6666666666666666666666666666666666666666666");
        Map resultMap=new HashMap();
        resultMap.put("pageData",fundTakeService.selectFundCheck(map));
        resultMap.put("total",fundTakeService.selectCheckCount(map));
        return resultMap;
    }

    /**
     * 提取审核弹框查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("checkFundTake/{BFTAKE_ID}")
    public Object checkFundTake(@PathVariable("BFTAKE_ID") Integer id){
        return fundTakeService.checkFundTake(id);
    }

    /**
     * 提取审核通过
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("takePass")
    public Object takePass(@RequestBody Map map){
        return fundTakeService.takePass(map);
    }

    /**
     * 提取审核通过
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("takeReject")
    public Object takeReject(@RequestBody Map map){
        return fundTakeService.takeReject(map);
    }

    /**
     * 约定提取列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("selectFundAppoint")
    public Object selectFundAppoint(@RequestBody Map map){
        Map resultMap=new HashMap();
        resultMap.put("pageData",fundTakeService.selectFundAppoint(map));
        resultMap.put("total",fundTakeService.selectAppointCount(map));
        return resultMap;
    }

    /**
     * -----跳转到约定提取列表
     * @return
     */
    @RequestMapping("toSelectFundAppoint")
    public String toSelectFundAppoint(){
        return "fundTakeOut/fundAppoint";
    }

    /**
     * 约定提取弹出框数据
     * @param GRZH
     * @return
     */
    @ResponseBody
    @RequestMapping("appointAppl/{LOAN_ID}")
    public Object appointAppl(@PathVariable("LOAN_ID") Integer LOAN_ID){
        return fundTakeService.appointAppl(LOAN_ID);
    }

    /**
     * 约定提取申请提交
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("appointSubmit")
    public Object appointSubmit(@RequestBody Map map){
        return fundTakeService.appointSubmit(map);
    }

    /**
     * 判断约定提取是否已经申请
     * @param GRZH
     * @return
     */
    @ResponseBody
    @RequestMapping("panduan/{LOAN_ID}")
    public Object panduan(@PathVariable("LOAN_ID") Integer LOAN_ID){
        return  fundTakeService.panduan(LOAN_ID);
    }

    /**
     * 查询约定审核列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("selectAppointCheck")
    public Object selectAppointCheck(@RequestBody Map map){
        Map resultMap=new HashMap();
        resultMap.put("pageData",fundTakeService.selectAppointCheck(map));
        resultMap.put("total",fundTakeService.selectAppCheckCount(map));
        return resultMap;
    }

    /**
     * -----跳转到约定提取审核列表
     * @return
     */
    @RequestMapping("toSelectAppointCheck")
    public String toSelectAppointCheck(){
        return "fundTakeOut/fundAppointCheck";
    }

    /**
     *约定审核通过事件
     * @return
     */
    @ResponseBody
    @RequestMapping("appointPass/{AID}")
    public Object appointPass(@PathVariable("AID") Integer aid){
        return fundTakeService.appointPass(aid);
    }

    /**
     *约定审核驳回事件
     * @return
     */
    @ResponseBody
    @RequestMapping("appointReject/{AID}")
    public Object appointReject(@PathVariable("AID") Integer aid){
        return fundTakeService.appointReject(aid);
    }

}
