package com.aaa.af.service;

import com.aaa.af.dao.AheadRepayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/19 10:00
 */
@Service
public class AheadRepayServiceImpl implements AheadRepayService {
    //依赖注入
    @Autowired
    private AheadRepayDao aheadRepayDao;

    /**
     * 还款列表
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        return aheadRepayDao.getList(map);
    }

    /**
     * 更新还款数据
     * @param map
     * @return
     */
    @Override
    public int update(Map map) {
        return aheadRepayDao.update(map);
    }

    /**
     * 添加还款记录
     * @param map
     * @return
     */
    @Override
    public int addInfo(Map map) {
        return aheadRepayDao.addInfo(map);
    }

    /**
     * 查询记录
     * @param map
     * @return
     */
    @Override
    public List<Map> getRecord(Map map) {
        return aheadRepayDao.getRecord(map);
    }

    /**
     * 更新还款状态
     * @param map
     * @return
     */
    @Override
    public int updateState(Map map) {
        return aheadRepayDao.updateState(map);
    }
}
