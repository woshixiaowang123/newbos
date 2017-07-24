package com.bos.domain;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体类
 * Created by 隔壁老王 on 2017/7/11.
 */
@Entity
public class Dept implements Serializable {

    private String id;
    private String deptname;
    private Dept parent;//自关联'
    private Integer state;//1启用0停用
    private Integer orderno;//排序的编码
    private Set<User> users = new HashSet<User>(0);

    public Dept() {
    }

    public Dept(String id, String deptname, Dept parent, Integer state, Integer orderno, Set<User> users) {
        this.id = id;
        this.deptname = deptname;
        this.parent = parent;
        this.state = state;
        this.orderno = orderno;
        this.users = users;
    }

    @javax.persistence.Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", deptname='" + deptname + '\'' +
                ", parent=" + parent +
                ", state=" + state +
                ", orderno=" + orderno +
                ", users=" + users +
                '}';
    }
}
