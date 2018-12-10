package com.aaa.af.controller;

import com.aaa.af.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * className:TreeController
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-08 16:11
 */
@Controller
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @ResponseBody
    @RequestMapping("list")
    public Object getListTree(){
        return treeService.getListTree();
    }


}
