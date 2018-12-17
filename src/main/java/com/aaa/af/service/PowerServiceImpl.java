package com.aaa.af.service;

import com.aaa.af.dao.PowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/13 20:31
 */
@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerDao powerDao;
    @Override
    public List<Map> getPowers(Map map) {
        return powerDao.getPowers(map);
    }

    @Override
    public int getPageCount(Map map) {
        return powerDao.getPageCount(map);
    }

    @Override
    public List<Map> getParents() {
        return powerDao.getParents();
    }

    @Override
    public int add(Map map) {
        return powerDao.add(map);
    }

    @Override
    public int delete(int id) {
        return powerDao.delete(id);
    }

    @Override
    public int batchDelete(String ids) {
        String[] idsArray=ids.split(",");
        List list=new ArrayList();
        for(String s:idsArray){
            list.add(s);
        }
        return powerDao.batchDelete(list);
    }

    @Override
    public int update(Map map) {
        return powerDao.update(map);
    }
}
