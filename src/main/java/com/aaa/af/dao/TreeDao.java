package com.aaa.af.dao;

import com.aaa.af.entity.Children;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:TreeDao
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-08 16:11
 */
public interface TreeDao {
    /**
     * 查询树节点
     * @return
     */
    @Select("select tr.* from tb_user u left join tb_role r on r.roleid=u.roleid left join tb_middle m on m.roleId =r.roleId left join tb_treememu tr on tr.treeId=m.treeId where u.name=#{param1}")
    List<Children> getListTree(String username);
    /**
     * 查询全部树节点
     * @return
     */
    @Select("select treeId,lable,treeUrl,treeParent from TB_TREEMEMU")
    List<Children> getListAllTree();
}

