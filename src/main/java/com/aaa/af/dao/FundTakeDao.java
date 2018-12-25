package com.aaa.af.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:FundTakeDao
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-18 19:31
 */
public interface FundTakeDao {

    /**
     * 查询公积金部分提取全部人员列表
     * @param map
     * @return
     */
    @Select("<script>select rownum rn,a.* from (\n" +
            "select  rownum rn,t.*,p.*,to_char(t.LASTNAYDATE,'yyyy-MM-dd') as ldate from TB_PACCOUNTUTIL t left join\n" +
            " TB_PERSON_INFO p on p.tb_pid=t.pid  where rownum &lt; #{end} " +
            "<if test=\"APPL_NAME!=null and APPL_NAME!=''\"> and TB_PNAME like '%'||#{APPL_NAME}||'%'</if>" +
            ") a where a.rn &gt; #{start}</script>")
    List<Map> selectFundPart(Map map);

    /**
     * 查询公积金部分提取总数量
     * @param map
     * @return
     */
    @Select("<script>select count(*) from TB_PACCOUNTUTIL t left join " +
            "TB_PERSON_INFO p on p.tb_pid=t.pid  <where>" +
            "<if test=\"APPL_NAME!=null and APPL_NAME!=''\"> and TB_PNAME like '%'||#{APPL_NAME}||'%'</if>" +
            "</where></script>")
    int selectFundCount(Map map);

    /**
     * 查询公积金部分提取弹框信息
     * @param pid
     * @return
     */
    @Select("select * from TB_PACCOUNTUTIL t left join TB_PERSON_INFO p on p.tb_pid=t.pid left join TB_UNIT u on t.uaid=u.id where pid=#{pid}")
    Map selectFormInfo(Integer pid);

    /**
     * 提取公积金提交信息
     * @param map
     * @return
     */
    @Insert("insert into TB_BFTAKE_CHECK(bftake_id,appl_account,appl_name,appl_bank_name,appl_bank_account,application_type," +
            "application_way,appl_idnum,comp_name,comp_account,extract_money,bailor_name,bilor_idnum,extract_reason," +
            "renting_address,renting_compact,renting_type,renting_money,appl_time,appl_state) values(seq_bftake.nextval," +
            "#{GRZH},#{TB_PNAME},#{TB_PNAME},#{GET_ACCOUNT},#{TAKE_METHOD},#{TAKE_TYPE},#{TB_IDNUMBER},#{UNAME},#{DWXZ},#{DALANCE}," +
            "#{ENTRUST_NAME},#{ENTRUST_CARDNUM},#{TAKE_REASON},#{RENT_ADDRESS},#{RENT_NUMBER},#{RENT_TYPE},#{RENT_OUT}," +
            "sysdate,1)")
    int takeSubmit(Map map);



    /**
     * 查询申请是否重复提交
     * @return
     */
    @Select("select count(*) from TB_BFTAKE_CHECK where appl_state=1 and appl_account=#{GRZH}")
    int applitation(String GRZH);

    /**
     * 公积金提取申请审核列表
     * @param map
     * @return
     */
    @Select("<script>select rownum rn,a.* from (" +
            "select  rownum rn,t.*,to_char(t.appl_time,'yyyy-MM-dd') as time from TB_BFTAKE_CHECK t " +
            "where rownum &lt; #{end} " +
            "<if test=\"COMP_NAME!=null and COMP_NAME!=''\"> and COMP_NAME like '%'||#{COMP_NAME}||'%'</if>" +
            "<if test=\"radio!=null and radio!=''\"> and APPLICATION_WAY=#{radio}</if>" +
            ") a where a.rn &gt; #{start}</script>")
    List<Map> selectFundCheck(Map map);

    /**
     * 查询公积金部分提取审核列表总数量
     * @param map
     * @return
     */
    @Select("<script>select count(*) from TB_BFTAKE_CHECK " +
            "<where>" +
            "<if test=\"APPL_NAME!=null and APPL_NAME!=''\"> and APPL_NAME like '%'||#{APPL_NAME}||'%'</if>" +
            "<if test=\"radio!=null and radio!=''\"> and APPLICATION_WAY=#{radio}</if>" +
            "</where></script>")
    int selectCheckCount(Map map);

    /**
     * 提取审核弹框查询
     * @param id
     * @return
     */
    @Select("select t.*,to_char(APPL_TIME,'yyyy-MM-dd') as time from TB_BFTAKE_CHECK t where BFTAKE_ID=#{id}")
    Map checkFundTake(Integer id);

    /**
     * 提取审核通过
     * @param map
     * @return
     */
    @Update("update TB_BFTAKE_CHECK set APPL_STATE=2 where BFTAKE_ID=#{BFTAKE_ID}")
    int takePass(Map map);

    /**
     * 审核通过提取公积金修改公积金余额
     * @return
     */
    @Update("update TB_PACCOUNTUTIL set DALANCE=(select DALANCE from TB_PACCOUNTUTIL where GRZH=#{APPL_ACCOUNT})-#{ALLOW_MONEY} where GRZH=#{APPL_ACCOUNT}")
    int takeSubmitMoney(Map map);

