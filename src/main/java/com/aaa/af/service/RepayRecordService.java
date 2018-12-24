package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/18 22:25
 */
public interface RepayRecordService {
    /**
     * 获取还款记录
     * @param map
     * @return
     */
    List<Map> getList(Map map);
}
