package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/22 15:25
 */
public interface LoanDao {
    /**
     * 获取贷款列表
     * @param map
     * @return
     */
    @Select("<script>select l.loan_id,l.pid,l.grzh,l.loan_money,l.loan_rate,l.loan_periods,l.repay_bank,l.repay_account,(l.loan_money * l.loan_rate * 0.01) as REPAY_INTERESTS," +
            "round((l.loan_money + l.loan_money * l.loan_rate * 0.01) / l.loan_periods,0) as REPAYED_MONEY," +
            "p.tb_pname,r.state from tb_loan l left join tb_person_info p on l.pid=p.tb_pid left join tb_repay r on l.pid = r. pid <where>" +
            "<if test=\"loan_Id!=null and loan_Id!=''\"> and id=#{loan_id}</if>" +
            "<if test=\"GRZH!=null and GRZH!=''\"> and GRZH like '%'||#{GRZH}||'%'</if>" +
            "<if test=\"LOAN_MONEY!=null and LOAN_MONEY!=''\"> and LOAN_MONEY like '%'||#{LOAN_MONEY}||'%'</if>" +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\">  and TB_PNAME =#{TB_PNAME}</if>" +
            "</where> </script>")
    List<Map>  getList(Map map);
}
