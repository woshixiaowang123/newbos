package com.bos.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Module entity. @author MyEclipse Persistence Tools
 */

public class Module implements java.io.Serializable {

	// Fields

	private String moduleId;
	private String parentId;
	private String parentName;
	private String name;
	private Integer layerNum;
	private Integer isLeaf;
	private String ico;
	private String cpermission;
	private String curl;
	private Integer ctype;
	private Integer state;
	private String belong;
	private String cwhich;
	private Integer quoteNum;
	private String remark;
	private Integer orderNo;
	private String createBy;
	private String createDept;
	private Timestamp createTime;
	private String updateBy;
	private Timestamp updateTime;
	private Set<Role> roles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** minimal constructor */
	public Module(String moduleId, Timestamp createTime, Timestamp updateTime) {
		this.moduleId = moduleId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Module(String moduleId, String parentId, String parentName, String name, Integer layerNum, Integer isLeaf,
			String ico, String cpermission, String curl, Integer ctype, Integer state, String belong, String cwhich,
			Integer quoteNum, String remark, Integer orderNo, String createBy, String createDept, Timestamp createTime,
			String updateBy, Timestamp updateTime, Set roles) {
		this.moduleId = moduleId;
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

	// Property accessors

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLayerNum() {
		return this.layerNum;
	}

	public void setLayerNum(Integer layerNum) {
		this.layerNum = layerNum;
	}

	public Integer getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getIco() {
		return this.ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getCpermission() {
		return this.cpermission;
	}

	public void setCpermission(String cpermission) {
		this.cpermission = cpermission;
	}

	public String getCurl() {
		return this.curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	public Integer getCtype() {
		return this.ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getBelong() {
		return this.belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getCwhich() {
		return this.cwhich;
	}

	public void setCwhich(String cwhich) {
		this.cwhich = cwhich;
	}

	public Integer getQuoteNum() {
		return this.quoteNum;
	}

	public void setQuoteNum(Integer quoteNum) {
		this.quoteNum = quoteNum;
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

	public Set getRoles() {
		return this.roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Module{" +
				"moduleId='" + moduleId + '\'' +
				", parentId='" + parentId + '\'' +
				", parentName='" + parentName + '\'' +
				", name='" + name + '\'' +
				", layerNum=" + layerNum +
				", isLeaf=" + isLeaf +
				", ico='" + ico + '\'' +
				", cpermission='" + cpermission + '\'' +
				", curl='" + curl + '\'' +
				", ctype=" + ctype +
				", state=" + state +
				", belong='" + belong + '\'' +
				", cwhich='" + cwhich + '\'' +
				", quoteNum=" + quoteNum +
				", remark='" + remark + '\'' +
				", orderNo=" + orderNo +
				", createBy='" + createBy + '\'' +
				", createDept='" + createDept + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				", roles=" + roles +
				'}';
	}
}