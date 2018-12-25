package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/24 11:25
 */
public interface YingYeTingDao {
    /**
     * 获取个人信息
     * @return
     */
    @Select("select i.tb_pname,i.tb_psex,a.grzh,i.tb_piphone,i.tb_profession,a.dalance,i.tb_paddress,i.tb_peducation from tb_person_info i left join tb_paccountutil a on i.tb_pid=a.pid where a.grzh=#{grzh}")
    List<Map> getPerson(Map map);
    /**
     * 获取贷款信息
     * @return
     */
    @Select("select grzh,pname,loan_money,loan_periods,to_char(ctime,'yyyy-MM-dd') as ctime,over_money,over_periods,repay_month_allmoney from tb_repay where grzh=#{grzh}")
    List<Map> getLoan(Map map);
}