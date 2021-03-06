package com.aaa.af.dao;

import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/12 08:28
 */
public interface UnitDao {

    /**
     * 添加方法
     * @param map
     * @return
     */
    @Insert("insert into tb_unit (id,uname,uaddress,ulegalperson,ulegaltype,ulegalcard,upaydate,uoperator,uopiphone,jbrzjlx,jbrzjhm,unitbegindate,unetworkcode,gslx,sshy,lsgx,jjlx,yyzz,dwxz) values(tb_unit_id.nextval,#{uname},#{uaddress},#{ulegalperson},#{ulegaltype},#{ulegalcard},#{upaydate},#{uoperator},#{uopiphone}," +
            "#{jbrzjlx},#{jbrzjhm},to_date(substr(#{unitbegindate},1,10),'yyyy-MM-dd'),#{unetworkcode},#{gslx},#{sshy},#{lsgx},#{jjlx},#{yyzz}," +
            "extract (year from sysdate)||extract(month from sysdate)||extract (day from sysdate)||to_char(tb_unit_ida.nextval,'fm00000'))")
    int add(Map map);

    /**
     * 添加方法
     * @param map
     * @return
     */
    @Insert("insert into TB_UNITACCOUNT(id,udepositratio,upersonratio,uastate,uabankname,uabanknumber,styh,ywblr,khrq,dwzh,AID,UAOWEMONTHS) values(tb_unitaccount_id.nextval," +
            "#{udepositratio},#{upersonratio},#{uastate},#{uabankname},#{uabanknumber},#{styh},#{ywblr},to_date(substr(#{khrq},1,10),'yyyy-MM-dd')," +
            "extract (year from sysdate)||extract(month from sysdate)||extract (day from sysdate)||to_char(tb_unit_ida.currval,'fm00000'),tb_unit_id.currval,1)")
    int add1(Map map);

    /**
     * 明细列表查询
     * @param map
     * @return
     */
    @Select("<script>select * from " +
            " (select rownum rn,ID,UNAME,UACCOUNT,UMONEY,UTYPE,to_char(UDATE,'yyyy-MM-dd') as UDATE,UCMONEY,PERNUM,MONTHNUM,CPERSON from urecord "+
            "  where rownum &lt; #{end} " +
            "  <if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            "  ) c where c.rn &gt; #{start} </script>")
    List<Map> detail(Map map);

    /**
     * 明细列表数量查询
     * @param map
     * @return
     */
    @Select("<script> select count(*) from urecord <where>" +
            "<if test=\"UNAME!=null and UNAME!=''\"> and UNAME like '%'||#{UNAME}||'%'</if>" +
            "  </where></script>")
    int count(Map map);


    /**
     * 公司名称唯一性验证
     * @param name
     * @return
     */
    @Select("select count(*) from tb_unit where uname = #{name}")
    int uname(String name);

    /**
     * 法人身份证唯一性验证
     * @param card
     * @return
     */
    @Select("select count(*) from tb_unit where ulegalcard = #{card}")
    int idCard(String card);

    /**
     * 经办人身份证唯一性验证
     * @param card
     * @return
     */
    @Select("select count(*) from tb_unit where jbrzjhm = #{card}")
    int idCard1(String card);

    /**
     * 经办人电话唯一性验证
     * @param num
     * @return
     */
    @Select("select count(*) from tb_unit where UOPIPHONE = #{num}")
    int phone(String num);
}
