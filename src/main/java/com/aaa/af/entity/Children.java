package com.aaa.af.entity;

import java.util.List;

/**
 * className:Children
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-08 18:37
 */
public class Children {

    private Integer treeId;
    private String lable;
    private Integer treeParent;
    private String treeUrl;
    private String checked;
    private List<Children> children;

    public Children(Integer treeId, String lable, Integer treeParent, String treeUrl, String checked) {
        this.treeId = treeId;
        this.lable = lable;
        this.treeParent = treeParent;
        this.treeUrl = treeUrl;
        this.checked = checked;
    }

    public Children(Integer treeId, String lable, Integer treeParent, String treeUrl) {
        this.treeId = treeId;
        this.lable = lable;
        this.treeParent = treeParent;
        this.treeUrl = treeUrl;
    }

    public Children() {
    }

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Integer getTreeParent() {
        return treeParent;
    }

    public void setTreeParent(Integer treeParent) {
        this.treeParent = treeParent;
    }

    public String getTreeUrl() {
        return treeUrl;
    }

    public void setTreeUrl(String treeUrl) {
        this.treeUrl = treeUrl;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
