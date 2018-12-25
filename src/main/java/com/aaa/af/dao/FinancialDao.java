package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:FinancialDao
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-24 21:08
 */
public interface FinancialDao {

    /**
     * 归集情况分析  查询每月公积金提取的总金额
     * @return
     */
    @Select("select sum(extract_money) as money , to_char(appl_time,'mm') as yuefen FROM TB_BFTAKE_CHECK  GROUP BY to_char(appl_time,'mm')")
    List<Map> GJFX();

    /**
     * 统计每月汇缴金额
     * @return
     */
    @Select("select sum(UCMONEY) as money , to_char(UDATE,'mm') as yuefen FROM URECORD GROUP BY to_char(UDATE,'mm') ")
    List<Map> huijiao();

    /**
     * 贷款信息
     * @return
     */
    @Select("select sum(loan_money) as money, to_char(ctime,'mm') as yuefen FROM tb_repay  GROUP BY to_char(ctime,'mm')")
    List<Map> daiKuanXinXi();

    /**
     * 还款信息
     * @return
     */
    @Select("select nvl(sum(repayed_month_money),0) as money ,nvl(to_char(repayed_date,'mm'),0) as yuefen FROM tb_record  GROUP BY to_char(repayed_date,'mm') ")
    List<Map> huanKuanXinXi();

    /**
     * 查询提取人数
     * @return
     */
    @Select("select count(*) as tiqu,to_char(appl_time,'mm') as yuefen from tb_bftake_check where appl_state=2 group by to_char(appl_time,'mm')")
    List<Map> tiqu();

    /**
     * 查询汇缴人数
     * @return
     */
    @Select("select count(*) as huijiao,to_char(LASTNAYDATE,'mm')  as yuefen from tb_paccountutil group by to_char(LASTNAYDATE,'mm')")
    List<Map> huijiaoPer();
}
