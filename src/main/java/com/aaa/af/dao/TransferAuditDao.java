package com.aaa.af.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * className:TransferAudit
 * discription:人员转移审核
 * author:wqy
 * createTime:2018-12-16 20:01
 */
public interface TransferAuditDao {
    /**
     * select pname,idNumber,balance,state,transfer_out_unit,uname,auditor,
     person_account,transfer_reason,operator,submit_time,audit_state from
     (select rownum rn,a.pname,a.idNumber,a.balance,a.state,a.transfer_out_unit,b.uname,a.auditor,
     a.person_account,a.transfer_reason,a.operator,a.submit_time,a.audit_state
     from tb_transfer_audit a left join tb_unit b on a.transfer_into_unit=b.id where rownum<10)c
     where c.rn>0;
     */
    /**
     * 带参分页查询------全体人员
     * @param map
     * @return
     * 如果使用注解的方式，动态SQL必须在标签<script></script>
     * 如果使用<script></script>标签，mabatis大于小于，必须使用&gt;  &lt;
     */
    @Select("<script>select transfer_id,basenummber,pname,idnumber,balance,state,transfer_out_unit," +
            "transfer_into_unit,uname,auditor,person_account,transfer_reason,operator,to_char(submit_time,'yyyy-mm-dd') as submit_time,audit_state from" +
            "(select rownum rn,a.transfer_id,a.basenummber,a.pname,a.idnumber,a.balance,a.state,a.transfer_out_unit," +
            "a.transfer_into_unit,b.uname,a.auditor,a.person_account,a.transfer_reason,a.operator,a.submit_time,a.audit_state" +
            " from tb_transfer_audit a left join tb_unit b on a.transfer_into_unit=b.id" +
            " where rownum &lt; #{end}   " +
            "<if test=\"pname!=null and pname!=''\"> and pname like '%'||#{pname}||'%'</if>" +
            " )c where c.rn &gt; #{start} </script>")
    List<Map> getPageByParam(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_transfer_audit" +
            " <where>" +
            "<if test=\"pname!=null and pname!=''\"> and pname=#{pname}</if>" +
            " </where></script>")
    int getPageCount(Map map);

    /**
     * 删除待转移人员审核表中的数据----驳回，通过
     * @param transfer_id
     * @return
     */
    @Delete("delete from tb_transfer_audit where transfer_id=#{TRANSFER_ID}")
    int delete(int transfer_id);

    /**
     * 添加到人员审核记录表中----驳回，通过
     * @param map
     * @return
     */
    @Insert("insert into tb_transfer_audit_jl" +
            " values(seq_transfer_audit_jl.nextval,#{TRANSFER_OUT_UNIT},#{UNAME}," +
            "#{AUDITOR},#{PERSON_ACCOUNT},#{TRANSFER_REASON},#{OPERATOR},to_date(#{SUBMIT_TIME},'yyyy-mm-dd')," +
            "#{AUDITOR},#{IDNUMBER},#{BALANCE},#{STATE},#{BASENUMMBER},#{AUDIT_STATE})")
    int add(Map map);

    /**
     * 根据获取的个人账号查询到自己公司id 在修改为要转入的公司id
     * @param uaid	公司账户
     * @param grzh  个人账号
     * @return
     */
    @Update("update tb_paccountutil set uaid=#{uaid} where grzh = #{grzh}")
    //传入两个参数时，传入多个参数，map比较合适
    int updateId(@Param("uaid") int uaid,@Param("grzh") int grzh);

    /**
     * 公司缴存人数  查询到当前公司账户状态为正常的个数  把公司账户信息表 应缴纳人数修改了
     * 为了修改公司缴存人数
     * 转出公司的缴存人数
     * @param uname
     * @return
     */
    @Update("update tb_unitaccount a set a.udepositedpnum = " +
            "(select count(*) from tb_paccountutil c join tb_unit b on c.uaid = b.id " +
            "where peraccstate = '正常' and b.id = " +
            "(select id from tb_unit where uname = #{uname})) " +
            "where a.aid = (select id from tb_unit where uname = #{uname})")
    int unitsUpdatea(String uname);

    /**
     * 审核表中  点击通过审核  获取前台信息 进行修改 个人信息状态后    然后修改 公司缴存人数  查询到当前公司账户状态为正常的个数  把公司账户信息表 应缴纳人数修改了
     * 在修改公司 总缴存金额
     *
     * 获取转出公司 进行修改总缴存金额 方法
     * @param uname
     * @return
     */
    @Update("update tb_unitaccount set uaowemonery = " +
            "(select SUM(ydrawamt) from tb_paccountutil a left join tb_unit b" +
            " on a.uaid=b.id and a.peraccstate = '正常' and uaid =" +
            "(select id from tb_unit where uname = #{uname}))" +
            " where aid  = (select id from tb_unit where uname = #{uname})")
    int unitsUpdateMoneya(String uname);

}
