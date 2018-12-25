package com.aaa.af.controller;

import com.aaa.af.service.SearchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:LoanController
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-11 19:19
 */
@Controller
@RequestMapping("loan")
public class LoanController {

    @Autowired
    private SearchInfoService searchInfoService;
    /**
     * ----跳转到个人抵押贷页面
     * @return
     */
    @RequestMapping("toMortgageLoan")
    public String toMortgageLoan(){
        return "loans/mortgageLoan";
    }

    /**
     * 根据个人账号获取个人信息
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping("searchInfo/{account}")
    public Object searchInfo(@PathVariable("account") String account){
        Map personInfo = searchInfoService.getPersonInfo(account);
        return personInfo;
    }

    /**
     * 添加贷款信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public Object add(@RequestBody List<Map> map){
        System.out.println(map);
        int i = searchInfoService.addInfo(map);
        return i;
    }


    /**
     * -----跳转到贷款审核等待页面
     * @return
     */
    @RequestMapping("toLoanWait")
    public String toLoanWait(){
        return "loans/loanWait";
    }

    /**
     * -----跳转到贷款终审列表页面
     * @return
     */
    @RequestMapping("toLoanCheckFinally")
    public String toLoanCheckFinally(){
        return "loans/checkLoanFinally";
    }

    /**
     * -----跳转到贷款初审列表页面
     * @return
     */
    @RequestMapping("toLoanCheck")
    public String toLoanCheck(){
        return "loans/checkLoan";
    }


    /**
     * 贷款初审列表查询
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("loanCheck")
    public Object loanCheckSelect(@RequestBody Map map){
        Map resultMap=new HashMap();
        resultMap.put("pageData",searchInfoService.loanCheckSelect(map));
        resultMap.put("total",searchInfoService.getPageCount(map));
        return resultMap;
    }

    /**
     * 贷款终审列表查询
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("loanCheckFinally")
    public Object loanCheckSelectFinally(@RequestBody Map map){
        Map resultMap=new HashMap();
        resultMap.put("pageData",searchInfoService.loanCheckSelectFinally(map));
        resultMap.put("total",searchInfoService.getPageCountFinally(map));
        return resultMap;
    }

    /**
     * 贷款初审弹出框查询
     * @param loan_id
     * @return
     */
    @ResponseBody
    @RequestMapping("selectForm/{loan_id}")
    public Object selectForm(@PathVariable("loan_id") String loan_id){
        return searchInfoService.selectForm(loan_id);
    }


    /**
     * 贷款初审通过
     * @return
     */
    @ResponseBody
    @RequestMapping("checkPass")
    public Object checkPass(@RequestBody Map map){
        return searchInfoService.checkPass(map);
    }
    /**
     * 贷款初审驳回
     * @return
     */
    @ResponseBody
    @RequestMapping("checkReject")
    public Object checkRejecte(@RequestBody Map map){
        return searchInfoService.checkReject(map);
    }

    /**
     * 贷款终审通过
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("finallyPass")
    public Object finallyPass(@RequestBody Map map){
        return searchInfoService.checkPassFinally(map);
    }

    /**
     * 贷款终审驳回
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("finallyReject")
    public Object finallyReject(@RequestBody Map map){
        return searchInfoService.checkRejectFinally(map);
    }


    /**
     * 贷款页面验证查询
     * @return
     */
    @ResponseBody
    @RequestMapping("unique/{value}")
    public Object unique(@PathVariable("value") String value){
        return searchInfoService.unique(value);
    }

    /**
     * 验证个人账号查询
     * @param GRZH
     * @return
     */
    @ResponseBody
    @RequestMapping("yanzheng/{GRZH}")
    public Object yanzheng(@PathVariable("GRZH") String GRZH){
        return searchInfoService.yanzheng(GRZH);
    }
}
