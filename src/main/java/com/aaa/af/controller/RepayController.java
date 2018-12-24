package com.aaa.af.controller;

import com.aaa.af.service.RepayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/10 20:02
 */
@Controller
@RequestMapping("/repay")
public class RepayController {
    //依赖注入
    @Autowired
    private RepayService repayService;
    /**
     * 跳转分页列表
     * @return
     */
    @RequestMapping("/toPage")
    public String toPage(){
        return "repay/repay";
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
        PageInfo<Map> pageInfo = new PageInfo<Map>(repayService.getList(map));
        Map resultMap = new HashMap();
        //获取当前页数据
        resultMap.put("pageData",pageInfo.getList());
        //获取分页总数量
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }
    /*@ResponseBody
    @RequestMapping("byid")
    public Object getListById(Integer id){
        System.out.println("123456");
        return repayService.getListById(id);
    }*/

    /**
     *分期还款
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        repayService.update(map);
        repayService.updState(map);
         String peroids = map.get("OVER_PERIODS")+"";
         if (peroids.equals("1")){
            int i =repayService.updateState(map);
             Map state = new HashMap();
             state.put("stateDate",i);
             System.out.println(peroids);
         }
        int r = repayService.addInfo(map);
               return r;
            }
        //System.out.println(map);
       // System.out.println(i);

    /**
     * 添加个人还款记录
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/record")
    public Object getRecord(@RequestBody Map map){
        List<Map> record = repayService.getRecord(map);
        Map result = new HashMap();
        result.put("repayData",record);
        return result;
    }
}
