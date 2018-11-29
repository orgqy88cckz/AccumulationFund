package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptService
 * discription:
 * author:zz
 * createTime:2018-11-21 11:28
 */
public interface DeptService {
    /**
     * 部门列表查询
     * @return
     */
    List<Map> getList();
    /**
     * 部门添加
     * @param map
     * @return
     */
    int addDept(Map map);
    /**
     * 通过deptNo查询数据
     * @param deptNo
     * @return
     */
    Map getListById(int deptNo);
    /**
     * 更新员工列表
     * @param map
     * @return
     */
    int update(Map map);
    /**
     * 删除部门
     * @param deptNo
     * @return
     */
    int delete(int deptNo);
}
