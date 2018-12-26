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
public interface BuJiaoService {

    List<Map> getPageByParm(Map map);

    int getPageCount(Map map);

    /**
     * 根据公司账号查询数据
     * @param map
     * @return
     */
    Map getSelect(Map map);

    /**
     * 更新
     * @param map
     * @return
     */
    Map update(Map map);

    /**
     * 查询监听键盘事件所需要的数据
     * @param id
     * @return
     */
    Map getById(String id);
}
