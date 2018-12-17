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
 * createTime:2018/12/13 20:27
 */
public interface PowerDao {
    /**
     * 查询权限节点
     * @return
     */
    @Select("<script>select treeId,lable,treeUrl,treeParent from" +
            "(select rownum rn,treeId,lable,treeUrl,treeParent from TB_TREEMEMU where rownum &lt; #{end}" +
            "<if test=\"lable!=null and lable!=''\"> and lable like '%'||#{lable}||'%'</if>" +
            " )a where a.rn &gt; #{start} </script>")
    List<Map> getPowers(Map map);
    /**
     * 查询分页总数量
     * @return
     */
    @Select("<script> select count(*) from tb_treememu <where>" +
            "<if test=\"lable!=null and lable!=''\"> and lable like '%'||#{lable}||'%'</if>" +
            " </where></script>")
    int getPageCount(Map map);

    /**
     * 获取父节点列表
     * @return
     */
    @Select("select treeId,lable,treeUrl,treeParent from TB_TREEMEMU where treeParent=0")
    List<Map> getParents();
    /**
     * 添加
     * @param map
     * @return
     */
    @Insert("insert into tb_treememu values(seq_tree_treeid.nextval,#{LABLE},#{TREEURL},#{TREEPARENT})")
    int add(Map map);
    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from tb_treememu where treeId=#{TREEID}")
    int delete(int id);
    /**
     * 批量删除
     * @param list
     * @return
     */
    @Delete("<script>delete from tb_treememu where treeId in " +
            "<foreach collection='list' item='id' open='(' close=')' separator=','>#{id}</foreach>" +
            "</script>")
    int batchDelete(List list);
    /**
     * 修改前台信息
     * @param map
     * @return
     */
    @Update("update tb_treememu set lable=#{LABLE},treeurl=#{TREEURL},treeparent=#{TREEPARENT} where treeId=#{TREEID}")
    int update(Map map);
}
