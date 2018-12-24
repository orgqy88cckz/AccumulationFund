package com.aaa.af.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * className:TransferAudit
 * discription:封存 销户 启封
 * author:wqy
 * createTime:2018-12-16 20:01
 */
public interface MergeDao {
    /**
     * 带参分页查询to_char(submit_time,'yyyy-mm-dd') as
     * @param map
     * @return
     * 如果使用注解的方式，动态SQL必须在标签<script></script>
     * 如果使用<script></script>标签，mabatis大于小于，必须使用&gt;  &lt;
     */
    @Select("<script>select dwzh,tb_psex,tb_idnumber,tb_piphone,tb_profession," +
            "grzh,ubitnrop,indinrop,basenummber,dalance,peraccstate,uname,tb_pname," +
            "to_char(lastnaydate,'yyyy-mm-dd') as lastnaydate,to_char(opendate,'yyyy-mm-dd') as opendate from" +
            " (select rownum rn,e.dwzh,b.tb_psex,b.tb_idnumber,b.tb_piphone,b.tb_profession," +
            "a.grzh,a.ubitnrop,a.indinrop," +
            "a.basenummber,a.dalance,a.peraccstate," +
            "c.uname,b.tb_pname,a.lastnaydate,a.opendate" +
            " from tb_paccountutil a left join tb_person_info b on a.pid= b.tb_pid" +
            " left join tb_unit c on a.uaid=c.id" +
            " left join tb_unitaccount e on c.id=e.aid" +
            " where rownum &lt; #{end}   " +
            "<if test=\"tb_pname!=null and tb_pname!=''\"> and tb_pname like '%'||#{tb_pname}||'%'</if>" +
            " )d where d.rn &gt; #{start} </script>")
    List<Map> getPageByParam(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_paccountutil a left join tb_person_info b on a.pid=b.tb_pid" +
            " left join tb_unit c on a.uaid=c.id" +
            " <where>" +
            "<if test=\"tb_pname!=null and tb_pname!=''\"> and tb_pname=#{tb_pname}</if>" +
            " </where></script>")
    int getPageCount(Map map);

    /**
     * 查询 封存 启封 销户 审核表信息
     * @param grzh
     * @return
     */
    @Select("select * from tb_unseal_audit where audit_name = '待审核' and unseal_account = #{GRZH}")
    Map verification(String grzh);

    /**
     * 校验贷款的人 不能封存和销户  查询贷款人员信息
     * @param grzh
     * @return
     */
    @Select("select * from tb_repay where grzh = #{GRZH}")
    Map loansVerification(String grzh);

    /**
     * 封存 启封 销户申请添加到审核表中
     * @param map
     * @return
     */
    @Insert("insert into tb_unseal_audit(unseal_id,unseal_name,unseal_unit,unseal_sex,unit_post," +
            "unseal_phone,unseal_number,unseal_account," +
            "reason,operator,create_time,state,audit_state,audit_name)" +
            " values(seq_unseal_audit.nextval,#{TB_PNAME},#{UNAME},#{TB_PSEX}," +
            "#{TB_PROFESSION},#{TB_PIPHONE},#{TB_IDNUMBER},#{GRZH},#{REASON},'wqy'," +
            "sysdate,#{PERACCSTATE},#{AUDIT_STATE},'待审核')")
    int add(Map map);

    /**
     * 明细查询分页
     * 带参分页查询to_char(submit_time,'yyyy-mm-dd') as
     * @param map
     * @return
     */
    @Select("<script>select grzh,unitmonpaysum,permonpaysum,ydrawamt," +
            "to_char(lastnaydate,'yyyy-mm-dd') as lastnaydate,paop,uname,tb_pname," +
            "to_char(opendate,'yyyy-mm-dd') as opendate from" +
            " (select rownum rn,a.grzh,a.unitmonpaysum,a.permonpaysum,a.ydrawamt," +
            "a.lastnaydate,a.paop,c.uname,b.tb_pname,a.opendate from tb_paccountutil a" +
            " left join tb_person_info b on a.pid=b.tb_pid" +
            " left join tb_unit c on a.uaid=c.id" +
            " where rownum &lt; #{end}   " +
            "<if test=\"tb_pname!=null and tb_pname!=''\"> and tb_pname like '%'||#{tb_pname}||'%'</if>" +
            " )d where d.rn &gt; #{start} </script>")
    List<Map> getPageByParam2(Map map);
    /**
     * 明细查询
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_paccountutil a" +
            " left join tb_person_info b on a.pid=b.tb_pid" +
            " left join tb_unit c on a.uaid=c.id" +
            " <where>" +
            "<if test=\"tb_pname!=null and tb_pname!=''\"> and tb_pname=#{tb_pname}</if>" +
            " </where></script>")
    int getPageCount2(Map map);
}
