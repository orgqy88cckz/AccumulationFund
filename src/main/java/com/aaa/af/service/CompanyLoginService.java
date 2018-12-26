package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/25 9:47
 */
public interface CompanyLoginService {
    /**
     * 获取公司编号和法人证件号
     * @param map
     * @return
     */
    List<Map> getList(Map map);
}
