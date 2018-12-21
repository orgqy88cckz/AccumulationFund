package com.aaa.af.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.nio.channels.FileChannel;
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
    @Select("<script>select rownum rn,pid,LOAN_ID,GRZH,TB_PNAME,LOAN_MONEY,LOAN_PERIODS,LOAN_RATE,LOAN_BANK,LOAN_REPAY,CTIME,STATUS from(\n" +
            " select rownum rn,pid,LOAN_ID,GRZH,TB_PNAME,LOAN_MONEY,LOAN_PERIODS,LOAN_RATE,LOAN_BANK,LOAN_REPAY,to_char(CTIME,'yyyy-MM-dd') as CTIME,STATUS from TB_LOAN l left join\n" +
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

    /**
     * 贷款初审弹出框查询
     * @param loan_id
     * @return
     */
    @Select("select LOAN_ID,PID,GRZH,BANK_MONEY,LOAN_MONEY,LOAN_PERIODS,LOAN_RATE,LOAN_BANK,LOAN_REPAY,LOAN_REPAYER,\n" +
            "LOAN_REPAYDATE,REPAY_BANK,REPAY_ACCOUNT,STATUS,to_char(CTIME,'yyyy-MM-dd') as CTIME,HOUSE_TYPE,\n" +
            "HOUSE_AREA,ID_NUMBER,BUY_NAME,BANK_ACCOUNT,HOUSE_TOTAL,TB_PIPHONE,TB_IDNUMBER,TB_PEDUCATION,TB_PEMAIL,TB_PADDRESS,UNIT_ID,\n" +
            "HOUSE_FIRSTPAY,HOUSE_PRICE,PAWN_TYPE,PAWN_NAME,PAWN_IDNUMBER,PAWN_ADDRESS,PAWN_STATUS,PAWN_MONEY,HOUSE_LOCATION,TB_PNAME from TB_LOAN l left join Tb_Person_Info p on l.pid=p.tb_pid where loan_id=#{loan_id}")
    Map selectForm(String loan_id);

    /**
     *贷款初审通过添加到TB_LOAN_CHECK
     * @param map
     * @return
     */
    @Insert("insert into TB_LOAN_CHECK(LOAN_CHECK_ID,LOAN_ID,PID,GRZH,LOAN_MONEY,LOAN_PERIODS," +
            "LOAN_RATE,LOAN_BANK,LOAN_REPAY,REPAY_BANK,REPAY_ACCOUNT,PNAME,STATUS,CTIME) values(seq_check_loan.nextval,#{LOAN_ID},#{PID},#{GRZH},#{LOAN_MONEY},#{LOAN_PERIODS}," +
            "#{LOAN_RATE},#{LOAN_BANK},#{LOAN_REPAY},#{REPAY_BANK},#{REPAY_ACCOUNT},#{TB_PNAME},'2',to_date(#{CTIME},'yyyy-MM-dd'))")
    int checkPass(Map map);

    /**
     * 初审通过更新贷款表中的数据
     * @return
     */
    @Update("update TB_LOAN set status='2' where loan_id=#{loan_id}")
    int checkPassUpdate(Integer loan_id);

    /**
     *贷款初审通过添加到TB_LOAN_CHECK
     * @param map
     * @return
     */
    @Insert("insert into TB_LOAN_CHECK(LOAN_CHECK_ID,LOAN_ID,PID,GRZH,LOAN_MONEY,LOAN_PERIODS," +
            "LOAN_RATE,LOAN_BANK,LOAN_REPAY,REPAY_BANK,REPAY_ACCOUNT,PNAME,STATUS,CTIME,REJECTREASON) values(seq_check_loan.nextval,#{LOAN_ID},#{PID},#{GRZH},#{LOAN_MONEY},#{LOAN_PERIODS}," +
            "#{LOAN_RATE},#{LOAN_BANK},#{LOAN_REPAY},#{REPAY_BANK},#{REPAY_ACCOUNT},#{TB_PNAME},'3',to_date(#{CTIME},'yyyy-MM-dd'),#{LOAN_REJECT})")
    int checkReject(Map map);

    /**
     *贷款初审驳回更新贷款表中的数据
     * @return
     */
    @Update("update TB_LOAN set status='3' where loan_id=#{loan_id}")
    int checkRejectUpdate(Integer loan_id);

    /**
     * 查询贷款终审列表
     * @return
     */
    @Select("<script>select rownum rn,pid,LOAN_ID,GRZH,PNAME,LOAN_MONEY,LOAN_PERIODS,LOAN_RATE,LOAN_BANK,LOAN_REPAY,CTIME,STATUS from(\n" +
            " select rownum rn,pid,LOAN_ID,GRZH,PNAME,LOAN_MONEY,LOAN_PERIODS,LOAN_RATE,LOAN_BANK,LOAN_REPAY,to_char(CTIME,'yyyy-MM-dd') as CTIME,STATUS from TB_LOAN_CHECK\n" +
            " where STATUS='2' or status='4' or status='5' and rownum &lt; #{end} \n" +
            "<if test=\"PNAME!=null and PNAME!=''\"> and PNAME like '%'||#{PNAME}||'%'</if>" +
            "<if test=\"STATUS!=null and STATUS!=''\"> and STATUS=#{STATUS}</if>" +
            " ) a where  STATUS='2' or status='4' or status='5' and a.rn &gt; #{start} </script>")
    List<Map> loanCheckSelectFinally(Map map);


    /**
     * 查询贷款终审列表总数量
     * @return
     */
    @Select("<script>select count(*) from TB_LOAN_CHECK where STATUS='2' or status='4' or status='5' \n" +
            " <where>\n" +
            "<if test=\"PNAME!=null and PNAME!=''\"> and PNAME like '%'||#{PNAME}||'%'</if>" +
            "<if test=\"STATUS!=null and STATUS!=''\"> and STATUS=#{STATUS}</if></where></script>")
    int getPageCountFinally(Map map);

    /**
     *贷款终审通过添加数据到还款表中
     * @return
     */
    @Insert("insert into TB_REPAY(ID,REPAYID,PID,PNAME,GRZH,LOAN_MONEY,LOAN_PERIODS,CTIME,LOAN_RATE,REPAY_BANK,REPAY_ACCOUNT," +
            "LOAN_REPAY,REPAY_MONEY,REPAY_INTERESTS,OVER_MONEY,OVER_INTERESTS,OVER_PERIODS,REPAYED_MONTH_MONEY,REPAYED_MONTH_INTEREST,REPAY_MONTH_ALLMONEY," +
            "STATE,REPAYED_DATE) values(seq_repayid.nextval,extract (year from sysdate)||extract(month from sysdate)||extract (day from sysdate)||to_char(seq_repayid.nextval,'fm00')," +
            "#{PID},#{TB_PNAME},#{GRZH},#{LOAN_MONEY},#{LOAN_PERIODS},sysdate,#{LOAN_RATE},#{REPAY_BANK},#{REPAY_ACCOUNT},#{LOAN_REPAY},#{LOAN_MONEY},#{LOAN_MONEY}*#{LOAN_RATE}/100,#{LOAN_MONEY}," +
            "#{LOAN_MONEY}*#{LOAN_RATE}/100,#{LOAN_PERIODS},#{LOAN_MONEY}/#{LOAN_PERIODS},(#{LOAN_MONEY}*#{LOAN_RATE}/100)/#{LOAN_PERIODS},#{LOAN_MONEY}/#{LOAN_PERIODS}+(#{LOAN_MONEY}*#{LOAN_RATE}/100)/#{LOAN_PERIODS}," +
            "'待还款',sysdate)")
    int checkPassFinally(Map map);

    /**
     * 贷款终审通过更新贷款审核表中的数据
     * @param loan_id
     * @return
     */
    @Update("update TB_LOAN_CHECK set status='4' where loan_id=#{loan_id}")
    int checkFinallyUpdate(Integer loan_id);

    /**
     *贷款终审驳回更新贷款审核表中的数据
     * @return
     */
    @Update("update TB_LOAN_CHECK set status='5' where loan_id=#{loan_id}")
    int checkRejectFinally(Integer loan_id);

}
