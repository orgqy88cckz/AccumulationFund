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
}
