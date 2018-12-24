package com.aaa.af.controller;

import com.aaa.af.service.AfterRepayService;
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
 * createTime:2018/12/20 21:26
 */
@Controller
@RequestMapping("/after")
public class AfterRepayController {
    //依赖注入
    @Autowired
    private AfterRepayService afterRepayService;

    /**
     * 跳转分页列表
     * @return
     */
    @RequestMapping("/toPage")
    public String toPage(){
        return "repay/after_repay";
    }

    /**
     * 还款（分页）
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public  Object page(@RequestBody Map map){

        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo")+""),Integer.valueOf(map.get("pageSize")+""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(afterRepayService.getList(map));
        Map resultMap = new HashMap();
        //获取当前页数据
        resultMap.put("pageData",pageInfo.getList());
        //获取分页总数量
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object overRepay(@RequestBody Map map){
            return "";
    }
}
