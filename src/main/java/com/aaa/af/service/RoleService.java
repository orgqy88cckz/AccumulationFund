package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/15 8:38
 */
public interface RoleService {
    /**
     * 查询角色列表
     * @return
     */
    Object getRoles(Map map);
    /**
     * 查询分页总数量
     * @return
     */
    int getPageCount(Map map);
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
    /**
     * 获取角色权限ID
     * @param map
     * @return
     */
    Object getTreeid(Map map);

    /**
     * 修改权限
     * @param map
     * @return
     */
    int updataTree(Map map);
}
