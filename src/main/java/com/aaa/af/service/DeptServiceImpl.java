package com.aaa.af.service;

import com.aaa.af.dao.DeptDao ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptServiceImpl
 * discription:
 * author:zz
 * createTime:2018-11-21 11:29
 */
@Service
public class DeptServiceImpl implements  DeptService {

    //依赖注入
    @Autowired
    private DeptDao deptDao;

    @Override
    public int update(Map map) {
        return deptDao.update(map);
    }

    @Override
    public int delete(int deptNo) {
        return deptDao.delete(deptNo);
    }

    @Override
    public Map getListById(int deptNo) {
        return deptDao.getListById(deptNo);
    }

    @Override
    public int addDept(Map map) {
        return deptDao.addDept(map);
    }

    @Override
    public List<Map> getList() {
        return deptDao.getList();
    }
}
