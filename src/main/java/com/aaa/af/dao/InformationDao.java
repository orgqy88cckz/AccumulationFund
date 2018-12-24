package com.aaa.af.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:mx
 * createTime:2018/12/7 19:56
 */
public interface InformationDao {
    /**
     * 信息传到前台
     * @param a
     * @return
     */
    List<Map> xinxiListMaps(int a );

    /**
     * 分页查询信息表
     * @return
     */
    @Select("<script>select id,title,details,sname,tname,infortime from \n" +
            "(select rownum rn,i.id,i.title,i.details,s.sname sname,t.name tname,to_char(i.infortime,'yyyy-mm-dd') infortime from tb_inform i \n" +
            "left join tb_newsstate s on i.informstatus=s.id left join tb_newstype t on i.informtype= t.id where rownum &lt; #{end}   " +
            "<if test=\"title!=null and title!=''\"> and title like '%'||#{title}||'%'</if>" +
            "<if test=\"informstatus!=null and informstatus!=''\">  and informstatus =#{informstatus}</if>" +
            " )a where a.rn &gt; #{start} </script>")
    List<Map> getInformations(Map map);
    /**
     * 查询分页总数量
     * @return
     */
    @Select("<script> select count(*) from tb_inform <where>" +
            "<if test=\"title!=null and title!=''\"> and title like '%'||#{title}||'%'</if>" +
            "<if test=\"informstatus!=null and informstatus!=''\">  and informstatus =#{informstatus}</if>" +
            " </where></script>")
    int getPageCount(Map map);
    /**
     * 添加
     * @param map
     * @return
     */
    @Insert("insert into tb_inform values(seq_inform_id.nextval,#{TITLE},#{DETAILS},#{TNAME},#{INFORMSTATUS},to_date(#{INFORTIME},'yyyy-MM-dd'))")
    int add(Map map);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from tb_inform where id=#{ID}")
    int delete(int id);
    /**
     * 批量删除
     * @param list
     * @return
     */
    @Delete("<script>delete from tb_inform where id in " +
            "<foreach collection='list' item='id' open='(' close=')' separator=','>#{id}</foreach>" +
            "</script>")
    int batchDelete(List list);

    /**
     * 修改前台信息
     * @param map
     * @return
     */
    @Update("update tb_inform set TITLE=#{TITLE},DETAILS=#{DETAILS},INFORMTYPE=#{INFORMTYPE},INFORMSTATUS=#{INFORMSTATUS},INFORTIME=to_date(#{INFORTIME},'yyyy-MM-dd') where ID=#{ID}")
    int update(Map map);

    /**
     * 查看账户是否存在
     * @param map
     * @return
     */
    @Select("select count(*) from tb_paccountutil where grzh=#{username}")
    int getPersonAccount(Map map);

    /**
     * 获取个人密码
     * @param map
     * @return
     */
    @Select("select grmm from tb_paccountutil where grzh=#{username}")
    List<Map> getPersonPassword(Map map);
}
