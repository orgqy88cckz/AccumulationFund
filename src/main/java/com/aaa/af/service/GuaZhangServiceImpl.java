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

    /**
     * 依赖注入
     */
    @Autowired
    private GuaZhangDao guaZhangDao;

    /**
     * 查询分页数据
     * @param map
     * @return
     */
    @Override
    public List<Map> getPageByParm(Map map) {
        return guaZhangDao.getPageByParm(map);
    }

    /**
     * 查询分页数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return guaZhangDao.getPageCount(map);
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @Override
    public int update(Map map) {
        return guaZhangDao.update(map);
    }
}
