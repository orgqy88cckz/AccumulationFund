package com.aaa.af.service;

import com.aaa.af.dao.AfterRepayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/20 21:24
 */
@Service
public class AfterRepayServiceImpl implements  AfterRepayService {
    //依赖注入
    @Autowired
    private AfterRepayDao afterRepayDao;

    /**
     * 获取逾期还款列表
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        return afterRepayDao.getList(map);
    }

    /**
     * 逾期状态改变
     * @param map
     * @return
     */
    @Override
    public int updateOverRepay(Map map) {
        return afterRepayDao.updateOverRepay(map);
    }
}
