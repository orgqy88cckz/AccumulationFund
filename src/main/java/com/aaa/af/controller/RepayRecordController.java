package com.aaa.af.controller;

import com.aaa.af.service.RepayRecordService;
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
 * createTime:2018/12/18 22:28
 */
@Controller
@RequestMapping("record")
public class RepayRecordController {
    //依赖注入
    @Autowired
    private RepayRecordService repayRecordService;

    /**
     * 跳转分页列表
     * @return
     */
    @RequestMapping("/toPage")
    public String toPage(){
        return "repay/repay_record";
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
        PageInfo<Map> pageInfo = new PageInfo<Map>(repayRecordService.getList(map));
        Map resultMap = new HashMap();
        //获取当前页数数据
        resultMap.put("PageData",pageInfo.getList());
        //获取分页总数量
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }
}
