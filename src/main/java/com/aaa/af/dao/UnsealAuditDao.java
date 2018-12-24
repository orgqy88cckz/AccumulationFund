package com.aaa.af.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * className:TransferAudit
 * discription:启封 封存审核
 * author:wqy
 * createTime:2018-12-16 20:01
 */
public interface UnsealAuditDao {

    /**
     * 带参分页查询------
     * @param map
     * @return
     * 如果使用注解的方式，动态SQL必须在标签<script></script>
     * 如果使用<script></script>标签，mabatis大于小于，必须使用&gt;  &lt;
     */
    @Select("<script>select audit_state,unseal_name,unseal_unit,unseal_sex,unit_post,unseal_phone,unseal_number," +
            "unseal_account,reason,operator,to_char(create_time,'yyyy-mm-dd') as create_time,state," +
            "audit_name from" +
            " (select rownum rn,audit_state,unseal_name,unseal_unit,unseal_sex,unit_post,unseal_phone,unseal_number," +
            "unseal_account,reason,operator,create_time,state,audit_name from tb_unseal_audit" +
            " where state in('封存申请','启封申请') and audit_name='待审核' and rownum &lt; #{end}   " +
//            "<if test=\"unseal_name!=null and unseal_name!=''\"> and unseal_name like '%'||#{unseal_name}||'%'</if>" +
            " )c where c.rn &gt; #{start} </script>")
    List<Map> getPageByParam(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_unseal_audit where state in('封存申请','启封申请') and audit_name='待审核'" +
//            " <if test=\"unseal_name!=null and unseal_name!=''\"> and unseal_name like '%'||#{unseal_name}||'%'</if>" +
            "</script>")
    int getPageCount(Map map);

    /**
     * 修改 个人账户状态 正常 销户 封存
     *      添加相关理由原因
     * @param grzh
     * @return
     */
    //    int updateId(@Param("uaid") int uaid,@Param("grzh") int grzh);
    @Update("update tb_paccountutil set peraccstate = #{AUDIT_STATE},ypayamt = #{REASON} where grzh= #{UNSEAL_ACCOUNT}")
    int archive(@Param("AUDIT_STATE")String peraccstate,@Param("REASON") String ypayamt,@Param("UNSEAL_ACCOUNT") String grzh);

    /**
     * 更新审核表中 审核状态及通过或驳回理由
     * @param grzh
     * @return
     */
    @Update("update tb_unseal_audit set audit_name = #{AUDIT_NAME},bohui=#{BOHUI} where unseal_account= #{UNSEAL_ACCOUNT}")
    int unsealAuditUpdate(@Param("AUDIT_NAME") String audit_name,@Param("BOHUI") String bohui,@Param("UNSEAL_ACCOUNT") String grzh);

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
            "(select id from tb_unit where uname = #{UNSEAL_NAME})) " +
            "where a.aid = (select id from tb_unit where uname = #{UNSEAL_NAME})")
    int unitsUpdate(String uname);

    /**
     * 封存 销户后
     * 修改公司缴存金额
     * @param grzh
     * @return
     */
    @Update("update tb_unitaccount set uaowemonery = " +
            "uaowemonery-(select ydrawamt from tb_paccountutil where grzh =#{UNSEAL_ACCOUNT})" +
            " where aid = (select uaid from tb_paccountutil where grzh =#{UNSEAL_ACCOUNT})")
    int unitsUpdateMoney(String grzh);

    /**
     * 启封后  修改总缴存金额
     * @param grzh
     * @return
     */
    @Update("update tb_unitaccount set uaowemonery = " +
            "uaowemonery+(select ydrawamt from tb_paccountutil where grzh =#{UNSEAL_ACCOUNT})" +
            " where aid = (select uaid from tb_paccountutil where grzh =#{UNSEAL_ACCOUNT})")
    int unitsMoney(String grzh);
    /**
     * 带参分页查询------
     * @param map
     * @return
     * 如果使用注解的方式，动态SQL必须在标签<script></script>
     * 如果使用<script></script>标签，mabatis大于小于，必须使用&gt;  &lt;
     */
    @Select("<script>select audit_state,unseal_name,unseal_unit,unseal_sex,unit_post,unseal_phone,unseal_number," +
            "unseal_account,reason,operator,to_char(create_time,'yyyy-mm-dd') as create_time,state," +
            "audit_name from" +
            " (select rownum rn,audit_state,unseal_name,unseal_unit,unseal_sex,unit_post,unseal_phone,unseal_number," +
            "unseal_account,reason,operator,create_time,state,audit_name from tb_unseal_audit" +
            " where state ='销户申请' and audit_name='待审核' and rownum &lt; #{end}   " +
//            "<if test=\"unseal_name!=null and unseal_name!=''\"> and unseal_name like '%'||#{unseal_name}||'%'</if>" +
            " )c where c.rn &gt; #{start} </script>")
    List<Map> getPageByParam2(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_unseal_audit where state ='销户申请' and audit_name='待审核'" +
//            " <if test=\"unseal_name!=null and unseal_name!=''\"> and unseal_name like '%'||#{unseal_name}||'%'</if>" +
            "</script>")
    int getPageCount2(Map map);

}
