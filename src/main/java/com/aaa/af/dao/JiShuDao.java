package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/19 10:08
 */
public interface JiShuDao {

    /**
     * 查询公司分页数据
     * @param map
     * @return
     */
    @Select("<script>select  rownum rn,DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            "UAOWEMONERY,UASTATE,to_char(UAPAYENDDATE,'yyyy-mm-dd') as UAPAYENDDATE from \n" +
            "(select rownum rn, DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            "UAOWEMONERY,UASTATE,UAPAYENDDATE from tb_unitaccount a left join tb_unit b on a.AID=b.ID\n" +
            "where rownum &lt; #{end}   " +
            "<if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            " ) c where c.rn &gt; #{start} </script>")
    List<Map> getPageByParm(Map map);

    /**
     * 查询公司分页数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_unit <where>" +
            "<if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            " </where></script>")
    int getPageCount(Map map);

    /**
     * 查询公司员工分页数据
     * @param map
     * @return
     */
    @Select("<script>select rownum rn,UAID, GRZH,TB_PNAME,BASENUMMBER,INDINROP,UBITNROP,UNITMONPAYSUM,\n" +
            "PERMONPAYSUM from \n" +
            "(select rownum rn, UAID,GRZH,TB_PNAME,BASENUMMBER,INDINROP,UBITNROP,UNITMONPAYSUM,\n" +
            "PERMONPAYSUM from tb_paccountutil a left join tb_person_info b on a.pid = b.tb_pid \n" +
            "where rownum &lt; #{end1} and unit_id = #{uid}" +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\"> and TB_PNAME like '%'||#{TB_PNAME}||'%'</if>" +
            " ) c where c.rn &gt; #{start1} </script>")
    List<Map> getPageByParm1(Map map);

    /**
     * 查询公司员工分页数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_person_info where unit_id = #{uid} " +
            "<if test=\"TB_PNAME!=null and TB_PNAME!=''\"> and TB_PNAME like '%'||#{TB_PNAME}||'%'</if>" +
            "</script>")
    int getPageCount1(Map map);

    /**
     * 根据个人账号 查询个人信息
     * @param map
     * @return
     */
    @Select("select UAID,UNAME,DWXZ,GRZH,TB_PNAME,BASENUMMBER,PERACCSTATE,UBITNROP,INDINROP,UNITMONPAYSUM,\n" +
            "PERMONPAYSUM from (tb_paccountutil a left join tb_unit b on a.UAID=b.ID)\n" +
            "left join tb_person_info c on a.pid = c.tb_pid where GRZH=#{row}")
    Map getSelect(String map);

    /**
     * 根据个人账号更改 缴存基数 公司缴纳 个人缴纳
     * @param map
     * @return
     */
    @Update("update tb_paccountutil set BASENUMMBER = #{BASENUMMBER},UNITMONPAYSUM = #{UBITNROP}*#{BASENUMMBER}/100,PERMONPAYSUM = #{INDINROP}*#{BASENUMMBER}/100" +
            " where GRZH = #{GRZH}")
    int update1(Map map);

    /**
     * 根据个人账号更改公司和个人缴纳总金额
     * @param map
     * @return
     */
    @Update("update tb_paccountutil set YDRAWAMT = (#{UBITNROP}*#{BASENUMMBER}/100+#{INDINROP}*#{BASENUMMBER}/100) where GRZH = #{GRZH}")
    int updatea(Map map);

    /**
     * 根据公司ID更改应缴纳金额
     * @param map
     * @return
     */
    @Update("update tb_unitaccount set UAOWEMONERY = (select sum(YDRAWAMT) from TB_PACCOUNTUTIL where uaid = #{UAID}) WHERE id = #{UAID}")
    int update2(Map map);
}
