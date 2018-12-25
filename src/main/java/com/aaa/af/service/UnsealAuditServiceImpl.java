package com.aaa.af.service;

import com.aaa.af.dao.UnsealAuditDao;
import com.aaa.af.dao.UserTransferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:UserTransferServiceImpl
 * discription:启封 封存审核
 * author:wqy
 * createTime:2018-12-11 14:26
 */
@Service
public class UnsealAuditServiceImpl implements UnsealAuditService{

   @Autowired
     private UnsealAuditDao unsealAuditDao;
    @Override
    public List<Map> getPageByParam(Map map) {
        return unsealAuditDao.getPageByParam(map);
    }

    @Override
    public int getPageCount(Map map) {
        return unsealAuditDao.getPageCount(map);
    }

    @Override
    public int archive(String peraccstate, String ypayamt, String grzh) {
        return unsealAuditDao.archive(peraccstate,ypayamt,grzh);
    }

    @Override
    public int unsealAuditUpdate(String audit_name, String bohui, String grzh) {
        return unsealAuditDao.unsealAuditUpdate(audit_name,bohui,grzh);
    }

    @Override
    public int unitsUpdateMoney(String grzh) {
        return unsealAuditDao.unitsUpdateMoney(grzh);
    }

    @Override
    public int unitsMoney(String grzh) {
        return unsealAuditDao.unitsMoney(grzh);
    }

    @Override
    public int unitsUpdate(String uname) {
        return unsealAuditDao.unitsUpdate(uname);
    }

    @Override
    public List<Map> getPageByParam2(Map map) {
        return unsealAuditDao.getPageByParam2(map);
    }

    @Override
    public int getPageCount2(Map map) {
        return unsealAuditDao.getPageCount2(map);
    }

}
