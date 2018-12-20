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
}
