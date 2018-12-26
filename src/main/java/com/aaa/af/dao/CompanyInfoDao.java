package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/25 11:15
 */
public interface CompanyInfoDao {

    /**
     * 查看账户是否存在
     * @param map
     * @return
     */
    @Select("select count(*) from tb_unit where dwxz=#{username}")
    int getPersonAccount(Map map);

    /**
     * 获取个人密码
     * @param map
     * @return
     */
    @Select("select ulegalcard from tb_unit where dwxz=#{username}")
    List<Map> getPersonPassword(Map map);
}
