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
 * createTime:2018/12/15 8:33
 */
public interface RoleDao {
    /**
     * 查询角色列表
     * @return
     */
    @Select("<script>select roleid,rolename,roledesc,rolestatus from" +
            "(select rownum rn,roleid,rolename,roledesc,rolestatus from tb_role where rownum &lt; #{end}" +
            " )a where a.rn &gt; #{start} </script>")
    List<Map> getRoles(Map map);
    /**
     * 查询分页总数量
     * @return
     */
    @Select("<script> select count(*) from tb_role <where>" +
            " </where></script>")
    int getPageCount(Map map);
    /**
     * 添加
     * @param map
     * @return
     */
    @Insert("insert into tb_role values(seq_role_id.nextval,#{ROLENAME},#{ROLEDESC},#{ROLESTATUS})")
    int add(Map map);
    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from tb_role where roleid=#{ROLEID}")
    int delete(int id);
    /**
     * 修改前台信息
     * @param map
     * @return
     */
    @Update("update tb_role set rolename=#{ROLENAME},roledesc=#{ROLEDESC},rolestatus=#{ROLESTATUS} where roleid=#{ROLEID}")
    int update(Map map);

    /**
     * 获取角色权限ID
     * @param map
     * @return
     */
    @Select("select m.treeid roleid" +
            " from tb_role r left join tb_middle m on r.roleid=m.roleid where r.roleid=#{ROLEID}")
    List<Integer> getTreeid(Map map);
    /**
     * 获取角色权限父ID
     * @param map
     * @return
     */
    @Select("select m.treeid from tb_role r left join tb_middle m on r.roleid=m.roleid left join tb_treememu tr on tr.treeid=m.treeid where r.roleid=#{ROLEID} and tr.treeparent=0")
    List<Integer> getParentTreeid(Map map);
    /**
     * 删除角色权限
     * @param map
     * @return
     */
    @Delete("delete from tb_middle where roleid=#{ROLEID}")
    int deleteTreeids(Map map);
    /**
     * 添加权限
     * @param map
     * @return
     */
    @Insert("insert into tb_middle values(#{ROLEID},#{INTEGER})")
    int addTreeids(Map map);
}
