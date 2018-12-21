package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/18 15:32
 */
public interface AccountDao {
    /**
     * 获取个人信息
     * @return
     */
    @Select("<script>select tb_pid,paccid,tb_pname,tb_psex,tb_piphone,uname,ubitnrop,indinrop,dalance,peraccstate,tb_idcard,tb_idnumber,tb_peducation,tb_profession,tb_pemail,tb_paddress,tb_pdate,tb_pmarriage,basenummber,tb_bname,tb_account from " +
            "(select rownum rn,i.tb_pid,a.paccid,i.tb_pname,i.tb_psex,i.tb_piphone,u.uname,a.ubitnrop,a.indinrop,a.dalance,a.peraccstate,i.tb_idcard,i.tb_idnumber,i.tb_peducation,i.tb_profession,i.tb_pemail,i.tb_paddress,to_char(i.tb_pdate,'yyyy-MM-dd') as tb_pdate,i.tb_pmarriage,a.basenummber,i.tb_bname,i.tb_account from tb_person_info i left join tb_paccountutil a on i.tb_pid=a.pid left join tb_unit u on a.uaid=u.id where rownum &lt; #{end} " +
            "<if test=\"title!=null and title!=''\"> and a.paccid like '%'||#{title}||'%' or i.tb_pname like '%'||#{title}||'%' or i.tb_psex like '%'||#{title}||'%' or i.tb_piphone like '%'||#{title}||'%' or u.uname like '%'||#{title}||'%'" +
            " or a.ubitnrop like '%'||#{title}||'%' or a.indinrop like '%'||#{title}||'%' or a.dalance like '%'||#{title}||'%' or a.peraccstate like '%'||#{title}||'%' or i.tb_idcard like '%'||#{title}||'%' or i.tb_idnumber like '%'||#{title}||'%'" +
            " or i.tb_peducation like '%'||#{title}||'%' or i.tb_profession like '%'||#{title}||'%' or i.tb_pemail like '%'||#{title}||'%' or i.tb_paddress like '%'||#{title}||'%' or i.tb_pdate like '%'||#{title}||'%' or i.tb_pmarriage like '%'||#{title}||'%'" +
            " or a.basenummber like '%'||#{title}||'%' or i.tb_bname like '%'||#{title}||'%' or a.basenummber like '%'||#{title}||'%'" +
            "</if>" +
            " )a where a.rn &gt; #{start} </script>")
    List<Map> getPersonInfo(Map map);
    /**
     * 查询分页总数量
     * @return
     */
    @Select("<script>select count(*) from " +
            "(select rownum rn,a.paccid,i.tb_pname,i.tb_psex,i.tb_piphone,u.uname,a.ubitnrop,a.indinrop,a.dalance,a.peraccstate,i.tb_idcard,i.tb_idnumber,i.tb_peducation,i.tb_profession,i.tb_pemail,i.tb_paddress,i.tb_pdate,i.tb_pmarriage,a.basenummber,i.tb_bname,i.tb_account from tb_person_info i left join tb_paccountutil a on i.tb_pid=a.pid left join tb_unit u on a.uaid=u.id <where>" +
            "<if test=\"title!=null and title!=''\"> and a.paccid like '%'||#{title}||'%' or i.tb_pname like '%'||#{title}||'%' or i.tb_psex like '%'||#{title}||'%' or i.tb_piphone like '%'||#{title}||'%' or u.uname like '%'||#{title}||'%'" +
            " or a.ubitnrop like '%'||#{title}||'%' or a.indinrop like '%'||#{title}||'%' or a.dalance like '%'||#{title}||'%' or a.peraccstate like '%'||#{title}||'%' or i.tb_idcard like '%'||#{title}||'%' or i.tb_idnumber like '%'||#{title}||'%'" +
            " or i.tb_peducation like '%'||#{title}||'%' or i.tb_profession like '%'||#{title}||'%' or i.tb_pemail like '%'||#{title}||'%' or i.tb_paddress like '%'||#{title}||'%' or i.tb_pdate like '%'||#{title}||'%' or i.tb_pmarriage like '%'||#{title}||'%'" +
            " or a.basenummber like '%'||#{title}||'%' or i.tb_bname like '%'||#{title}||'%' or a.basenummber like '%'||#{title}||'%'" +
            "</if>" +
            " </where>) </script>")
    int getPageCount(Map map);
    /**
     * 修改个人信息
     * @param map
     * @return
     */
    @Update("update tb_person_info set tb_pname=#{TB_PNAME},tb_piphone=#{TB_PIPHONE},tb_psex=#{TB_PSEX},tb_idcard=#{TB_IDCARD},tb_idnumber=#{TB_IDNUMBER},tb_peducation=#{TB_PEDUCATION},tb_profession=#{TB_PROFESSION},tb_pemail=#{TB_PEMAIL},tb_paddress=#{TB_PADDRESS},tb_bname=#{TB_BNAME},tb_account=#{TB_ACCOUNT},tb_pdate=to_date(#{TB_PDATE},'yyyy-MM-dd'),tb_pmarriage=#{TB_PMARRIAGE} where tb_pid=#{TB_PID}")
    int update(Map map);
    /**
     * 获取单位信息
     * @return
     */
    @Select("<script>select id,dwzh,uname,udepositratio,upersonratio,udepositedpnum,uaremain,uaowemonery,uastate,khrq,uaddress,gslx,sshy,lsgx,jjlx,dwxz,upaydate,ywblr,unitbegindate,uoperator,uopiphone,jbrzjlx,jbrzjhm,uabankname,styh,uabanknumber,ulegalperson,ulegaltype,ulegalcard,yyzz from " +
            "(select rownum rn,u.id,a.dwzh,u.uname,a.udepositratio,a.upersonratio,a.udepositedpnum,a.uaremain,a.uaowemonery,a.uastate,to_char(a.khrq,'yyyy-MM-dd') as khrq,u.uaddress,u.gslx,u.sshy,u.lsgx,u.jjlx,u.dwxz,u.upaydate,a.ywblr,to_char(u.unitbegindate,'yyyy-MM-dd') as unitbegindate,u.uoperator,u.uopiphone,u.jbrzjlx,u.jbrzjhm,a.uabankname,a.styh,a.uabanknumber,u.ulegalperson,u.ulegaltype,u.ulegalcard,u.yyzz from tb_unit u left join tb_unitaccount a on u.id=a.aid where rownum &lt; #{end} " +
            "<if test=\"title!=null and title!=''\"> and u.uname like '%'||#{title}||'%'" +
            "</if>" +
            " )a where a.rn &gt; #{start} </script>")
    List<Map> getUnitInfo(Map map);
    /**
     * 查询分页总数量
     * @return
     */
    @Select("<script>select count(*) from " +
            "(select a.dwzh,u.uname,a.udepositratio,a.upersonratio,a.udepositedpnum,a.uaremain,a.uaowemonery,a.uastate,to_char(a.khrq,'yyyy-MM-dd') as khrq,u.uaddress,u.gslx,u.sshy,u.lsgx,u.jjlx,u.dwxz,u.upaydate,a.ywblr,to_char(u.unitbegindate,'yyyy-MM-dd') as unitbegindate,u.uoperator,u.uopiphone,u.jbrzjlx,u.jbrzjhm,a.uabankname,a.styh,a.uabanknumber,u.ulegalperson,u.ulegaltype,u.ulegalcard,u.yyzz from tb_unit u left join tb_unitaccount a on u.id=a.aid <where>" +
            "<if test=\"title!=null and title!=''\"> and u.uname like '%'||#{title}||'%'" +
            "</if>" +
            " </where>) </script>")
    int getUnitPageCount(Map map);
    /**
     * 修改单位信息
     * @param map
     * @return
     */
    @Update("update tb_unit set uname=#{UNAME},uopiphone=#{UOPIPHONE},uaddress=#{UADDRESS},jbrzjlx=#{JBRZJLX},gslx=#{GSLX},jbrzjhm=#{JBRZJHM},sshy=#{SSHY},lsgx=#{LSGX},jjlx=#{JJLX},ulegalperson=#{ULEGALPERSON},upaydate=#{UPAYDATE},unitbegindate=to_date(#{UNITBEGINDATE},'yyyy-MM-dd'),ulegaltype=#{ULEGALPERSON},uoperator=#{UOPERATOR},ulegalcard=#{ULEGALCARD},yyzz=#{YYZZ} where id=#{ID}")
    int updateUnit(Map map);
    /**
     * 修改单位账户信息
     * @param map
     * @return
     */
    @Update("update tb_unitaccount set uabankname=#{UABANKNAME},styh=#{STYH},uabanknumber=#{UABANKNUMBER} where aid=#{ID}")
    int updateUnitAccount(Map map);
}
