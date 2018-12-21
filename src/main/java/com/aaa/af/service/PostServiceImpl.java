package com.aaa.af.service;

import com.aaa.af.dao.PostDao;
import com.aaa.af.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/17 11:51
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;
    @Override
    public Object getUsers(Map map) {
        Map resulMap=new HashMap();
        resulMap.put("pageData",postDao.getUsers(map));
        resulMap.put("total",postDao.getPageCount(map));
        return resulMap;
    }

    @Override
    public List<Map> getRoles() {
        return postDao.getRoles();
    }

    @Override
    public int add(Map map) {
        return postDao.add(map);
    }

    @Override
    public int delete(int id) {
        return postDao.delete(id);
    }

    @Override
    public int update(Map map) {
        return postDao.update(map);
    }

}
