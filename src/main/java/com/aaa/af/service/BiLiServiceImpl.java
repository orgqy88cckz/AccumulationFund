package com.aaa.af.service;

import com.aaa.af.dao.BiLiDao;
import com.aaa.af.dao.GuaZhangDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class BiLiServiceImpl implements BiLiService {

    /**
     * 依赖注入
     */
    @Autowired
    private BiLiDao biLiDao;

    /**
     * 查询分页数据
     * @param map
     * @return
     */
    @Override
    public List<Map> getPageByParm(Map map) {
        return biLiDao.getPageByParm(map);
    }

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return biLiDao.getPageCount(map);
    }

    /**
     *更新
     * @param map
     * @return
     */
    @Override
    public int update(Map map) {
        //更新个人表单位比例和个人比例
        biLiDao.update1(map);
        //查询自己需要的字段
        List<Map> maps = biLiDao.page1(map);
        //遍历更新个人账户表
        Map map2=new HashMap();
        for (Map map1 : maps) {
            //取值
            Integer id = Integer.valueOf(map1.get("PACCID")+"");
            Integer id1 = Integer.valueOf(map1.get("UAID")+"");
            Integer value1 = Integer.valueOf(map1.get("BASENUMMBER") + "");
            Integer value2 = Integer.valueOf(map1.get("UBITNROP")+"");
            Integer value3 = Integer.valueOf(map1.get("INDINROP") + "");
            //计算公司、个人缴纳金额
            Integer val=value1*value2/100;
            Integer val1=value1*value3/100;
            map2.put("gongsi",val);
            map2.put("geren",val1);
            map2.put("id",id);
            map2.put("id1",id1);
            //根据个人账户id 更新个人缴纳，公司缴纳
            biLiDao.update2(map2);
            //根据个人账户id更新缴纳总额
            biLiDao.update3(map2);
        }
        biLiDao.update4(map2);
        //更新公司表
        return biLiDao.update(map);
    }
}
