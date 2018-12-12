package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * className:SearchInfoDao
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-12 20:35
 */
public interface SearchInfoDao {

    /**
     * 根据个人账号查询个人信息
     * @return
     */
    @Select("select * from TB_PERSON_INFO")
    Map getPersonInfo(String account);
}
