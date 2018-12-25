package com.aaa.af.controller;

import com.aaa.af.service.YingYeTingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
        model.addAttribute("list",yingYeTingService.getPerson(map));
        return "yingyeting/gerenzhuye";
    }
    /**
     * 跳转贷款主页
     * @return
     */
    @RequestMapping("/daikuan")
    public String daikuan(Model model,@RequestParam Map map){
        if(yingYeTingService.getLoan(map).size()==0){
            model.addAttribute("msg","您没有贷款业务。。。");
            return "yingyeting/daikuan";
        }else{
        model.addAttribute("list",yingYeTingService.getLoan(map));
        return "yingyeting/daikuan";
        }
    }
    /**
     * 跳转偿还主页
     * @return
     */
    @RequestMapping("/changhuan")
    public String changhuan(Model model,@RequestParam Map map){
        if(yingYeTingService.getLoan(map).size()==0){
            model.addAttribute("msg","您没有贷款业务,不需要还款。。。");
            return "yingyeting/changhuan";
        }else{
            model.addAttribute("list",yingYeTingService.getLoan(map));
            return "yingyeting/changhuan";
        }
    }

    /**
     * 跳转支付页面
     * @param map
     * @return
     */
    @RequestMapping("/zhifu")
    public String zhifu(@RequestParam Map map,Model model){
        System.out.println(map);
        yingYeTingService.zhifu(map,model);
        return "yingyeting/zhifu";
    }
}
