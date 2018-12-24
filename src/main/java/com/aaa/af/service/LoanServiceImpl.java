package com.aaa.af.service;

import com.aaa.af.dao.LoanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/22 16:30
 */
@Service
public class LoanServiceImpl implements  LoanService{
    //依赖注入
    @Autowired
    private LoanDao loanDao;

    @Override
    public List<Map> getList(Map map) {
        return loanDao.getList(map);
    }
}
