package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/19 10:10
 */
public interface HuiJiaoService {

    List<Map> getPageByParm(Map map);

    int getPageCount(Map map);

    /**
     * 根据公司账号查询数据
     * @param map
     * @return
     */
    Map getSelect(String map);

    Map update(Map map);
}
