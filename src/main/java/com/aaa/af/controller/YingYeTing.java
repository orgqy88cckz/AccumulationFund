package com.aaa.af.controller;

import com.aaa.af.service.YingYeTingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/24 11:19
 */
@Controller
@RequestMapping("/yingyeting")
public class YingYeTing {
    @Autowired
    private YingYeTingService yingYeTingService;
    /**
     * 跳转个人主页
     * @return
     */
    @RequestMapping("/gerenzhuye")
    public String gerenzhuye(Model model,@RequestParam Map map){
        System.out.println(map);
        model.addAttribute("list",yingYeTingService.getPerson(map));
        return "yingyeting/gerenzhuye";
    }
}
