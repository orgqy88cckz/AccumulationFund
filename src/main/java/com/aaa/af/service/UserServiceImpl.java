package com.aaa.af.service;

import com.aaa.af.dao.UserDao;
import com.aaa.af.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * className:UserServiceImpl
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-01 15:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
