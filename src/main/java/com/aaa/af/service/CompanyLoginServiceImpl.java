package com.aaa.af.service;

import com.aaa.af.dao.CompanyLoginDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/25 9:48
 */
@Service
public class CompanyLoginServiceImpl implements  CompanyLoginService {
    //依赖注入
    private CompanyLoginDao companyLoginDao;
    /**
     * 获取公司编号和法人证件号
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        return companyLoginDao.getList(map);
    }
}
