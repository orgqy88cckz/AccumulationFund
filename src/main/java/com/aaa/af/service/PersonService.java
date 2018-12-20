package com.aaa.af.service;


import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/16 17:06
 */
public interface PersonService {

    Map getById(String id);

    /**
     * 添加
     * @param map
     * @return
     */
    Map add(Map map);
}
