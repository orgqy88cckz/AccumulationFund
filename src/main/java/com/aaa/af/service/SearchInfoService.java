package com.aaa.af.service;

import sun.applet.resources.MsgAppletViewer;

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
    /**
     * 贷款初审弹出框查询
     * @param loan_id
     * @return
     */
    Map selectForm(String loan_id);
    /**
     *贷款初审通过
     * @param map
     * @return
     */
    int checkPass(Map map);
    /**
     *贷款初审驳回更新贷款表中的数据
     * @return
     */
    int checkReject(Map map);

    /**
     * 查询贷款终审列表
     * @param map
     * @return
     */
    List<Map> loanCheckSelectFinally(Map map);

    /**
     * 查询贷款初审列表总数量
     * @return
     */
    int getPageCountFinally(Map map);

    /**
     *贷款终审驳回更新贷款审核表中的数据
     * @return
     */
    int checkRejectFinally(Map map);

    /**
     *贷款终审通过添加数据到还款表中并且更新审核表中的数据
     * @return
     */
    int checkPassFinally(Map map);

    /**
     * 贷款页面验证查询
     * @return
     */
    int unique(String value);
    /**
     * 验证个人账号查询
     * @param GRZH
     * @return
     */
    Map yanzheng(String GRZH);


}
