package com.aaa.af.service;

import com.aaa.af.dao.TransferAuditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:TransferAuditServiceImpl
 * discription:
 * author:wqy
 * createTime:2018-12-17 08:33
 */
@Service
public class TransferAuditServiceImpl implements TransferAuditService {

    @Autowired
    private TransferAuditDao transferAuditDao;
    @Override
    public List<Map> getPageByParam(Map map) {
        return transferAuditDao.getPageByParam(map);
    }

    @Override
    public int getPageCount(Map map) {
        return transferAuditDao.getPageCount(map);
    }

    @Override
    public int delete(int transfer_id) {
        return transferAuditDao.delete(transfer_id);
    }

    @Override
    public int add(Map map) {
        return transferAuditDao.add(map);
    }

    @Override
    public int updateId(int uaid,int grzh) {
        return transferAuditDao.updateId(uaid,grzh);
    }

    @Override
    public int unitsUpdatea(String uname) {
        return transferAuditDao.unitsUpdatea(uname);
    }

    @Override
    public int unitsUpdateMoneya(String uname) {
        return transferAuditDao.unitsUpdateMoneya(uname);
    }
}
