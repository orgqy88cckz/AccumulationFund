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
     * 查询个人账户
     * @return
     */
    @Select("select * from TB_PACCOUNTUTIL")
    List<Map> selectGRZH();
}
