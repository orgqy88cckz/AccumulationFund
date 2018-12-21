package com.aaa.af.service;

import com.aaa.af.dao.MergeDao;
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
public class MergeServiceImpl implements MergeService {

    @Autowired
    private MergeDao mergeDao;
    @Override
    public List<Map> getPageByParam(Map map) {
        return mergeDao.getPageByParam(map);
    }

    @Override
    public int getPageCount(Map map) {
        return mergeDao.getPageCount(map);
    }

    @Override
    public Map verification(String grzh) {
        return mergeDao.verification(grzh);
    }

    @Override
    public Map loansVerification(String grzh) {
        return mergeDao.loansVerification(grzh);
    }

    @Override
    public int add(Map map) {
        return mergeDao.add(map);
    }

}
