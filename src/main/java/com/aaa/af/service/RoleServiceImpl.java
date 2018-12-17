package com.aaa.af.service;

import com.aaa.af.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/15 8:40
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public Object getRoles(Map map) {
        Map resulMap=new HashMap();
        resulMap.put("pageData",roleDao.getRoles(map));
        resulMap.put("total",roleDao.getPageCount(map));
        return resulMap;
    }

    @Override
    public int getPageCount(Map map) {
        return roleDao.getPageCount(map);
    }

    @Override
    public int add(Map map) {
        return roleDao.add(map);
    }

    @Override
    public int delete(int id) {
        return roleDao.delete(id);
    }

    @Override
    public int update(Map map) {
        return roleDao.update(map);
    }

    @Override
    public Object getTreeid(Map map) {
        Map resulMap=new HashMap();
        resulMap.put("expande",roleDao.getParentTreeid(map));
        resulMap.put("checked",roleDao.getTreeid(map));
        return resulMap;
    }

    @Override
    public int updataTree(Map map) {
        //删除角色下的所有权限
        int i = roleDao.deleteTreeids(map);
        Object roleids = map.get("ROLEIDS");
        String s = roleids.toString();
        String[] split = s.split(",");
        int j=0;
        for (String s1 : split) {
            Integer integer = Integer.valueOf(s1);
            map.put("INTEGER",integer);
            roleDao.addTreeids(map);
            j++;
        }
        return j;
    }
}
