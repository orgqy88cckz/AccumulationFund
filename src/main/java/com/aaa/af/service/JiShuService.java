package com.aaa.af.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/19 10:10
 */
public interface JiShuService {

    /**
     * 查询公司分页数据
     * @param map
     * @return
     */
    List<Map> getPageByParm(Map map);

    /**
     * 查询公司分页数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 查询公司员工分页数据
     * @param map
     * @return
     */
    List<Map> getPageByParm1(Map map);

    /**
     * 查询公司员工分页数量
     * @param map
     * @return
     */
    int getPageCount1(Map map);

    /**
     * 根据个人账号 查询个人信息
     * @param map
     * @return
     */
    Map getSelect(String map);

    /**
     * 更改数据库信息
     * @param map
     * @return
     */
    Map update1(Map map);
}
