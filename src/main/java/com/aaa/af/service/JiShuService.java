package com.aaa.af.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/19 10:10
 */
public interface JiShuService {

    List<Map> getPageByParm(Map map);

    int getPageCount(Map map);

    int update(Map map);

    List<Map> getPageByParm1(Map map);


    int getPageCount1(Map map);

    Map getSelect(String map);

    Map update1(Map map);
}
