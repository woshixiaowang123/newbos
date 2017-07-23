package com.bos.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

    // Fields

    private String roleId;
    private String name;
    private String remark;
    private Integer orderNo;
    private String createBy;
    private String createDept;
    private Timestamp createTime;
    private String updateBy;
    private Timestamp updateTime;
    private Set<Module> modules = new HashSet(0);
    private Set<User> users = new HashSet(0);

    // Constructors

    /**
     * default constructor
     */
    public Role() {
    }

    /**
     * minimal constructor
     */
    public Role(String roleId, Timestamp createTime, Timestamp updateTime) {
        this.roleId = roleId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * full constructor
     */
    public Role(String roleId, String name, String remark, Integer orderNo, String createBy, String createDept,
                Timestamp createTime, String updateBy, Timestamp updateTime, Set modules, Set users) {
        this.roleId = roleId;
        this.name = name;
        this.remark = remark;
        this.orderNo = orderNo;
        this.createBy = createBy;
        this.createDept = createDept;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.modules = modules;
        this.users = users;
    }

    // Property accessors

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDept() {
        return this.createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Set getModules() {
        return this.modules;
    }

    public void setModules(Set modules) {
        this.modules = modules;
    }

    public Set getUsers() {
        return this.users;
    }

    public void setUsers(Set users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", orderNo=" + orderNo +
                ", createBy='" + createBy + '\'' +
                ", createDept='" + createDept + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", modules=" + modules +
                ", users=" + users +
                '}';
    }
}