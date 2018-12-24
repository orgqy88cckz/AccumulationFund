package com.aaa.af.service;

import com.aaa.af.dao.ApprovalDao;
import com.aaa.af.dao.MergeDao;
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
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalDao approvalDao;
    @Override
    public List<Map> getPageByParam(Map map) {
        return approvalDao.getPageByParam(map);
    }

    @Override
    public int getPageCount(Map map) {
        return approvalDao.getPageCount(map);
    }

    @Override
    public List<Map> getPageByParamR(Map map) {
        return approvalDao.getPageByParamR(map);
    }

    @Override
    public int getPageCountR(Map map) {
        return approvalDao.getPageCountR(map);
    }

    @Override
    public List<Map> getPageByParamF(Map map) {
        return approvalDao.getPageByParamF(map);
    }

    @Override
    public int getPageCountF(Map map) {
        return approvalDao.getPageCountF(map);
    }

    @Override
    public List<Map> getPageByParamG(Map map) {
        return approvalDao.getPageByParamG(map);
    }

    @Override
    public int getPageCountG(Map map) {
        return approvalDao.getPageCountG(map);
    }

    @Override
    public List<Map> getPageByParamGJ(Map map) {
        return approvalDao.getPageByParamGJ(map);
    }

    @Override
    public int getPageCountGJ(Map map) {
        return approvalDao.getPageCountGJ(map);
    }

    @Override
    public int accraditationCount() {
        return approvalDao.accraditationCount();
    }

    @Override
    public int accraditationCountb() {
        return approvalDao.accraditationCountb();
    }

    @Override
    public int accraditationCountt() {
        return approvalDao.accraditationCountt();
    }

    @Override
    public int accraditationCounts() {
        return approvalDao.accraditationCounts();
    }

    @Override
    public int addAccraditationCount(int accraditation_flux, String accraditation_name) {
        return approvalDao.addAccraditationCount(accraditation_flux,accraditation_name);
    }


}
