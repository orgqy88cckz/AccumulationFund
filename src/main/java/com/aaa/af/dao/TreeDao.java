package com.aaa.af.dao;

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
    @Select("select * from TB_TREEMEMU")
    public List<Map> getListTree();
}
