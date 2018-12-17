package com.aaa.af.service;


import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/13 20:30
 */
public interface PowerService {
    /**
     * 查询权限节点
     * @return
     */
    List<Map> getPowers(Map map);
    /**
     * 查询分页总数量
     * @return
     */
    int getPageCount(Map map);
    /**
     * 获取父节点列表
     * @return
     */
    List<Map> getParents();
    /**
     * 添加
     * @param map
     * @return
     */
    int add(Map map);
    /**
     * 删除
     * @param id
     * @return
     */
    int delete(int id);
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(String ids);
    /**
     * 修改前台信息
     * @param map
     * @return
     */
    int update(Map map);
}
