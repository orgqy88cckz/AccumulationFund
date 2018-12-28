package com.aaa.af.controller;

import com.aaa.af.service.YingYeTingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
        yingYeTingService.zhifu(map,model);
        return "yingyeting/zhifu";
    }
    /**
     * 跳转缴纳记录
     * @return
     */
    @RequestMapping("/toJiaona")
    public String toJiaona(Model model,@RequestParam Map map){
        String grzh = (String) map.get("grzh");
        model.addAttribute("grzh",grzh);
        return "yingyeting/jiaona";
    }
    @ResponseBody
    @RequestMapping("/jiaonajilu")
    public Object getJiaona(@RequestBody Map map){
        return yingYeTingService.getJiaona(map);
    }

    /**
     * 跳转公司信息
     * @param model
     * @param map
     * @return
     */
    @RequestMapping("/info")
    public String companyinfo(Model model,@RequestParam Map map){
       // System.out.println(map);
        model.addAttribute("list",yingYeTingService.getList(map));
        System.out.println(yingYeTingService.getList(map));
        return "yingyeting/companyinfo";
    }

    /**
     * 跳转记录
     * @param model
     * @param map
     * @return
     */
    @RequestMapping("jiaona")
    public String companyJiaoNa(Model model ,@RequestParam Map map){
        String uaccount = map.get("uaccount")+"";
        model.addAttribute("uaccount",uaccount);
        return "yingyeting/companyjiaona";
    }
    @ResponseBody
    @RequestMapping("/jilu")
    public Object getJiLu(@RequestBody Map map){
        //设置当前第几页和每页显示数量
        System.out.println(map+"6666666");
        PageHelper.startPage(Integer.valueOf(map.get("pageNo")+""),Integer.valueOf(map.get("pageSize")+""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(yingYeTingService.getUcRecord(map));
        System.out.println(yingYeTingService.getUcRecord(map));
        Map resultMap = new HashMap();
        //获取当前页数据
        resultMap.put("pageData",pageInfo.getList());
        //获取分页总数量
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }

    /**
     * 跳转人员缴纳
     * @param model
     * @param map
     * @return
     */
    @RequestMapping("pjiaona")
    public String personJiaoNa(Model model ,@RequestParam Map map){
        return "yingyeting/personjiaona";
    }
    @ResponseBody
    @RequestMapping("/pjilu")
    public Object getPerSonJiaoNa(@RequestBody Map map){
        //设置当前第几页和每页显示数量
        System.out.println(map+"6666666");
        PageHelper.startPage(Integer.valueOf(map.get("pageNo")+""),Integer.valueOf(map.get("pageSize")+""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(yingYeTingService.getPersonJiaoNa(map));
        System.out.println(yingYeTingService.getUcRecord(map));
        Map resultMap = new HashMap();
        //获取当前页数据
        resultMap.put("pageData",pageInfo.getList());
        //获取分页总数量
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }

    /**
     * 跳转人员提取
     * @param model
     * @param map
     * @return
     */
    @RequestMapping("ptiqu")
    public String personTiqu(Model model ,@RequestParam Map map){
        String comp_account = map.get("comp_account")+"";
        model.addAttribute("comp_account",comp_account);
        return "yingyeting/persontiqu";
    }
    @ResponseBody
    @RequestMapping("/tiqu")
    public Object getPerSonTIQu(@RequestBody Map map){
        //设置当前第几页和每页显示数量
        System.out.println(map+"6666666");
        PageHelper.startPage(Integer.valueOf(map.get("pageNo")+""),Integer.valueOf(map.get("pageSize")+""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(yingYeTingService.getPersonTiQu(map));
        System.out.println(yingYeTingService.getUcRecord(map));
        Map resultMap = new HashMap();
        //获取当前页数据
        resultMap.put("pageData",pageInfo.getList());
        //获取分页总数量
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }
}
