package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/12 08:30
 */
public interface UnitService {

    /**
     * 添加方法
     * @param map
     * @return
     */
    Map add(Map map);

    /**
     * 明细列表查询
     * @param map
     * @return
     */
    List<Map> detail(Map map);

    /**
     * 明细列表数量查询
     * @param map
     * @return
     */
    int count(Map map);
}
