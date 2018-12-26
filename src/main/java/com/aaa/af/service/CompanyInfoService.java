package com.aaa.af.service;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/25 11:18
 */
public interface CompanyInfoService {
    /**
     * 个人账户是否存在
     * @param map
     * @return
     */
    String checkCompany(Map map, Model model);
}
