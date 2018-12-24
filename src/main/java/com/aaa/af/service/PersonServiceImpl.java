package com.aaa.af.service;

import com.aaa.af.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/16 17:07
 */
@Service
public class PersonServiceImpl implements PersonService{

    /**
     * 依赖注入
     */
    @Autowired
    private PersonDao personDao;

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public Map getById(String id) {
        return personDao.getById(id);
    }

    /**
     * 更新数据库信息
     * @param map
     * @return
     */
    @Override
    public Map add(Map map) {
        Map map1 = new HashMap();
        //向个人账户添加信息
        map1.put("a",personDao.add(map));
        map1.put("b",personDao.add1(map));
        //更新单位账户信息
        map1.put("c",personDao.update(map));
        map1.put("d",personDao.update1(map));
        return map1;
    }

}
