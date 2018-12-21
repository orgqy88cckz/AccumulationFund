package com.aaa.af.service;

import com.aaa.af.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/18 19:48
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public Object getPersons(Map map) {
        Map resulMap=new HashMap();
        resulMap.put("pageData",accountDao.getPersonInfo(map));
        resulMap.put("total",accountDao.getPageCount(map));
        return resulMap;
    }

    @Override
    public int update(Map map) {
        return accountDao.update(map);
    }

    @Override
    public Object getUnitInfo(Map map) {
        Map resulMap=new HashMap();
        resulMap.put("pageData",accountDao.getUnitInfo(map));
        resulMap.put("total",accountDao.getUnitPageCount(map));
        return resulMap;
    }

    @Override
    public int updateUnit(Map map) {
        int i1 = accountDao.updateUnit(map);
        int i = accountDao.updateUnitAccount(map);
        return i1+i;
    }
}
