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

    @Autowired
    private PersonDao personDao;
    @Override
    public Map getById(String id) {
        return personDao.getById(id);
    }

    @Override
    public Map add(Map map) {
        int a = personDao.add(map);
        int b = personDao.add1(map);
        int c = personDao.update(map);
        int d = personDao.update1(map);
        Map map1 = new HashMap();
        map1.put("a",a);
        map1.put("b",b);
        map1.put("c",c);
        map1.put("d",d);
        return map1;
    }

}
