package com.aaa.af.dao;

import org.apache.ibatis.annotations.Insert;
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

    /**
     * 查询分页数据
     * @param map
     * @return
     */
    @Select("<script>select rownum rn,AID,DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            "UAOWEMONERY,UASTATE,to_char(UAPAYENDDATE,'yyyy-MM-dd') as UAPAYENDDATE  from \n" +
            "(select rownum rn,AID,DWZH,UNAME,UDEPOSITRATIO,UPERSONRATIO,UDEPOSITEDPNUM,UAREMAIN,\n" +
            " UAOWEMONERY,UASTATE,UAPAYENDDATE from tb_unitaccount a left join tb_unit b on a.AID=b.ID\n" +
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

    /**
     * 查询
     * @param map
     * @return
     */
    @Select("select TB_PNAME,GRZH,DALANCE,LASTNAYDATE,PERMONPAYSUM,YDRAWAMT from tb_paccountutil a left join\n" +
            "tb_person_info b on a.pid = b.tb_pid where UAID=#{AID}")
    List<Map> select1(Map map);

    /**
     * 查询
     * @param map
     * @return
     */
    @Select("select UNAME,DWZH,UAREMAIN,UAPAYENDDATE,UAOWEMONERY from tb_unitaccount a left join tb_unit b on a.AID = b.ID where DWZH = #{DWZH}")
    List<Map> select2(Map map);

    /**
     * 更新个人账户余额
     * @param map
     * @return
     */
    @Update("update tb_paccountutil set DALANCE = (DALANCE + #{YDRAWAMT}) where GRZH = #{GRZH}")
    int update3(Map map);

    /**
     * 向单位记录表插入数据
     * @param map
     * @return
     */
    @Insert("insert into urecord (ID,UNAME,UACCOUNT,UMONEY,UTYPE,UDATE,UCMONEY) values(urecord_id.nextval，#{UNAME},#{DWZH},#{UAREMAIN},'汇缴',#{UAPAYENDDATE},#{UAOWEMONERY})")
    int insert(Map map);

    /**
     * 向个人记录表插入数据
     * @param map
     * @return
     */
    @Insert("insert into precord (ID,PNAME,PACCOUNT,PMONEY,PTYPE,PDATE,PCMONEY) values(precord_id.nextval,#{TB_PNAME},#{GRZH},#{DALANCE},'汇缴',#{LASTNAYDATE},#{PERMONPAYSUM})")
    int insert1(Map map);

}
