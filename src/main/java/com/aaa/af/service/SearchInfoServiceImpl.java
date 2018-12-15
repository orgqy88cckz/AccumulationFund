package com.aaa.af.service;

import com.aaa.af.dao.SearchInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:SearchInfoServiceImpl
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-12 21:08
 */
@SuppressWarnings("all")
@Service
public class SearchInfoServiceImpl implements SearchInfoService{

    @Autowired
    private SearchInfoDao searchInfoDao;

    @Override
    public List<Map> selectGRZH() {
        return searchInfoDao.selectGRZH();
    }

    @Override
    public int addInfo(List<Map> map) {
        int i=0;
        Map map2=new HashMap();
        for (Map map1 : map) {
            map2.putAll(map1);
        }
        System.out.println(map2+"*************************************");
        i = searchInfoDao.addInfo(map2);
        return i;
    }

    @Override
    public Map getPersonInfo(String account) {
        return searchInfoDao.getPersonInfo(account);
    }
}
