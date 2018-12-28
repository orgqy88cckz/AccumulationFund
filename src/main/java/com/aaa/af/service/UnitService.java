package com.aaa.af.service;

import java.util.List;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 公司名称唯一性验证
     * @param name
     * @return
     */
    int uname(String name);

    /**
     * 身份证号码唯一性验证
     * @param card
     * @return
     */
    int idCard(String card);

    /**
     * 经办人身份证唯一性验证
     * @param card
     * @return
     */
    int idCard1(String card);

    /**
     * 经办人电话唯一性验证
     * @param num
     * @return
     */
    int phone(String num);
}
