package com.aaa.af.service;

import com.aaa.af.dao.TreeDao;
import com.aaa.af.entity.Children;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:TreeServiceImpl
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-08 16:12
 */
@SuppressWarnings("all")
@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeDao treeDao;

    @Override
    public List<Children> getListTree(String username) {
        List<Children> list = treeDao.getListTree(username);
        //拼装后的临时集合,用于返回数据
        List<Children> tempList = new ArrayList<Children>();
        if(list!=null&&list.size()>0){
            for (Children node : list) {
                //找出父节点为0的一级节点
                if(node.getTreeParent()==0){
                    tempList.add(node);
                    //调用递归方法，找当前节点的子节点
                    bindChildren(node,list);
                }
            }
        }
        return tempList;
    }

    @Override
    public List<Children> getListAllTree() {
        List<Children> list = treeDao.getListAllTree();
        //拼装后的临时集合,用于返回数据
        List<Children> tempList = new ArrayList<Children>();
        if(list!=null&&list.size()>0){
            for (Children node : list) {
                //找出父节点为0的一级节点
                if(node.getTreeParent()==0){
                    tempList.add(node);
                    //调用递归方法，找当前节点的子节点
                    bindChildren(node,list);
                }
            }
        }
        return tempList;
    }

    /**
     * 递归绑定子节点
     * @param curNode
     * @param list
     */
    private void bindChildren(Children curNode,List<Children> list){
        for (Children node : list) {
            //如果当前节点的id和循环节点的父id相等，说明是当前节点的孩子
            if (curNode.getTreeId()==node.getTreeParent()){
                //取出当前节点的孩子集合
                List<Children> children = curNode.getChildren();
                //如果是没有孩子，孩子集合第一次取出时空的
                if(children==null){
                    children=new ArrayList<Children>();
                }
                children.add(node);
                //设置当前孩子集合
                curNode.setChildren(children);
                //自己调用自己，找孩子
                bindChildren(node,list);
            }
        }
    }
}

