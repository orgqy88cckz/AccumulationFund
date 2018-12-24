package com.aaa.af.service;

import com.aaa.af.dao.JiShuDao;
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
public class JiShuServiceImpl implements JiShuService {

    /**
     * 依赖注入
     */
    @Autowired
    private JiShuDao jiShuDao;

    /**
     * 查询公司分页数据
     * @param map
     * @return
     */
    @Override
    public List<Map> getPageByParm(Map map) {
        return jiShuDao.getPageByParm(map);
    }

    /**
     * 查询公司分页数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return jiShuDao.getPageCount(map);
    }

    /**
     * 查询公司员工分页数据
     * @param map
     * @return
     */
    @Override
    public List<Map> getPageByParm1(Map map) {
        return jiShuDao.getPageByParm1(map);
    }

    /**
     * 查询公司员工分页数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount1(Map map) {
        return jiShuDao.getPageCount1(map);
    }

    /**
     * 根据个人账号 查询个人信息
     * @param map
     * @return
     */
    @Override
    public Map getSelect(String map) {
        return jiShuDao.getSelect(map);
    }

    /**
     * 更改数据库信息
     * @param map
     * @return
     */
    @Override
    public Map update1(Map map) {
        HashMap hashMap = new HashMap();
        //根据个人账号更改 缴存基数 公司缴纳 个人缴纳
        hashMap.put("a",jiShuDao.update1(map));
        //根据个人账号更改公司和个人缴纳总金额
        hashMap.put("c",jiShuDao.updatea(map));
        //根据公司ID更改应缴纳金额
        hashMap.put("b",jiShuDao.update2(map));
        return hashMap;
    }
}
