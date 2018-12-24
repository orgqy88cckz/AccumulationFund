package com.aaa.af.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/11 15:47
 */

public interface RepayService {
    /**
     * 获取还款列表
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 根据ID查询个人还款记录
     * @param id
     * @return
     */
    List<Map> getListById(int id);

    /**
     * 更新还款后数据
     * @param map
     * @return
     */
    int update (Map map);

    /**
     * 分期还款后添加还款信息到个人还款记录
     * @param map
     * @return
     */
    int addInfo(Map map);

    /**
     * 查询个人还款记录
     * @param map
     * @return
     */
    List<Map> getRecord(Map map);

    /**
     * 更新还款状态
     * @param map
     * @return
     */
    int updateState(Map map);
    int updState(Map map);
}
