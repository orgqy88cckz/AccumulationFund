package com.aaa.af.service;

import com.aaa.af.dao.GuaZhangDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/19 10:10
 */
@Service
public class GuaZhangServiceImpl implements GuaZhangService {

    @Autowired
    private GuaZhangDao guaZhangDao;

    @Override
    public List<Map> getPageByParm(Map map) {
        return guaZhangDao.getPageByParm(map);
    }

    @Override
    public int getPageCount(Map map) {
        return guaZhangDao.getPageCount(map);
    }

    @Override
    public int update(Map map) {
        return guaZhangDao.update(map);
    }
}
