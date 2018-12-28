package com.aaa.af.service;

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

    //依赖注入
    @Autowired
    private HuiJiaoDao huiJiaoDao;

    /**
     * 查询分页数据
     * @param map
     * @return
     */
    @Override
    public List<Map> getPageByParm(Map map) {
        return huiJiaoDao.getPageByParm(map);
    }

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return huiJiaoDao.getPageCount(map);
    }

    /**
     * 根据公司账号查询数据出
     * @param map
     * @return
     */
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
        HashMap hashMap = new HashMap();
        //汇缴成功时提交汇缴日期
        hashMap.put("a",huiJiaoDao.update(map));
        //汇缴成功时单位余额当减少
        hashMap.put("b",huiJiaoDao.update1(map));
        //汇缴成功时更改个人汇缴日期
        hashMap.put("c",huiJiaoDao.update2(map));

        List<Map> mapList= huiJiaoDao.select2(map);
        for (Map map1 : mapList) {
            huiJiaoDao.insert(map1);
        }
        List<Map> maps = huiJiaoDao.select1(map);
        //循环向个人账户更新信息
        for (Map mapa : maps) {
            huiJiaoDao.update3(mapa);
            huiJiaoDao.insert1(mapa);
        }

        return hashMap;
    }
}
