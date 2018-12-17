package com.aaa.af.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:SearchInfoDao
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-12 20:35
 */
public interface SearchInfoDao {

    /**
     * 根据个人账号查询个人信息
     * @return
     */
    @Select("select TB_PID,GRZH,TB_PNAME,TB_PSEX,TB_PIPHONE,TB_IDCARD,TB_IDNUMBER,TB_PMARRIAGE,TB_PROFESSION,TB_PEDUCATION,TB_PEMAIL,TB_PADDRESS,\n" +
            "UNIT_ID,to_char(LASTNAYDATE,'yyyy-MM-dd') as LASTNAYDATE,PERACCSTATE,DALANCE,UNAME,UOPIPHONE from\n" +
            " TB_PERSON_INFO p left join TB_PACCOUNTUTIL a on a.pid=p.tb_pid left join\n" +
            " TB_UNIT u on u.id=a.uaid where a.grzh=#{GRZH}")
    Map getPersonInfo(String account);


    /**
     * 添加贷款信息
     * @param map
     * @return
     */
    @Insert("insert into tb_loan(loan_id,pid,GRZH,togetherzh,SALARY,bank_money,loan_money,loan_periods,loan_rate,loan_bank,loan_repay,"+
            "loan_repayer,loan_repaydate,REPAY_BANK,REPAY_ACCOUNTNAME,REPAY_ACCOUNT,status,CTIME,house_type,house_location," +
            "house_area,id_number,buy_name,bank_account,house_total,house_firstpay," +
            "house_price,pawn_type,pawn_name,pawn_idnumber,pawn_address,pawn_status,pawn_money) " +
            "values(seq_loan.nextval,#{TB_PID},#{GRZH},#{GRZH1},#{income},#{deposit},#{loanAmount}," +
            "#{loanPeriods},#{loanRate},#{trustBank},#{paymentMethod},#{payee},#{paymentDay},#{openBank},#{paymentName},#{paymentAccount},1," +
            "sysdate,#{houseType},#{houseAddress},#{houseArea},#{HIdNum},#{HName},#{HBank},#{houseTotal},#{houseFirst}," +
            "#{housePrice},#{DYType},#{DYName},#{DYIdNum},#{DYAddress},#{DYStatus},#{DYMoney})")
    int addInfo(Map map);

    /**
     * 查询贷款初审列表
     * @return
     */
    @Select("<script>select rownum rn,TB_PNAME,LOAN_MONEY,LOAN_PERIODS,LOAN_RATE,LOAN_BANK,LOAN_REPAY,CTIME,STATUS from(\n" +
            " select rownum rn,TB_PNAME,LOAN_MONEY,LOAN_PERIODS,LOAN_RATE,LOAN_BANK,LOAN_REPAY,to_char(CTIME,'yyyy-MM-dd') as CTIME,STATUS from TB_LOAN l left join\n" +
            " TB_PERSON_INFO p on l.pid=p.tb_pid where rownum &lt; #{end} \n" +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\"> and TB_PNAME like '%'||#{TB_PNAME}||'%'</if>" +
            "<if test=\"STATUS!=null and STATUS!=''\"> and STATUS=#{STATUS}</if>" +
            " ) a where a.rn &gt; #{start} </script>")
    List<Map> loanCheckSelect(Map map);


    /**
     * 查询贷款初审列表总数量
     * @return
     */
    @Select("<script>select count(*) from TB_LOAN l left join\n" +
            " TB_PERSON_INFO p on l.pid=p.tb_pid <where>\n" +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\"> and TB_PNAME like '%'||#{TB_PNAME}||'%'</if>" +
            "<if test=\"STATUS!=null and STATUS!=''\"> and STATUS=#{STATUS}</if></where></script>")
    int getPageCount(Map map);

}
