package com.aaa.af.service;

import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/18 19:46
 */
public interface AccountService {
    /**
     * 查询个人信息列表
     * @return
     */
    Object getPersons(Map map);
    /**
     * 修改个人信息
     * @param map
     * @return
     */
    int update(Map map);
    /**
     * 获取单位信息
     * @return
     */
    Object getUnitInfo(Map map);
    /**
     * 修改单位信息
     * @param map
     * @return
     */
    int updateUnit(Map map);
}
