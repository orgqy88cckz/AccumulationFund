package com.aaa.af.service;

import com.aaa.af.entity.User;

/**
 * className:UserService
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-01 15:11
 */
public interface UserService {
    User findByName(String name);

    User findById(Integer id);
}
