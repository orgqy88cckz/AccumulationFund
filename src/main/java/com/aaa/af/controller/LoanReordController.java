package com.aaa.af.controller;

import com.aaa.af.service.LoanService;
import com.aaa.af.service.RepayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/22 16:50
 */
@Controller
@RequestMapping("loan_record")
public class LoanReordController {

    //依赖注入
    @Autowired
    private LoanService loanService;
    /**
     * 跳转分页列表
     * @return
     */
    @RequestMapping("/toPage")
    public String toPage(){
        return "repay/loan";
    }

    /**
     * 贷款（分页）
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public  Object page(@RequestBody Map map){

        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo")+""),Integer.valueOf(map.get("pageSize")+""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(loanService.getList(map));
        Map resultMap = new HashMap();
        //获取当前页数据
        resultMap.put("pageData",pageInfo.getList());
        //获取分页总数量
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }
}
