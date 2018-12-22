package com.aaa.af.dao;

import com.sun.javafx.collections.MappingChange;
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
public interface BiLiDao {

    @Select("<script>select rownum rn,AID,DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            "UAOWEMONERY,UASTATE,UAPAYENDDATE from \n" +
            "(select rownum rn,AID,DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            " UAOWEMONERY,UASTATE,UAPAYENDDATE from tb_unitaccount a left join tb_unit b on a.AID=b.ID\n" +
            "where rownum &lt; #{end}   " +
            "<if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            " ) c where c.rn &gt; #{start} </script>")
    List<Map> getPageByParm(Map map);

    @Select("<script> select count(*) from tb_unit <where>" +
            "<if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            " </where></script>")
    int getPageCount(Map map);

    @Update("update tb_unitaccount set UPERSONRATIO = #{UPERSONRATIO},UDEPOSITRATIO = #{UDEPOSITRATIO} where  AID = #{AID}")
    int update(Map map);

    @Update("update TB_PACCOUNTUTIL set UBITNROP=#{UDEPOSITRATIO},INDINROP=#{UPERSONRATIO} where UAID=#{AID}")
    int update1(Map map);

    @Select("select PACCID,UAID,BASENUMMBER,UBITNROP,INDINROP from TB_PACCOUNTUTIL where UAID=#{AID}")
    List<Map> page1(Map map);

    @Update("update TB_PACCOUNTUTIL set UNITMONPAYSUM=#{gongsi},PERMONPAYSUM=#{geren} where PACCID=#{id}")
    int update2(Map map);
    @Update("update tb_paccountutil set YDRAWAMT = (#{gongsi} + #{geren}) where PACCID = #{id}")
    int update3(Map map);

    @Update("update tb_unitaccount set UAOWEMONERY = (select sum(YDRAWAMT) from TB_PACCOUNTUTIL where uaid = #{id1}) WHERE aid = #{id1}")
    int update4(Map map);
}
