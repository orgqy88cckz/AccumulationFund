package com.aaa.af.service;


import com.aaa.af.dao.UnitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/12 08:30
 */
@Service
public class UnitServiceImpl implements UnitService{

    /**
     * 依赖注入
     */
    @Autowired
    private UnitDao unitDao;

    /**
     * 添加方法
     * @param map
     * @return
     */
    @Override
    public Map add(Map map) {
        int add = unitDao.add(map);
        int i = unitDao.add1(map);
        Map paramMap =new HashMap();
        paramMap.put("add",add);
        paramMap.put("i",i);
        return paramMap;
    }

    /**
     * 公司名称唯一性验证
     * @param name
     * @return
     */
    @Override
    public int uname(String name) {
        return unitDao.uname(name);
    }

    /**
     * 法人身份证号码唯一性验证
     * @param card
     * @return
     */
    @Override
    public int idCard(String card) {
        return unitDao.idCard(card);
    }

    /**
     * 经办人身份证唯一验证
     * @param card
     * @return
     */
    @Override
    public int idCard1(String card) {
        return unitDao.idCard1(card);
    }

    /**
     * 手机号唯一验证
     * @param num
     * @return
     */
    @Override
    public int phone(String num) {
        return unitDao.phone(num);
    }
}
