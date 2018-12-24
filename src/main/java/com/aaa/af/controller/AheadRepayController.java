package com.aaa.af.controller;

import com.aaa.af.service.AheadRepayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/19 10:03
 */
@Controller
@RequestMapping("/ahead")
public class AheadRepayController {
    /**
     * 依赖注入
     */
    @Autowired
    private AheadRepayService aheadRepayService;

    /**
     * 跳转分页列表
     * @return
     */
    @RequestMapping("/toPage")
    public String toPage(){
        return "repay/ahead_repay";
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
        PageInfo<Map> pageInfo = new PageInfo<Map>(aheadRepayService.getList(map));
        Map resultMap = new HashMap();
        //获取当前页数据
        resultMap.put("pageData",pageInfo.getList());
        //获取分页总数量
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }

    /**
     * 提前还款
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public  Object update(@RequestBody Map map,Model model){
        Integer peroids =Integer.valueOf(map.get("REPAYED_PERIODS")+"");
        System.out.println(peroids);
        if (peroids>=12){
            aheadRepayService.update(map);//提前还款
          int m = aheadRepayService.updateState(map);//更新状态
            Map state = new HashMap();
            state.put("stateDate",m);
            aheadRepayService.addInfo(map);//添加纪录
            return 1;
        }else{
           return 0;
        }


    }
    @ResponseBody
    @RequestMapping("/record")
    public Object getRecord(@RequestBody Map map){
        List<Map> record = aheadRepayService.getRecord(map);
        Map result = new HashMap();
        result.put("repayData",record);
        return result;
    }
}
