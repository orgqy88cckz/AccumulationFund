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

    /**
     * 查询分页数据
     * @param map
     * @return
     */
    @Select("<script>select rownum rn,AID,DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            "UAOWEMONERY,UASTATE,UAPAYENDDATE from \n" +
            "(select rownum rn,AID,DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            " UAOWEMONERY,UASTATE,to_char(UAPAYENDDATE,'yyyy-mm-dd') as UAPAYENDDATE from tb_unitaccount a left join tb_unit b on a.AID=b.ID\n" +
            "where rownum &lt; #{end}   " +
            "<if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            " ) c where c.rn &gt; #{start} </script>")
    List<Map> getPageByParm(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_unit <where>" +
            "<if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            " </where></script>")
    int getPageCount(Map map);

    /**
     * 根据公司id更改公司账户表单位汇缴比例和个人汇缴比例
     * @param map
     * @return
     */
    @Update("update tb_unitaccount set UPERSONRATIO = #{UPERSONRATIO},UDEPOSITRATIO = #{UDEPOSITRATIO} where  AID = #{AID} ")
    int update(Map map);

    /**
     * 根据公司id更改个人账户表单位汇缴比例和个人汇缴比例
     * @param map
     * @return
     */
    @Update("update TB_PACCOUNTUTIL set UBITNROP=#{UDEPOSITRATIO},INDINROP=#{UPERSONRATIO} where UAID=#{AID} and PERACCSTATE='正常'")
    int update1(Map map);

    /**
     * 根据公司id查询所需数据
     * @param map
     * @return
     */
    @Select("select PACCID,UAID,BASENUMMBER,UBITNROP,INDINROP,PERACCSTATE from TB_PACCOUNTUTIL where UAID=#{AID}")
    List<Map> page1(Map map);

    /**
     * 根据个人账户id 更新个人缴纳，公司缴纳
     * @param map
     * @return
     */
    @Update("update TB_PACCOUNTUTIL set UNITMONPAYSUM=#{gongsi},PERMONPAYSUM=#{geren} where PACCID=#{id} and PERACCSTATE='正常'")
    int update2(Map map);

    /**
     * 根据个人账户id更新缴纳总额
     * @param map
     * @return
     */
    @Update("update tb_paccountutil set YDRAWAMT = (#{gongsi} + #{geren}) where PACCID = #{id} and PERACCSTATE = '正常'")
    int update3(Map map);

    /**
     * 根据公司id更新缴纳总额
     * @param map
     * @return
     */
    @Update("update tb_unitaccount set UAOWEMONERY = (select sum(YDRAWAMT) from TB_PACCOUNTUTIL where uaid = #{id1}) WHERE aid = #{id1}")
    int update4(Map map);
}
