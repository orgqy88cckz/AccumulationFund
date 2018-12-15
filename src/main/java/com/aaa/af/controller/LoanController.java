package com.aaa.af.controller;

import com.aaa.af.service.SearchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 跳转到个人抵押贷页面
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

    @ResponseBody
    @RequestMapping("selectGRZH")
    public Object selectGRZH(){
        return searchInfoService.selectGRZH();
    }
}
