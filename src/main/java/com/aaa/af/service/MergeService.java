package com.aaa.af.service;
import java.util.List;
import java.util.Map;

/**
 * className:UserTransferService
 * discription:人员转移
 * author:wqy
 * createTime:2018-12-11 14:25
 */
public interface MergeService {
    /**
     * 带参分页查询-----待转移人员
     * @param map
     * @return
     */
    List<Map> getPageByParam(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 查询 封存 启封 销户 审核表信息
     * @param grzh
     * @return
     */
    Map verification(String grzh);

    /**
     * 校验贷款的人 不能封存和销户  查询贷款人员信息
     * @param grzh
     * @return
     */
    Map loansVerification(String grzh);

    /**
     * 添加到审核表中，提交申请
     * @param map
     * @return
     */
    int add(Map map);
    /**
     * 带参分页查询--明细查询
     * @param map
     * @return
     */
    List<Map> getPageByParam2(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount2(Map map);
}
