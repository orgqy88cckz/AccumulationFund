package com.aaa.af.service;

import com.aaa.af.entity.Children;

import java.util.List;
import java.util.Map;

/**
 * className:TreeService
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-08 16:12
 */
public interface TreeService {
    /**
     * 查询树节点
     * @return
     */
    public List<Children> getListTree(String username);
    /**
     * 查询全部树节点
     * @return
     */
    public List<Children> getListAllTree();
}
