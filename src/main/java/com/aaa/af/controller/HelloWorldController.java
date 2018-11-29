package com.aaa.af.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className:HelloWorldController
 * discription:
 * author:Cheng Fangying
 * createTime:2018-11-21 10:19
 */
@RestController
public class HelloWorldController {
    @RequestMapping("hello")
    public Object print(){return "hello world";}
}
