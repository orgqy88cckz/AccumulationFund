package com.aaa.af.service;

import com.aaa.af.dao.UserTransferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:UserTransferServiceImpl
 * discription:人员转移
 * author:wqy
 * createTime:2018-12-11 14:26
 */
@Service
public class UserTransferServiceImpl implements UserTransferService{

   @Autowired
     private UserTransferDao userTransferDao;
    @Override
    public List<Map> getPageByParam(Map map) {
        return userTransferDao.getPageByParam(map);
    }

    @Override
    public int getPageCount(Map map) {
        return userTransferDao.getPageCount(map);
    }

    @Override
    public Map selectByName(String tb_pname) {
        return userTransferDao.selectByName(tb_pname);
    }

    @Override
    public List<Map> getUnit() {
        return userTransferDao.getUnit();
    }

    @Override
    public Map getUintById(Integer id) {
        return userTransferDao.getUintById(id);
    }

    @Override
    public int add(Map map) {
        return userTransferDao.add(map);
    }

    @Override
    public List<Map> getPageByParam2(Map map) {
        return userTransferDao.getPageByParam2(map);
    }

    @Override
    public int getPageCount2(Map map) {
        return userTransferDao.getPageCount2(map);
    }

    @Override
    public Map submitVerify(String idnumber) {
        return userTransferDao.submitVerify(idnumber);
    }
}
