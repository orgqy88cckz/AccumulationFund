package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:SearchInfoService
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-12 21:08
 */
public interface SearchInfoService {
    /**
     * 根据个人账号查询个人信息
     * @return
     */
    Map getPersonInfo(String account);
    /**
     * 添加贷款信息
     * @param map
     * @return
     */
    int addInfo(List<Map> map);
    /**
     * 查询贷款初审列表
     * @return
     */
    List<Map> loanCheckSelect(Map map);
    /**
     * 查询贷款初审列表总数量
     * @return
     */
    int getPageCount(Map map);
}
