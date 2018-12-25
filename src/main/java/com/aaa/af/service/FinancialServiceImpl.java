package com.aaa.af.service;

import com.aaa.af.dao.FinancialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:FinancialServiceImpl
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-24 21:12
 */
@SuppressWarnings("all")
@Service
public class FinancialServiceImpl implements FinancialService{
    @Autowired
    private FinancialDao financialDao;

    /**
     * 归集情况分析  查询每月公积金提取的总金额
     * @return
     */
    @Override
    public List<Map> GJFX() {
        return financialDao.GJFX();
    }

    /**
     * 统计每月汇缴金额
     * @return
     */
    @Override
    public List<Map> huijiao() {
        return financialDao.huijiao();
    }

    @Override
    public List<Map> daiKuanXinXi() {
        return financialDao.daiKuanXinXi();
    }

    @Override
    public List<Map> huanKuanXinXi() {
        return financialDao.huanKuanXinXi();
    }

    @Override
    public List<Map> tiqu() {
        return financialDao.tiqu();
    }

    @Override
    public List<Map> huijiaoPer() {
        return financialDao.huijiaoPer();
    }
}
