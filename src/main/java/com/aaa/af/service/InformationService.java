package com.aaa.af.service;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/7 19:44
 */
public interface InformationService {
    /**
     *信息传到前台
     * @return
     */
    List<Map> xinxiListMaps(int a );
    /**
     * 分页查询信息表
     * @return
     */
    List<Map> getInformations(Map map);
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

    /**
     * 个人账户是否存在
     * @param map
     * @return
     */
    String checkPerson(Map map, Model model);
}
