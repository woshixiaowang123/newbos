package com.bos.domain;

import javax.persistence.Entity;
import java.io.Serializable;

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

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", deptname='" + deptname + '\'' +
                ", parent=" + parent +
                ", state=" + state +
                '}';
    }
}
