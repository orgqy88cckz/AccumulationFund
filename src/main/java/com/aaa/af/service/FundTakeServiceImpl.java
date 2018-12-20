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
        fundTakeDao.takeSubmitMoney(map);
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
}
