package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/20 21:17
 */
public interface AfterRepayService {
    /**
     * 预期还款列表
     * @param map
     * @return
     */
    List<Map> getList(Map map);
    /**
     * 逾期状态改变
     * @param map
     * @return
     */
    int updateOverRepay(Map map);
}
