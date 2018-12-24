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
public interface AheadRepayDao {

    /**
     * 获取还款列表
     * @return
     */
    @Select("<script> select id,repayid,pid,GRZH,pName,loan_money,loan_periods,repay_money,loan_rate,repay_interests,to_char(ctime,'yyyy-mm-dd') as ctime,round(repayed_money,0) as repayed_money,over_periods,to_char(repayed_date,'yyyy-mm-dd') as repayed_date,month_return,state,repay_month_allmoney,repayed_periods,repay_bank,over_money,over_interests,repayed_interests,loan_repay,repayed_month_money,repayed_month_interest,repay_account " +
            "from tb_repay <where>" +
            "<if test=\"repayId!=null and repayId!=''\"> and id=#{repayid}</if>" +
            "<if test=\"GRZH!=null and GRZH!=''\"> and GRZH like '%'||#{GRZH}||'%'</if>" +
            "<if test=\"MONTH_RETURN!=null and MONTH_RETURN!=''\"> and MONTH_RETURN like '%'||#{MONTH_RETURN}||'%'</if>" +
            "<if test=\"STATE!=null and STATE!=''\">  and STATE =#{STATE}</if>" +
            " </where></script>")
    List<Map> getList(Map map);
    /**
     * 更新还款后数据
     * @param map
     * @return
     */
    @Update("<script>update tb_repay set over_periods='0',over_money = 0,over_interests = 0 ,(repayed_money) = loan_money,(repayed_interests) = (repayed_interests + over_interests) where id = #{ID}</script>")
    int update(Map map);

    /**
     * 分期还款后添加还款信息到个人还款记录
     * @param map
     * @return
     */
    @Insert("<script>insert into tb_aheadrecord (record_id,repay_id,grzh,repayed_date,pname,repayed_money,repayed_interests) values(seq_ahead_id.nextval,#{REPAY_ID},#{GRZH},to_date(#{REPAYED_DATE},'yyyy-mm-dd'),#{PNAME},#{REPAYED_MONEY},#{REPAYED_INTERESTS})</script>")
    int addInfo(Map map);

    /**
     * 查询记录
     */
    @Select("select record_id,repay_id,pname,grzh,repayed_money,repayed_interests,to_char(sysdate,'yyyy-mm-dd')as repayed_date from tb_aheadrecord where grzh=#{grzh}")
    List<Map> getRecord(Map map);

    /**
     * 更新还款状态
     * @param map
     * @return
     */
    @Update("update tb_repay set state ='还款完毕' where id = #{ID} ")
    int updateState(Map map);
}
