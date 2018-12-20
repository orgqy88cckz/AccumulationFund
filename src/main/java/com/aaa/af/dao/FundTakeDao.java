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
            "select  rownum rn,t.*,p.* from TB_PACCOUNTUTIL t left join\n" +
            " TB_PERSON_INFO p on p.tb_pid=t.pid  where rownum &lt; #{end} " +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\"> and TB_PNAME like '%'||#{TB_PNAME}||'%'</if>" +
            ") a where a.rn &gt; #{start}</script>")
    List<Map> selectFundPart(Map map);

    /**
     * 查询公积金部分提取总数量
     * @param map
     * @return
     */
    @Select("<script>select count(*) from TB_PACCOUNTUTIL t left join " +
            "TB_PERSON_INFO p on p.tb_pid=t.pid  <where>" +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\"> and TB_PNAME like '%'||#{TB_PNAME}||'%'</if>" +
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
     * 提取公积金修改公积金余额
     * @return
     */
    @Update("update TB_PACCOUNTUTIL set DALANCE=(select DALANCE from TB_PACCOUNTUTIL where pid=#{PID})-#{DALANCE} where pid=#{PID}")
    int takeSubmitMoney(Map map);

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
            "</where></script>")
    int selectCheckCount(Map map);
}
