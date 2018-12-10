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
    public List<Children> getListTree() {
        List<Map> listTree = treeDao.getListTree();
        System.out.println(listTree);
        //定义返回列表
        List<Children> powerList = new ArrayList<>();
        //判断是否为空
        if(listTree!=null&&listTree.size()>0){
            Children treeNode = null;
            //循环遍历，构造TreeNode对象，加入powerList
            for(Map powerMap : listTree){
                // treeNode = new TreeNode(id, text, parentId, state, iconCls, url);
                treeNode = new Children(Integer.valueOf(powerMap.get("TREEID")+""), powerMap.get("LABLE")+"",
                        Integer.valueOf(powerMap.get("TREEPARENT")+""), powerMap.get("TREEURL")+"");
                powerList.add(treeNode);
            }
        }
        System.out.println(powerList.get(0).getLable());
        //临时的powerList
        List<Children> powerTempList = new ArrayList<Children>();
        //判断是否为空
        if(powerList!=null&&powerList.size()>0){
            for(Children ptreeNode:powerList){
                if(ptreeNode.getTreeParent()==0){//如果等于0,说明是一级节点
                    powerTempList.add(ptreeNode);
                    //递归绑定子节点
                    bindChirldren(ptreeNode,powerList);
                }
            }
        }
        return powerTempList;
    }
    /**
     * 递归绑定所有子节点
     * @param parentTreeNode
     * @param powerAllList
     */
    private  void bindChirldren(Children parentTreeNode,List<Children> powerAllList ){
        for(Children chirldrenTreeNode:powerAllList){
            if(parentTreeNode.getTreeId()==chirldrenTreeNode.getTreeParent()){
                //获取当前节点的所有子节点集合
                List<Children> children = parentTreeNode.getChildren();
                if(children==null){//如果孩子节点为空,
                    List<Children> childrenTempList = new ArrayList<Children>();//实例化孩子集合
                    childrenTempList.add(chirldrenTreeNode);//添加子节点到集合里面
                    parentTreeNode.setChildren(childrenTempList);//设置孩子集合
                }else{//不空，说明设置过
                    children.add(chirldrenTreeNode);//添加子节点到集合里面
                }
                //自己调用自己,找孩子
                bindChirldren(chirldrenTreeNode,powerAllList);
            }
        }
    }
}

