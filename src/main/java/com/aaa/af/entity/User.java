package com.aaa.af.entity;

/**
 * className:User
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-01 14:54
 */
public class User {
    private Integer userId;
    private String name;
    private String password;
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