    /**
     * 提取审核驳回
     * @param map
     * @return
     */
    @Update("update TB_BFTAKE_CHECK set APPL_STATE=3 where BFTAKE_ID=#{BFTAKE_ID}")
    int takeReject(Map map);

    /**
     * 查询公积金约定提取全部人员列表
     * @param map
     * @return
     */
    @Select("<script>select rownum rn,TB_PNAME,pid,GRZH,TB_IDNUMBER,LOAN_MONEY,LOAN_PERIODS,DALANCE,PERACCSTATE,LASTNAYDATE from (\n" +
            "select  rownum rn,TB_PNAME,t.pid,t.GRZH,TB_IDNUMBER,LOAN_MONEY,LOAN_PERIODS,DALANCE,PERACCSTATE,to_char(LASTNAYDATE,'yyyy-MM-dd') as LASTNAYDATE from TB_LOAN t \n" +
            "left join TB_PERSON_INFO p on t.pid=p.tb_pid left join TB_PACCOUNTUTIL l on l.pid=t.pid  where rownum &lt; #{end} " +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\"> and TB_PNAME like '%'||#{TB_PNAME}||'%'</if>" +
            ") a where a.rn &gt; #{start}</script>")
    List<Map> selectFundAppoint(Map map);

    /**
     * 查询公积金约定提取总数量
     * @param map
     * @return
     */
    @Select("<script>select count(*) from TB_LOAN t " +
            " left join TB_PERSON_INFO p on t.pid=p.tb_pid left join TB_PACCOUNTUTIL l on l.pid=t.pid  <where>" +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\"> and TB_PNAME like '%'||#{TB_PNAME}||'%'</if>" +
            "</where></script>")
    int selectAppointCount(Map map);

    /**
     * 约定提取弹出框数据
     * @param GRZH
     * @return
     */
    @Select("select * from TB_LOAN t \n" +
            "left join TB_PERSON_INFO p on t.pid=p.tb_pid left join TB_PACCOUNTUTIL l on l.pid=t.pid where t.GRZH=#{GRZH}")
    Map appointAppl(String GRZH);

    /**
     * 约定提取申请提交
     * @param map
     * @return
     */
    @Insert("insert into TB_APPOINT_CHECK(aid,pname,piphone,pcnumber,grzh,dalance,ZHSTATE,loan_money,loan_periods,loan_repay," +
            "loan_rate,loan_id,ydrq,hkje,ydqs,dklx,shijian,shzt) values(seq_appoint_id.nextval,#{TB_PNAME},#{TB_PIPHONE},#{TB_IDNUMBER}," +
            "#{GRZH},#{DALANCE},#{PERACCSTATE},#{LOAN_MONEY},#{LOAN_PERIODS},#{LOAN_REPAY},#{LOAN_RATE},#{LOAN_ID},#{APPOINT_DATE}," +
            "#{MONTH_REPAY},#{APPOINT_PERIODS},#{LOAN_TYPE},sysdate,1)")
    int appointSubmit(Map map);

    /**
     * 判断约定提取是否已经申请
     * @param GRZH
     * @return
     */
    @Select("select count(*) from TB_APPOINT_CHECK where GRZH=#{GRZH} and shzt=1")
    int panduan(String GRZH);

    /**
     *查询约定审核列表
     * @param map
     * @return
     */

   /* AID: '',
    PNAME:'',
    PIPHONE: '',
    PCNUMBER: '',
    GRZH: '',
    HKJE: '',
    DKLX: '',
    YDQS: '',
    YDRQ: '',
    SHIJIAN: '',
    SHZT: '',*/
    @Select("<script>select rownum rn,AID,PNAME,PIPHONE,PCNUMBER,GRZH,HKJE,DKLX,YDQS,YDRQ,SHIJIAN,SHZT from " +
            "(select rownum rn,AID,PNAME,PIPHONE,PCNUMBER,GRZH,HKJE,DKLX,YDQS,YDRQ,to_char(SHIJIAN,'yyyy-MM-dd') as SHIJIAN,SHZT from TB_APPOINT_CHECK where " +
            " rownum &lt; #{end} and SHZT=1"+
            "<if test=\"SHZT!=null and SHZT!=''\"> and SHZT=#{SHZT}</if>" +
            ") a where a.rn &gt; #{start}</script>")
    List<Map> selectAppointCheck(Map map);

    /**
     *查询约定审核列表总数量
     * @param map
     * @return
     */
    @Select("<script>select count(*) from TB_APPOINT_CHECK " +
            "<where>" +
            "<if test=\"SHZT!=null and SHZT!=''\"> and SHZT=#{SHZT}</if>" +
            "</where></script>")
   int selectAppCheckCount(Map map);

    /**
     *约定审核通过事件
     * @param aid
     * @return
     */
    @Update("update TB_APPOINT_CHECK set SHZT=2 where aid=#{aid}")
    int appointPass(Integer aid);

    /**
     *约定审核驳回事件
     * @param aid
     * @return
     */
    @Update("update TB_APPOINT_CHECK set SHZT=3 where aid=#{aid}")
    int appointReject(Integer aid);
}
