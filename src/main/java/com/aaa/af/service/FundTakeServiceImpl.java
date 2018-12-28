package com.aaa.af.service;

import com.aaa.af.dao.FundTakeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:FundTakeServiceImpl
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-18 19:31
 */
@SuppressWarnings("all")
@Service
public class FundTakeServiceImpl implements FundTakeService{
    @Autowired
    private FundTakeDao fundTakeDao;

    @Override
    public Map selectFormInfo(Integer pid) {
        return fundTakeDao.selectFormInfo(pid);
    }

    @Override
    public int takeSubmit(Map map) {

        return fundTakeDao.takeSubmit(map);
    }

    @Override
    public List<Map> selectFundPart(Map map) {
        return fundTakeDao.selectFundPart(map);
    }

    @Override
    public int selectFundCount(Map map) {
        return fundTakeDao.selectFundCount(map);
    }

    @Override
    public int applitation(String GRZH) {
        return fundTakeDao.applitation(GRZH);
    }

    @Override
    public List<Map> selectFundCheck(Map map) {
        return fundTakeDao.selectFundCheck(map);
    }

    @Override
    public int selectCheckCount(Map map) {
        return fundTakeDao.selectCheckCount(map);
    }

    @Override
    public Map checkFundTake(Integer id) {
        return fundTakeDao.checkFundTake(id);
    }

    @Override
    public int takePass(Map map) {
        int i = fundTakeDao.takeSubmitMoney(map);
        if(i>0){
            return fundTakeDao.takePass(map);
        }
        return 0;
    }

    @Override
    public int takeReject(Map map) {
        return fundTakeDao.takeReject(map);
    }

    @Override
    public List<Map> selectFundAppoint(Map map) {
        return fundTakeDao.selectFundAppoint(map);
    }

    @Override
    public int selectAppointCount(Map map) {
        return fundTakeDao.selectAppointCount(map);
    }

    @Override
    public Map appointAppl(Integer LOAN_ID) {
        return fundTakeDao.appointAppl(LOAN_ID);
    }
    @Override
    public int appointSubmit(Map map) {
        return fundTakeDao.appointSubmit(map);
    }

    @Override
    public int panduan(Integer LOAN_ID) {
        return fundTakeDao.panduan(LOAN_ID);
    }

    @Override
    public List<Map> selectAppointCheck(Map map) {
        return fundTakeDao.selectAppointCheck(map);
    }

    @Override
    public  int selectAppCheckCount(Map map) {
        return fundTakeDao.selectAppCheckCount(map);
    }

    @Override
    public int appointPass(Integer aid) {
        return fundTakeDao.appointPass(aid);
    }

    @Override
    public int appointReject(Integer aid) {
        return fundTakeDao.appointReject(aid);
    }
}
