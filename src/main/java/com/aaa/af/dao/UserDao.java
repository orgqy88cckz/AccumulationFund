package com.aaa.af.dao;

import com.aaa.af.entity.User;

/**
 * className:UserDao
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-01 14:52
 */
public interface UserDao {
    User findByName(String name);

    User findById(Integer id);

}
