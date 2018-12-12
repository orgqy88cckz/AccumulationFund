package com.aaa.af.service;

import com.aaa.af.dao.InformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/7 19:54
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationDao informationDao;
    @Override
    public List<Map> xinxiListMaps(int a) {
        return informationDao.xinxiListMaps(a);
    }

    @Override
    public List<Map> getInformations(Map map) {
        return informationDao.getInformations(map);
    }

    @Override
    public int getPageCount(Map map) {
        return informationDao.getPageCount(map);
    }

    @Override
    public int add(Map map) {
        Object sname = map.get("SNAME");
        if(sname.equals("发布中")){
            map.put("INFORMSTATUS",1);
        }else if(sname.equals("未发布")){
            map.put("INFORMSTATUS",2);
        }
        return informationDao.add(map);
    }

    @Override
    public int delete(int id) {
        return informationDao.delete(id);
    }

    @Override
    public int batchDelete(String ids) {
        String[] idsArray=ids.split(",");
        List list=new ArrayList();
        for(String s:idsArray){
            list.add(s);
        }
        return informationDao.batchDelete(list);
    }

    @Override
    public int update(Map map) {
        Object sname = map.get("SNAME");
        if(sname.equals("发布中")){
            map.put("INFORMSTATUS",1);
        }else if(sname.equals("未发布")){
            map.put("INFORMSTATUS",2);
        }
        Object tname = map.get("TNAME");
        if(tname.equals("通知公告")){
            map.put("INFORMTYPE",4);
        }else if(tname.equals("工作动态")){
            map.put("INFORMTYPE",5);
        }else if(tname.equals("执法公告")){
            map.put("INFORMTYPE",6);
        }
        return informationDao.update(map);
    }
}
