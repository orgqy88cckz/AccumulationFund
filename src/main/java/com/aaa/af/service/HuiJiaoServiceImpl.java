package com.aaa.af.service;

import com.aaa.af.dao.BiLiDao;
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
public class HuiJiaoServiceImpl implements HuiJiaoService {

    @Autowired
    private HuiJiaoDao huiJiaoDao;

    @Override
    public List<Map> getPageByParm(Map map) {
        return huiJiaoDao.getPageByParm(map);
    }

    @Override
    public int getPageCount(Map map) {
        return huiJiaoDao.getPageCount(map);
    }

    @Override
    public Map getSelect(String map) {
        return huiJiaoDao.getSelect(map);
    }

    /**
     * 汇缴成功时更改数据库信息
     * @param map
     * @return
     */
    @Override
    public Map update(Map map) {
        System.out.println(map+"777777777777777777777777777777777777777777777");
        int c = huiJiaoDao.update2(map);
        HashMap hashMap = new HashMap();
        hashMap.put("a",huiJiaoDao.update(map));
        hashMap.put("b",huiJiaoDao.update1(map));
        hashMap.put("c",c);
        System.out.println(c+"666666666666666666666666666666666666666666666666");
        List<Map> maps = huiJiaoDao.select1(map);
        for (Map mapa : maps) {
            huiJiaoDao.update3(mapa);
        }

        return hashMap;
    }
}
