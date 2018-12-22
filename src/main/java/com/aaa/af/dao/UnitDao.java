package com.aaa.af.dao;

import org.apache.ibatis.annotations.Insert;

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
}
