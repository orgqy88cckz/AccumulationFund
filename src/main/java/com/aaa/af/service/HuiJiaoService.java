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

    /**
     * 查询分页数据
     * @param map
     * @return
     */
    List<Map> getPageByParm(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 根据公司账号查询数据
     * @param map
     * @return
     */
    Map getSelect(String map);

    /**
     * 更新
     * @param map
     * @return
     */
    Map update(Map map);
}
