package com.aaa.af.service;


import com.aaa.af.dao.UnitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<Map> detail(Map map) {
        return unitDao.detail(map);
    }

    @Override
    public int count(Map map) {
        return unitDao.count(map);
    }
}
