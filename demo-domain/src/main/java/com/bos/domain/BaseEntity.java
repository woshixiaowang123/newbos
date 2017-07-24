package com.bos.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 隔壁老王 on 2017/7/23.
 */
public class BaseEntity implements Serializable {

    protected String createBy;//创建者id
    protected String createDept;//创建部门
    protected Date createTime;//创建时间
    protected String updateBy;//修改者id
    protected Date updateTime;//修改时间

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
