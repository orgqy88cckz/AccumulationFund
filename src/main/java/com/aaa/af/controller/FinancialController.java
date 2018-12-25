package com.aaa.af.controller;

import com.aaa.af.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className:FinancialController
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-24 21:06
 */
@Controller
@RequestMapping("financial")
public class FinancialController {
    @Autowired
    private FinancialService financialService;
    /**
     * 归集情况分析  查询每月公积金提取的总金额
     * @return
     */
    @ResponseBody
    @RequestMapping("GJFX")
    public Object GJFX(){
        System.out.println(financialService.GJFX());
        return financialService.GJFX();

    }

    /**
     * --跳转到归集情况分析页面
     * @return
     */
    @RequestMapping("toGJFX")
    public String toGJFX(){
        return "financial/GJQKFX";
    }

    /**
     * 统计每月汇缴金额
     * @return
     */
    @ResponseBody
    @RequestMapping("huijiao")
    public Object huijiao(){
        return financialService.huijiao();
    }

    /**
     * 贷款信息
     * @return
     */
    @ResponseBody
    @RequestMapping("daiKuanXinXi")
    public Object daiKuanXinXi(){
        return  financialService.daiKuanXinXi();
    }
    /**
     * 还款信息
     * @return
     */
    @ResponseBody
    @RequestMapping("huanKuanXinXi")
    public Object huanKuanXinXi(){
        return  financialService.huanKuanXinXi();
    }

    /**
     * --跳转到贷款情况分析页面
     * @return
     */
    @RequestMapping("toDKFX")
    public String toDKFX(){
        return "financial/DKQKFX";
    }

    /**
     * 查询提取人数
     * @return
     */
    @ResponseBody
    @RequestMapping("tiqu")
    public Object tiqu(){
        return financialService.tiqu();
    }
    /**
     * 查询汇缴人数
     * @return
     */
    @ResponseBody
    @RequestMapping("huijiaoPer")
    public Object huijiaoPer(){
        return financialService.huijiaoPer();
    }
}
