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
 * createTime:2018/12/17 11:40
 */
public interface PostDao {
    /**
     * 查询用户信息
     * @return
     */
    @Select("<script>select userid,name,company,realname,phone,sex,roleid,rolename from" +
            "(select rownum rn,u.userid,u.name,u.company,u.realname,u.phone,u.sex,u.roleid,r.rolename from tb_user u left join tb_role r on r.roleid=u.roleid where rownum &lt; #{end}" +
            "<if test=\"realname!=null and realname!=''\"> and u.realname like '%'||#{realname}||'%'</if>" +
            " )a where a.rn &gt; #{start} </script>")
    List<Map> getUsers(Map map);
    /**
     * 查询分页总数量
     * @return
     */
    @Select("<script> select count(*) from tb_user <where>" +
            "<if test=\"realname!=null and realname!=''\"> and realname like '%'||#{realname}||'%'</if>" +
            " </where></script>")
    int getPageCount(Map map);
    /**
     * 获取角色列表
     * @return
     */
    @Select("select roleid,rolename from tb_role")
    List<Map> getRoles();
    /**
     * 添加
     * @param map
     * @return
     */
    @Insert("insert into tb_user values(seq_user_id.nextval,#{NAME},#{PASSWORD},#{REALNAME},#{ROLEID},#{PHONE},#{COMPANY},#{SEX})")
    int add(Map map);
    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from tb_user where userid=#{ID}")
    int delete(int id);
    /**
     * 修改前台信息
     * @param map
     * @return
     */
    @Update("update tb_user set NAME=#{NAME},PASSWORD=#{PASSWORD},REALNAME=#{REALNAME},ROLEID=#{ROLEID},PHONE=#{PHONE},COMPANY=#{COMPANY},SEX=#{SEX} where USERID=#{USERID}")
    int update(Map map);
}
