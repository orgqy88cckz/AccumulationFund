package com.aaa.af.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className:LoanController
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-11 19:19
 */
@Controller
@RequestMapping("loan")
public class LoanController {

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

        return "";
    }
}
