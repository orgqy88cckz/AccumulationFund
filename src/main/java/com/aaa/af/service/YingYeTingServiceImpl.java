package com.aaa.af.service;

import com.aaa.af.dao.YingYeTingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/24 14:23
 */
@Service
public class YingYeTingServiceImpl implements YingYeTingService{
    @Autowired
    private YingYeTingDao yingYeTingDao;
    @Override
    public List<Map> getPerson(Map map) {
        return yingYeTingDao.getPerson(map);
    }

    @Override
    public List<Map> getLoan(Map map) {
        return yingYeTingDao.getLoan(map);
    }

    @Override
    public Void zhifu(Map map, Model model) {
        Object money = map.get("jine");
        model.addAttribute("money",money);
        return null;
    }

    @Override
    public Object getJiaona(Map map) {
        System.out.println(map);
        Map resulMap=new HashMap();
        resulMap.put("pageData",yingYeTingDao.getJiaona(map));
        resulMap.put("total",yingYeTingDao.getPageCount(map));
        return resulMap;
    }


    @Override
    public List<Map> getList(Map map) {
        return yingYeTingDao.getList(map);
    }

    @Override
    public List<Map> getUcRecord(Map map) {
        return yingYeTingDao.getUcRecord(map);
    }

    @Override
    public List<Map> getPersonJiaoNa(Map map) {
        return yingYeTingDao.getPersonJiaoNa(map);
    }

    @Override
    public List<Map> getPersonTiQu(Map map) {
        return yingYeTingDao.getPersonTiQu(map);
    }
}
