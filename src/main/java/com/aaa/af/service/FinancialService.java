package com.aaa.af.service;

import java.util.List;
import java.util.Map;

/**
 * className:FinancialService
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-24 21:10
 */
public interface FinancialService {

    /**
     *归集情况分析  查询每月公积金提取的总金额
     * @return
     */
    List<Map> GJFX();
    /**
     * 统计每月汇缴金额
     * @return
     */
    List<Map> huijiao();

    /**
     * 贷款信息
     * @return
     */
    List<Map> daiKuanXinXi();

    /**
     * 还款信息
     * @return
     */
    List<Map> huanKuanXinXi();

    /**
     * 查询提取人数
     * @return
     */
    List<Map> tiqu();

    /**
     * 查询汇缴人数
     * @return
     */
    List<Map> huijiaoPer();
}
