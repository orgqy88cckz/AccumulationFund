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

    /**
     * 查询单位账户是否存在
     * @param acc
     * @return
     */
    @Override
    public int look(String acc) {
        return personDao.look(acc);
    }

    /**
     * 开户银行账号唯一性验证
     * @param accou
     * @return
     */
    @Override
    public int bankAccount(String accou) {
        return personDao.bankAccount(accou);
    }

    /**
     * 邮箱验证
     * @param ema
     * @return
     */
    @Override
    public int emailAccount(String ema) {
        return personDao.emailAccount(ema);
    }

    /**
     * 验证手机号
     * @param pnum
     * @return
     */
    @Override
    public int phoneNumber(String pnum) {
        return personDao.phoneNumber(pnum);
    }

    /**
     * 身份证验证
     * @param card
     * @return
     */
    @Override
    public int idCard2(String card) {
        return personDao.idCard2(card);
    }
}
