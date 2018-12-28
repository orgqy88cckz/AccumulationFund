package com.aaa.af.controller;

import com.aaa.af.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/16 16:53
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    /**
     * 依赖注入
     */
    @Autowired
    private PersonService personService;

    @RequestMapping("/toPerson")
    public Object person(){
        return "company/person";
    }

    /**
     * 根据id查询数据
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getById/{gszh}")
    public Object genById(@PathVariable("gszh") String map){
        return personService.getById(map);
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Map map){
        return personService.add(map);
    }

    /**
     * 个人开户时验证单位账号
     * @param acc
     * @return
     */
    @ResponseBody
    @RequestMapping("/account/{acc}")
    public Object look(@PathVariable("acc") String acc){
        System.out.println(acc+"666666666666666666666666" +
                "TB_ACCOUNT");
        return personService.look(acc);
    }

    /**
     * 银行账户验证
     * @param accou
     * @return
     */
    @ResponseBody
    @RequestMapping("/bank/{accou}")
    public Object bankAccount(@PathVariable("accou") String accou){
        return personService.bankAccount(accou);
    }

    /**
     * 邮箱验证
     * @param ema
     * @return
     */
    @ResponseBody
    @RequestMapping("/email/{ema}")
    public Object emailAccount(@PathVariable("ema") String ema){
        return personService.emailAccount(ema);
    }

    /**
     * 验证手机号
     * @param pnum
     * @return
     */
    @ResponseBody
    @RequestMapping("/pnumber/{pnum}")
    public Object phoneNumber(@PathVariable("pnum") String pnum){
        return personService.phoneNumber(pnum);
    }

    /**
     * 身份证验证
     * @param card
     * @return
     */
    @ResponseBody
    @RequestMapping("/idCard/{card}")
    public Object idCard2(@PathVariable("card") String card){
        System.out.println(card);
        return personService.idCard2(card);
    }
}
