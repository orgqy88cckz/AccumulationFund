package com.aaa.af.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:LoanController
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-11 19:19
 */
@Controller
@RequestMapping("loan")
public class LoanController {

    @RequestMapping("toMortgageLoan")
    public String toMortgageLoan(){
        return "loans/mortgageLoan";
    }
    @RequestMapping("toMortgageLoan1")
    public String toMortgageLoan1(){
        return "loans/mortgageLoan1";
    }
}
