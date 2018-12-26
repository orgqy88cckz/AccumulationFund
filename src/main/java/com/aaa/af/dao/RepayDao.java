package com.aaa.af.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/11 15:33
 */
public interface RepayDao {

    /**
     * 获取还款列表
     * @return
     */
    @Select("<script> select id,repayid,pid,GRZH,pName,loan_money,loan_periods,repay_money,loan_rate,repay_interests,to_char(ctime,'yyyy-mm-dd') as ctime,round(repayed_money,0) as repayed_money,over_periods,to_char(repayed_date,'yyyy-mm-dd') as repayed_date,month_return,repayed_periods,state,repay_month_allmoney,repay_bank,over_money,over_interests,repayed_interests,loan_repay,repayed_month_money,repayed_month_interest,repay_account " +
            "from tb_repay <where>" +
            "<if test=\"repayId!=null and repayId!=''\"> and id=#{repayid}</if>" +
            "<if test=\"GRZH!=null and GRZH!=''\"> and GRZH like '%'||#{GRZH}||'%'</if>" +
            "<if test=\"MONTH_RETURN!=null and MONTH_RETURN!=''\"> and MONTH_RETURN like '%'||#{MONTH_RETURN}||'%'</if>" +
            "<if test=\"STATE!=null and STATE!=''\">  and STATE =#{STATE}</if>" +
            " </where></script>")
    List<Map> getList(Map map);

    /**
     * 根据ID查询个人还款记录
     * @param id
     * @return
     */
    @Select("<script> select repayid,pid,GRZH,pName,loan_money,loan_periods,repay_money,loan_rate,repay_interests,to_char(ctime,'yyyy-mm-dd') as ctime,repayed_money,over_periods,to_char(repayed_date,'yyyy-mm-dd') as repayed_date,month_return,state,repay_month_allmoney,repay_bank,over_money,over_interests,repayed_interests,loan_repay,repay_account，repayed_month_money,repayed_month_interest from tb_repay where id = #{ID} </script>")
    List<Map> getListById(int id);

    /**
     * 等额本息
     * @param map
     * @return
     */
    @Update("<script>update tb_repay set repayed_date = sysdate,repayed_periods=(repayed_periods+1),over_periods=(over_periods - 1)," +
            "repayed_month_money=month_return-(loan_money - (repayed_money + (month_return-(loan_money - repayed_money)*(loan_rate / loan_periods /100))))*(loan_rate / loan_periods /100),repayed_month_interest=(loan_money - (repayed_money + (month_return-(loan_money - repayed_money)*(loan_rate / loan_periods /100)))) * (loan_rate / loan_periods /100),"+
            "over_money = (loan_money - (repayed_money + month_return-(loan_money - repayed_money)*(loan_rate / loan_periods /100))),over_interests =(repay_interests - (repayed_interests + (loan_money - repayed_money) *(loan_rate / loan_periods / 100)))," +
            "repayed_money = (repayed_money + (month_return-(loan_money - repayed_money)*(loan_rate / loan_periods /100))),repayed_interests = (repayed_interests + (loan_money - repayed_money) * (loan_rate / loan_periods /100)) where loan_repay = '等额本息' and id = #{ID}</script>")
    int update (Map map);

    /**
     * 等额本金
     * @param map
     * @return
     */
    @Update("update tb_repay set repayed_date = sysdate,repayed_periods=(repayed_periods+1),over_periods=(over_periods - 1)," +
            "repayed_month_interest = (loan_money - (repayed_money+repayed_month_money)) *(loan_rate / loan_periods / 100),"+
            "repayed_money = (repayed_money+repayed_month_money),repayed_interests = (repayed_interests + (loan_money - (repayed_money+repayed_month_money)) *(loan_rate / loan_periods / 100)),"+
            "over_money = (loan_money - ((repayed_money+repayed_month_money))),over_interests = (repay_interests - (repayed_interests + (loan_money - (repayed_money+repayed_month_money)) *(loan_rate / loan_periods / 100)))"+
            " where loan_repay = '等额本金' and id = #{ID}")
    int updateMoney(Map map);

    /**
     * 分期还款后添加还款信息到个人还款记录
     * @param map
     * @return
     */
    @Insert("<script>insert into tb_record (record_id,repay_id,grzh,repayed_month_money,repayed_month_interest,repayed_date,pname) values(seq_record_id.nextval,#{REPAY_ID},#{GRZH},#{REPAYED_MONTH_MONEY},#{REPAYED_MONTH_INTEREST},to_date(#{REPAYED_DATE},'yyyy-mm-dd')，#{PNAME})</script>")
    int addInfo(Map map);

    /**
     * 查询记录
     */
    @Select("select record_id,repay_id,pname,grzh,repayed_month_money,repayed_month_interest,to_char(sysdate,'yyyy-mm-dd')as repayed_date from tb_record where grzh=#{grzh}")
    List<Map> getRecord(Map map);

    /**
     * 更新还款状态
     * @param map
     * @return
     */
    @Update("update tb_repay set state ='还款完毕' where id = #{ID} ")
    int updateState(Map map);
    /**
     * 更新还款状态
     * @param map
     * @return
     */
    @Update("update tb_repay set state ='还款中' where id = #{ID} ")
    int updState(Map map);
}
