package com.aaa.af.controller;

import com.aaa.af.service.CompanyLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/25 9:50
 */
@Controller
@RequestMapping("company")
public class CompanyLoginController {
    //依赖注入
    private CompanyLoginService companyLoginService;

    /**
     * 跳转个人主页
     * @return
     */
    @RequestMapping("/info")
    public String gerenzhuye(Model model, @RequestParam Map map){
        System.out.println(map);
        model.addAttribute("list",companyLoginService.getList(map));
        return "yingyeting/companyinfo";
    }
}
