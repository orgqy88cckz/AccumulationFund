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
     * 获取单位信息
     * @param map
     * @return
     */
    @Select("select u.id,u.ulegalcard,u.dwxz,u.gslx,u.ulegalperson,u.uoperator,uopiphone,p.uaremain,p.khrq from tb_unit u left join tb_unitaccount p on u.id=p.id where u.dwxz = #{dwxz}")
    List<Map>  getList(Map map);

    /**
     * 公司缴纳记录
     * @param map
     * @return
     */
    @Select("<script>select id,uname,uaccount,umoney,utype,to_char(udate,'yyyy-mm-dd') as udate,ucmoney from urecord where uaccount = #{uaccount} <where>" +
            "<if test=\"ID!=null and ID!=''\"> and id=#{ID}</if>" +
            "<if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            "<if test=\"UACCOUNT!=null and UACCOUNT!=''\">  and UACCOUNT =#{UACCOUNT}</if>" +
            "</where>" +
            "</script>")
    List<Map> getUcRecord(Map map);

    /**
     * 人员缴纳记录
     * @param map
     * @return
     */
    @Select("<script>select id,pname,paccount,pmoney,ptype,to_char(pdate,'yyyy-mm-dd') as pdate,pcmoney,pmonth from precord<where>" +
            "<if test=\"ID!=null and ID!=''\"> and id=#{ID}</if>" +
            "<if test=\"PNAME!=null and PNAME!=''\"> and PNAME like '%'||#{PNAME}||'%'</if>" +
            "<if test=\"PACCOUNT!=null and PACCOUNT!=''\">  and PACCOUNT =#{PACCOUNT}</if>" +
            "</where>" +
            "</script>")
    List<Map> getPersonJiaoNa(Map map);

    /**
     * 人员提取记录
     * @param map
     * @return
     */
    @Select("<script>select bftake_id,appl_name,appl_bank_name,appl_bank_account,application_type,application_way,appl_idnum,comp_name,bailor_name,bilor_idnum,extract_reason,renting_address,renting_compact,renting_money,appl_state,allow_money,appl_account,comp_account,extract_money,to_char(appl_time,'yyyy-mm-dd') as appl_time from tb_bftake_check where comp_account = #{comp_account}<where>" +
            "<if test=\"BFTAKE_ID!=null and BFTAKE_ID!=''\"> and id=#{BFTAKE_ID}</if>" +
            "<if test=\"APPL_NAME!=null and APPL_NAME!=''\"> and APPL_NAME like '%'||#{APPL_NAME}||'%'</if>" +
            "<if test=\"EXTRACT_MONEY!=null and EXTRACT_MONEY!=''\">  and EXTRACT_MONEY =#{EXTRACT_MONEY}</if>" +
            "</where>" +
            "</script>")
    List<Map> getPersonTiQu(Map map);
}
