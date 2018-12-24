package com.aaa.af.service;

import com.aaa.af.dao.BuJiaoDao;
import com.aaa.af.dao.HuiJiaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class BuJiaoServiceImpl implements BuJiaoService {

    @Autowired
    private BuJiaoDao buJiaoDao;

    @Override
    public List<Map> getPageByParm(Map map) {
        return buJiaoDao.getPageByParm(map);
    }

    @Override
    public int getPageCount(Map map) {
        return buJiaoDao.getPageCount(map);
    }

    @Override
    public Map getSelect(Map map) {
        return buJiaoDao.getSelect(map);
    }

    @Override
    public Map getById(String id) {
        return buJiaoDao.getById(id);
    }
    /**
     * 汇缴成功时更改数据库信息
     * @param map
     * @return
     */
    @Override
    public Map update(Map map) {
        int c = buJiaoDao.update2(map);
        HashMap hashMap = new HashMap();
        hashMap.put("a",buJiaoDao.update(map));
        hashMap.put("b",buJiaoDao.update1(map));
        hashMap.put("c",c);
        List<Map> maps = buJiaoDao.select1(map);
        for (Map mapa : maps) {
            buJiaoDao.update3(mapa);
        }

        return hashMap;
    }
}
