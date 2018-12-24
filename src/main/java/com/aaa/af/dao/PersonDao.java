package com.aaa.af.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/16 17:05
 */
public interface PersonDao {

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Select(" select a.aid,a.UDEPOSITRATIO,a.UPERSONRATIO,a.YWBLR,a.DWZH,b.UNAME from" +
            " tb_unitaccount a left join tb_unit b on a.aid=b.id  where dwzh= #{id}")
    Map getById(String id);

    /**
     * 个人账户注册
     * @param map
     * @return
     */
    @Insert("insert into tb_person_info (TB_PID,TB_PEDUCATION,TB_BNAME,TB_PROFESSION,TB_ACCOUNT,TB_PNAME,TB_PEMAIL,TB_PIPHONE," +
            "TB_PADDRESS,TB_PSEX,TB_PMARRIAGE,TB_IDCARD,TB_IDNUMBER,PERSON_STATE,UNIT_ID) values(tb_person_info_id.nextval,#{TB_PEDUCATION}," +
            "#{TB_BNAME},#{TB_PROFESSION},#{TB_ACCOUNT},#{TB_PNAME},#{TB_PEMAIL},#{TB_PIPHONE},#{TB_PADDRESS},#{TB_PSEX}," +
            "#{TB_PMARRIAGE},#{TB_IDCARD},#{TB_IDNUMBER},'良好',#{gszh})")
    int add(Map map);

    /**
     * 向账户表添加信息
     * @param map
     * @return
     */
    @Insert("insert into tb_paccountutil (PACCID,OPENDATE,PERACCSTATE,BASENUMMBER,UBITNROP,INDINROP,PAOP,PID,KHYH,YHZH,GRMM,UNITMONPAYSUM" +
            ",PERMONPAYSUM,YDRAWAMT,GRZH,UAID) values(tb_paccountutil_id.nextval,SYSDATE,'正常',#{JCJS},#{dwbl},#{grbl},#{blry},tb_person_info_id.currval," +
            "#{TB_BNAME},#{TB_ACCOUNT},'20180116',#{JCJS}*#{dwbl}/100,#{JCJS}*#{grbl}/100,#{JCJS}*#{grbl}/100+#{JCJS}*#{dwbl}/100,to_char(tb_paccountutil_ids.nextval,'fm0000000'),#{AID})")
    int add1(Map map);

    /**
     *个人注册成功时更改公司人数
     * @param map
     * @return
     */
    @Update("update TB_UNITACCOUNT set UDEPOSITEDPNUM = (select count(*) from tb_person_info where unit_id = #{gszh}) where dwzh = #{gszh}")
    int update(Map map);

    /**
     * 个人注册成功时更改公司的缴纳金额
     * @param map
     * @return
     */
    @Update("update tb_unitaccount set UAOWEMONERY = (select sum(YDRAWAMT) from TB_PACCOUNTUTIL where uaid = #{AID}) WHERE ID = #{AID}")
    int update1(Map map);
}
