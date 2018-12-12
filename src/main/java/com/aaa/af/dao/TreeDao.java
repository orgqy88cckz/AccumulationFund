package com.aaa.af.dao;

import com.aaa.af.entity.Children;
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
    @Select("select treeId,lable,treeUrl,treeParent from TB_TREEMEMU")
    List<Children> getListTree();

}
