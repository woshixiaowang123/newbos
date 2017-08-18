package com.bos.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Module entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "module_p", schema = "new_bos")
public class Module implements java.io.Serializable {

	// Fields

	private String id;
	private String parentId;//自关联,子模块,父模块
	private String parentName; //父模块名称
	private String name;//模块名
	private Integer layerNum;//层数
	private Integer isLeaf;//叶子
	private String ico;//图片
	private String cpermission;//权限
	private String curl;//路径
	private Integer ctype;//菜单类型
	private Integer state;//状态
	private String belong;//从属于
	private String cwhich;
	private Integer quoteNum;//引用次数
	private String remark;//说明
	private Integer orderNo;//排序编号
	private String createBy;
	private String createDept;
	private Date createTime;
	private String updateBy;
	private Date updateTime;
	private Set<Role> roles = new HashSet(0);//模块与角色的多对多关系

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** minimal constructor */
	public Module(String moduleId, Date createTime, Date updateTime) {
		this.id = moduleId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Module(String id, String parentId, String parentName, String name, Integer layerNum, Integer isLeaf, String ico, String cpermission, String curl, Integer ctype, Integer state, String belong, String cwhich, Integer quoteNum, String remark, Integer orderNo, String createBy, String createDept, Date createTime, String updateBy, Date updateTime, Set<Role> roles) {
		this.id = id;
		this.parentId = parentId;
		this.parentName = parentName;
		this.name = name;
		this.layerNum = layerNum;
		this.isLeaf = isLeaf;
		this.ico = ico;
		this.cpermission = cpermission;
		this.curl = curl;
		this.ctype = ctype;
		this.state = state;
		this.belong = belong;
		this.cwhich = cwhich;
		this.quoteNum = quoteNum;
		this.remark = remark;
		this.orderNo = orderNo;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLayerNum() {
		return layerNum;
	}

	public void setLayerNum(Integer layerNum) {
		this.layerNum = layerNum;
	}

	public Integer getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getCpermission() {
		return cpermission;
	}

	public void setCpermission(String cpermission) {
		this.cpermission = cpermission;
	}

	public String getCurl() {
		return curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getCwhich() {
		return cwhich;
	}

	public void setCwhich(String cwhich) {
		this.cwhich = cwhich;
	}

	public Integer getQuoteNum() {
		return quoteNum;
	}

	public void setQuoteNum(Integer quoteNum) {
		this.quoteNum = quoteNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}