package com.aaa.af.service;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/24 14:21
 */
public interface YingYeTingService {
    /**
     * 获取个人信息
     * @return
     */
    List<Map> getPerson(Map map);
    /**
     * 获取贷款信息
     * @return
     */
    List<Map> getLoan(Map map);

    /**
     * 支付
     * @param map
     * @param model
     * @return
     */
    Void zhifu(Map map, Model model);
}
