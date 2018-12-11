package com.aaa.af.controller;

import com.aaa.af.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
}
