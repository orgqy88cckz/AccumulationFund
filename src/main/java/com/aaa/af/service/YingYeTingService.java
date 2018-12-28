package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/24 14:21
 */
public interface YingYeTingService {
    /**
     * 获取个人信息
     * @return
     */
    List<Map> getPerson(Map map);
    /**
     * 获取单位信息
     * @param map
     * @return
     */
    List<Map>  getList(Map map);

    /**
     * 公司缴纳记录
     * @param map
     * @return
     */
    List<Map> getUcRecord(Map map);
    /**
     * 人员缴纳记录
     * @param map
     * @return
     */
    List<Map> getPersonJiaoNa(Map map);

    /**
     * 人员提取记录
     * @param map
     * @return
     */
    List<Map> getPersonTiQu(Map map);
}
