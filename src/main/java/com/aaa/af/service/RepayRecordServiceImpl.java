package com.aaa.af.service;

import com.aaa.af.dao.RepayRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/18 22:26
 */
@Service
public class RepayRecordServiceImpl implements RepayRecordService {
    //依赖注入
    @Autowired
    private RepayRecordDao repayRecordDao;

    /**
     * 获取还款记录
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        return repayRecordDao.getList(map);
    }
}
