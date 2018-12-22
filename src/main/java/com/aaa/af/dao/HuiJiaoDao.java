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
public interface HuiJiaoDao {

    @Select("<script>select rownum rn,AID,DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            "UAOWEMONERY,UASTATE,to_char(UAPAYENDDATE,'yyyy-MM-dd') as UAPAYENDDATE  from \n" +
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

    /**
     * 根据公司账号查询数据
     * @param map
     * @return
     */
    @Select("select AID,DWZH,UNAME,to_char(sysdate,'yyyy-mm-dd') as UAPAYENDDATE,UAOWEMONTHS,UDEPOSITRATIO,UASTATE,\n" +
            "UPERSONRATIO,UAREMAIN,UDEPOSITEDPNUM,UAOWEMONERY from tb_unitaccount a\n" +
            "left join tb_unit b on a.ID = b.ID where DWZH = #{DWZH}")
    Map getSelect(String map);

    /**
     * 汇缴成功时提交汇缴日期
     * @param map
     * @return
     */
    @Update("update tb_unitaccount set UAPAYENDDATE = to_date(#{UAPAYENDDATE},'yyyy-mm-dd') where DWZH = #{DWZH}")
    int update(Map map);

    /**
     * 汇缴成功时单位余额当减少
     * @param map
     * @return
     */
    @Update("update tb_unitaccount set UAREMAIN = (#{UAREMAIN}- #{UAOWEMONERY}) where DWZH = #{DWZH}")
    int update1(Map map);

    /**
     * 汇缴成功时更改个人汇缴日期
     * @param map
     * @return
     */
    @Update("update tb_paccountutil set LASTNAYDATE = to_date(#{UAPAYENDDATE},'yyyy-mm-dd') where  UAID = #{AID}")
    int update2(Map map);

    @Select("select YDRAWAMT,GRZH from tb_paccountutil")
    List<Map> select1(Map map);

    @Update("update tb_paccountutil set DALANCE = (DALANCE + #{YDRAWAMT}) where GRZH = #{GRZH}")
    int update3(Map map);
}
