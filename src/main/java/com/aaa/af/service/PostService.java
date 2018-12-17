package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/17 11:50
 */
public interface PostService {
    /**
     * 查询角色列表
     * @return
     */
    Object getUsers(Map map);
    /**
     * 获取角色列表
     * @return
     */
    List<Map> getRoles();
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
     * 修改前台信息
     * @param map
     * @return
     */
    int update(Map map);
}
