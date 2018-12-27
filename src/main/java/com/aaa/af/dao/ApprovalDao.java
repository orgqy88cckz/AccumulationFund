package com.aaa.af.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:TransferAudit
 * discription:查看审批
 * author:wqy
 * createTime:2018-12-16 20:01
 */
public interface ApprovalDao {
    /**
     * 带参分页查询
     * 查看审批
     * @param map
     * @return
     * 如果使用注解的方式，动态SQL必须在标签<script></script>
     * 如果使用<script></script>标签，mabatis大于小于，必须使用&gt;  &lt;
     */
    @Select("<script>select id,accraditation_name,accraditation_describe,accraditation_flux from" +
            " (select rownum rn,id,accraditation_name,accraditation_describe," +
            "accraditation_flux from accraditation" +
            " where rownum &lt; #{end} " +
            " )d where d.rn &gt; #{start} </script>")
    List<Map> getPageByParam(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from accraditation</script>")
    int getPageCount(Map map);
    /**
     * 带参分页查询-------人员转移审核
     * @param map
     * @return
     */
    @Select("<script>select transfer_out_unit,transfer_into_unit," +
            "auditor,person_account,transfer_reason,operator," +
            "to_char(submit_time,'yyyy-mm-dd') as submit_time," +
            "audit_state from" +
            " (select rownum rn,transfer_out_unit,transfer_into_unit," +
            "auditor,person_account,transfer_reason,operator,submit_time," +
            "audit_state from tb_transfer_audit_jl" +
            " where rownum &lt; #{end} " +
            " )d where d.rn &gt; #{start} </script>")
    List<Map> getPageByParamR(Map map);
    /**
     * 查询分页总数量------人员转移审核
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_transfer_audit_jl</script>")
    int getPageCountR(Map map);
    /**
     * 带参分页查询------- 封启销户查看审批
     * @param map
     * @return
     */
    @Select("<script>select unseal_name,unseal_unit,unseal_sex,unit_post,unseal_number," +
            "unseal_account,reason,operator,to_char(create_time,'yyyy-mm-dd') as create_time,audit_state,audit_name from" +
            " (select rownum rn,unseal_name,unseal_unit,unseal_sex,unit_post,unseal_number," +
            "unseal_account,reason,operator,create_time,audit_state,audit_name" +
            " from tb_unseal_audit where audit_name in ('通过','驳回') and rownum &lt; #{end} " +
            " )d where d.rn &gt; #{start} </script>")
    List<Map> getPageByParamF(Map map);
    /**
     * 查询分页总数量------ 封启销户查看审批
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_unseal_audit where audit_name in ('通过','驳回')</script>")
    int getPageCountF(Map map);

    /**
     * 带参分页查询------- 个人贷款查看审批
     * @param map
     * @return
     */
    @Select("<script>select grzh,tb_idnumber,pname,to_char(ctime,'yyyy-mm-dd') as ctime," +
            "daikan,rejectreason,status,loan_bank," +
            "loan_rate,loan_periods,loan_money from(" +
            "select rownum rn,a.grzh,b.tb_idnumber,a.pname,a.ctime,a.daikan,a.rejectreason,a.status,a.loan_bank," +
            "a.loan_rate,a.loan_periods,a.loan_money from tb_loan_check a" +
            " left join tb_person_info b on a.pname=b.tb_pname" +
            " where status in(2,3,4,5) and rownum &lt; #{end} " +
            " )d where d.rn &gt; #{start} </script>")
    List<Map> getPageByParamG(Map map);
    /**
     * 查询分页总数量------ 个人贷款查看审批
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_loan_check a" +
            " left join tb_person_info b on a.pname=b.tb_pname" +
            " where status in(2,3,4,5)</script>")
    int getPageCountG(Map map);

    /**
     * 带参分页查询------- 公积金提取查看审批
     * @param map
     * @return
     */
    @Select("<script>select appl_account,appl_name,comp_name,application_type,application_way,extract_reason," +
            "allow_money,to_char(appl_time,'yyyy-mm-dd') as appl_time,appl_state from(" +
            "select rownum rn,appl_account,appl_name,comp_name,application_type,application_way,extract_reason," +
            "allow_money,appl_time,appl_state" +
            " from tb_bftake_check where appl_state in(2,3) and rownum &lt; #{end} " +
            " )d where d.rn &gt; #{start} </script>")
    List<Map> getPageByParamGJ(Map map);
    /**
     * 查询分页总数量------ 公积金提取查看审批
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_bftake_check where appl_state in(2,3)</script>")
    int getPageCountGJ(Map map);

    /**
     * 查询到个人贷款tb_loan_check
     * 记录表 当前信息条数
     * @return
     */
    @Select("select count(*) as flux from tb_loan_check where status in(2,3,4,5)")
    int accraditationCount();

    /**
     * 查询到个人转移tb_transfer_audit_jl
     * 记录表 当前信息条数
     * @return
     */
    @Select("select count(*) as flux from tb_transfer_audit_jl")
    int accraditationCountb();

    /**
     * 查询到公积金提取
     * 部分销户tb_bftake_check
     * 约定提取tb_appoint_check
     * 记录表 当前信息条数
     * @return
     */
    @Select("select count(*) as flux from tb_bftake_check where appl_state in(2,3)")
    int accraditationCountt();

    /**
     * 封存、启封、销户审批tb_unseal_audit
     * 记录表 当前信息条数
     * @return
     */
    @Select("select count(*) as flux from tb_unseal_audit where audit_name in('通过','驳回')")
    int accraditationCounts();

    /**
     * 更新查看审批表的相关信息
     * 工作流量
     * @return
     */
    @Update("update accraditation set accraditation_flux = #{ACCRADITATION_FLUX}" +
            " where accraditation_name=#{ACCRADITATION_NAME}")
    int addAccraditationCount(@Param("ACCRADITATION_FLUX") int accraditation_flux,@Param("ACCRADITATION_NAME") String accraditation_name);

}
