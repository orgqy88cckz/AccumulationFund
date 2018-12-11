package com.aaa.af.service;

import com.aaa.af.dao.InformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/7 19:54
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationDao informationDao;
    @Override
    public List<Map> xinxiListMaps(int a) {
        return informationDao.xinxiListMaps(a);
    }
}
