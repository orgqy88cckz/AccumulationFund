package com.aaa.af.service;

import com.aaa.af.dao.YingYeTingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/24 14:23
 */
@Service
public class YingYeTingServiceImpl implements YingYeTingService{
    @Autowired
    private YingYeTingDao yingYeTingDao;
    @Override
    public List<Map> getPerson(Map map) {
        return yingYeTingDao.getPerson(map);
    }
}
