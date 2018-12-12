package com.aaa.af.controller;

import com.aaa.af.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/7 17:04
 */
@Controller
@RequestMapping("/home")
public class InformationCtroller {
    @Autowired
    private InformationService informationService;

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/toHome")
    public String homePage(){
        return "shouye";
    }
    /**
     * 查询前台信息
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/homePage1")
    public List<Map> AllPersonnel(HttpServletRequest request, Model model) {
        List<Map> ListMaps6 = informationService.xinxiListMaps(6);
        return ListMaps6;
    }

    /**
     * 通知公告
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/homePage2")
    public List<Map> AllPersonne2(HttpServletRequest request, Model model) {
        List<Map> ListMaps4 = informationService.xinxiListMaps(4);
        System.out.println(ListMaps4);
        return ListMaps4;
    }

    /**
     * 工作动态
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/homePage3")
    public List<Map> AllPersonne3(HttpServletRequest request, Model model) {
        List<Map> ListMaps5 = informationService.xinxiListMaps(5);
        System.out.println(ListMaps5);
        return ListMaps5;
    }

    /**
     * 跳转后台信息管理
     * @return
     */
    @RequestMapping("/informations")
    public String informations(){
        return "information/information";
    }

    /**
     * 获取信息列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getInfor")
    public Object getInformations(@RequestBody Map map){
        Map resulMap=new HashMap();
        resulMap.put("pageData",informationService.getInformations(map));
        resulMap.put("total",informationService.getPageCount(map));
        return resulMap;
    }

    /**
     * 添加前台信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addInformation(@RequestBody Map map){
        return informationService.add(map);
    }
    /**
     * 删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map map){
        return informationService.delete(Integer.valueOf(map.get("id")+""));
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/batchDel/{ids}")
    public Object batchDel(@PathVariable String ids){
        return informationService.batchDelete(ids);
    }
    /**
     * 修改前台信息
     * @param map
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return informationService.update(map);
    }
}
