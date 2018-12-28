package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:FundTakeService
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-18 19:31
 */
public interface FundTakeService {

    /**
     * 查询公积金部分提取全部人员列表
     * @param map
     * @return
     */
    List<Map> selectFundPart(Map map);

    /**
     * 查询公积金部分提取总数量
     * @param map
     * @return
     */
    int selectFundCount(Map map);
    /**
     * 查询公积金部分提取弹框信息
     * @param pid
     * @return
     */
    Map selectFormInfo(Integer pid);

    /**
     * 提取公积金提交信息
     * @param map
     * @return
     */
    int takeSubmit(Map map);

    /**
     * 查询申请是否重复提交
     * @return
     */
    int applitation(String GRZH);

    /**
     * 公积金提取申请审核列表
     * @param map
     * @return
     */
    List<Map> selectFundCheck(Map map);

    /**
     * 查询公积金部分提取审核列表总数量
     * @param map
     * @return
     */
    int selectCheckCount(Map map);
    /**
     * 提取审核弹框查询
     * @param id
     * @return
     */
    Map checkFundTake(Integer id);

    /**
     * 提取审核通过
     * @param map
     * @return
     */
    int takePass(Map map);

    /**
     * 提取审核驳回
     * @param map
     * @return
     */
    int takeReject(Map map);

    /**
     * 查询公积金约定提取全部人员列表
     * @param map
     * @return
     */
    List<Map> selectFundAppoint(Map map);
    /**
     * 查询公积金约定提取总数量
     * @param map
     * @return
     */
    int selectAppointCount(Map map);

    /**
     * 约定提取弹出框数据
     * @param LOAN_ID
     * @return
     */
    Map appointAppl(Integer LOAN_ID);
    /**
     * 约定提取申请提交
     * @param map
     * @return
     */
    int appointSubmit(Map map);
    /**
     * 判断约定提取是否已经申请
     * @param LOAN_ID
     * @return
     */
    int panduan(Integer LOAN_ID);

    /**
     *查询约定审核列表
     * @param map
     * @return
     */
    List<Map> selectAppointCheck(Map map);

    /**
     *查询约定审核列表总数量
     * @param map
     * @return
     */
    int selectAppCheckCount(Map map);

    /**
     *约定审核通过事件
     * @param aid
     * @return
     */
    int appointPass(Integer aid);

    /**
     *约定审核驳回事件
     * @param aid
     * @return
     */
    int appointReject(Integer aid);
}
