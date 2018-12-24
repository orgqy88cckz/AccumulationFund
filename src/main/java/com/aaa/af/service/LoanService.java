package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/22 16:21
 */
public interface LoanService {
    /**
     * 获取贷款列表
     * @param map
     * @return
     */
    List<Map> getList(Map map);
}
