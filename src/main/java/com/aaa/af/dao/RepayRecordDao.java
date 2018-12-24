package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/18 22:21
 */
public interface RepayRecordDao {

    /**
     * 获取还款记录列表
     * @return
     */
    @Select("<script> select id,repayid,pid,GRZH,pName,loan_money,loan_periods,repay_money,loan_rate,repay_interests,to_char(ctime,'yyyy-mm-dd') as ctime,round(repayed_money,0) as repayed_money,over_periods,to_char(repayed_date,'yyyy-mm-dd') as repayed_date,month_return,state,repay_month_allmoney,repay_bank,over_money,over_interests,repayed_interests,loan_repay,repayed_month_money,repayed_month_interest,repay_account " +
            "from tb_repay <where>" +
            "state = '还款完毕' " +
            "<if test=\"repayId!=null and repayId!=''\"> and id=#{repayid}</if>" +
            "<if test=\"GRZH!=null and GRZH!=''\"> and GRZH like '%'||#{GRZH}||'%'</if>" +
            "<if test=\"PNAME!=null and PNAME!=''\"> and PNAME like '%'||#{PNAME}||'%'</if>" +
            "<if test=\"STATE!=null and STATE!=''\">  and STATE =#{STATE}</if>" +
            " </where></script>")
    List<Map> getList(Map map);
}
