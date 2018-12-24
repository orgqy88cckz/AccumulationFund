package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/19 9:55
 */
public interface AheadRepayService {

    /**
     * 获取还款列表
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 更新还款后数据
     * @param map
     * @return
     */
    int update(Map map);
    /**
     * 提前还款后添加还款信息到个人还款记录
     * @param map
     * @return
     */
    int addInfo(Map map);

    /**
     * 查询记录
     */
    List<Map> getRecord(Map map);

    /**
     * 更新还款状态
     * @param map
     * @return
     */
    int updateState(Map map);
}
