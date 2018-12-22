package com.aaa.af.service;

import com.aaa.af.dao.JiShuDao;
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
 * @Date: 2018/12/19 10:10
 */
@Service
public class JiShuServiceImpl implements JiShuService {

    @Autowired
    private JiShuDao jiShuDao;

    @Override
    public List<Map> getPageByParm(Map map) {
        return jiShuDao.getPageByParm(map);
    }

    @Override
    public int getPageCount(Map map) {
        return jiShuDao.getPageCount(map);
    }

    @Override
    public int update(Map map) {
        return jiShuDao.update(map);
    }

    @Override
    public List<Map> getPageByParm1(Map map) {
        return jiShuDao.getPageByParm1(map);
    }

    @Override
    public int getPageCount1(Map map) {
        return jiShuDao.getPageCount1(map);
    }

    @Override
    public Map getSelect(String map) {
        return jiShuDao.getSelect(map);
    }

    @Override
    public Map update1(Map map) {
        System.out.println(map);
        int a = jiShuDao.update1(map);
        int c = jiShuDao.updatea(map);
        int b = jiShuDao.update2(map);
        HashMap hashMap = new HashMap();
        hashMap.put("a",a);
        hashMap.put("c",c);
        hashMap.put("b",b);
        return hashMap;
    }
}
