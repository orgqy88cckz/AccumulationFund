package com.aaa.af.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:UserTransfer
 * discription:人员转移
 * author:wqy
 * createTime:2018-12-11 14:25
 */
public interface UserTransferDao {
    /**
     * 带参分页查询------全体人员
     * @param map
     * @return
     * 如果使用注解的方式，动态SQL必须在标签<script></script>
     * 如果使用<script></script>标签，mabatis大于小于，必须使用&gt;  &lt;
     */
    @Select("<script>select tb_pname,tb_idnumber,tb_pid,grzh,dalance,peraccstate from" +
            "(select rownum rn,a.tb_pname,a.tb_idnumber,a.tb_pid,b.grzh,b.dalance,b.peraccstate" +
            " from tb_person_info a left join tb_paccountutil b on a.tb_pid=b.pid" +
            " where rownum &lt; #{end}   " +
            "<if test=\"tb_idnumber!=null and tb_idnumber!=''\"> and tb_idnumber=#{tb_idnumber}</if>" +
            "<if test=\"tb_pname!=null and tb_pname!=''\"> and tb_pname like '%'||#{tb_pname}||'%'</if>" +
            " )c where c.rn &gt; #{start} </script>")
    List<Map> getPageByParam(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_person_info a left join tb_paccountutil b on a.tb_pid=b.pid" +
            " <where>" +
            "<if test=\"tb_idnumber!=null and tb_idnumber!=''\"> and tb_idnumber=#{tb_idnumber}</if>" +
            "<if test=\"tb_pname!=null and tb_pname!=''\"> and tb_pname like '%'||#{tb_pname}||'%'</if>" +
            " </where></script>")
    int getPageCount(Map map);

    /**
     * 根据name查询全体人员找出一条数据，并显示到提交审核处
     * @param tb_pname
     * @return
     */
    @Select("select a.tb_pname,a.tb_pid," +
            "a.tb_idnumber,b.grzh,b.basenummber,b.dalance,b.peraccstate," +
            "b.pid,b.uaid,c.id,c.uname,d.aid,d.uabankname,d.styh " +
            "from tb_person_info a left join tb_paccountutil b on a.tb_pid=b.pid" +
            " left join tb_unit c on b.uaid=c.id" +
            " left join tb_unitaccount d on c.id=d.aid" +
            " where a.tb_pname=#{TB_PNAME}")
    Map selectByName( String tb_pname);

    /**
     * 公司列表查询
     *  状态为正常的
     *  显示到提交审核处
     * @return
     */
    @Select("select a.id,a.uname from tb_unit a left join tb_unitaccount b" +
            " on b.aid=a.id where uastate = '正常'")
    List<Map> getUnit();

    /**
     *下拉框选中公司 获取ID  查询公司的受托银行
     * 显示到提交审核处
     * @return
     */
    @Select("select a.id,b.aid,b.styh from tb_unit a left join tb_unitaccount b" +
            " on a.id=b.aid where a.id=#{ID}")
    Map getUintById(Integer id);
    /**
     * 添加页面编辑框有的内容到待转移人员表中，然后再添加一次查询出来的数据（update）
     * @param map
     * @return
     */
    @Insert("insert into tb_transfer_audit" +
            "(transfer_id,transfer_out_unit,transfer_into_unit,auditor,person_account," +
            "transfer_reason,operator,submit_time,audit_state,pname,idNumber,balance," +
            "state,baseNummber) " +
            "values(seq_transfer_audit.nextval,#{UNAME},#{RUNAME},#{TB_PNAME},#{GRZH}," +
            "#{TRANSFER_REASON},'wqy',to_date(#{SUBMIT_TIME},'yyyy-mm-dd'),'待审核',#{TB_PNAME},#{TB_IDNUMBER},#{DALANCE}," +
            "#{PERACCSTATE},#{BASENUMMBER})")
    int add(Map map);
    /**
     * 带参分页查询-----待转移人员
     * @param map
     * @return
     */
    @Select("<script>select transfer_id,pname,idnumber,state,balance from" +
            "(select rownum rn,transfer_id,pname,idnumber,state,balance" +
            " from tb_transfer_audit" +
            " where rownum &lt; #{end}   " +
            "<if test=\"idnumber!=null and idnumber!=''\"> and idnumber=#{idnumber}</if>" +
            " )c where c.rn &gt; #{start} </script>")
    List<Map> getPageByParam2(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from tb_transfer_audit" +
            " <where>" +
            "<if test=\"idnumber!=null and idnumber!=''\"> and idnumber=#{idnumber}</if>" +
            " </where></script>")
    int getPageCount2(Map map);

    /**
     * 提交验证，不能提交两次申请
     * @param idnumber
     * @return
     */
    @Select("select transfer_id,pname,idnumber,balance,state," +
            "person_account,transfer_reason,operator,submit_time,audit_state" +
            " from tb_transfer_audit where idnumber = #{TB_IDNUMBER}")
    Map submitVerify(String idnumber);
}
