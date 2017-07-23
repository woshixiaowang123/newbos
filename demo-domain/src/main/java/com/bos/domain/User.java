package com.bos.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private Dept dept;
	private String userName;
	private String password;
	private Integer state;
	private String createBy;
	private String createDept;
	private Timestamp createTime;
	private String updateBy;
	private Timestamp updateTime;
	private Set<Role> roles = new HashSet(0);
	private Set<UserInfo> userInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId, Timestamp createTime, Timestamp updateTime) {
		this.userId = userId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public User(String userId, Dept dept, String userName, String password, Integer state, String createBy,
			String createDept, Timestamp createTime, String updateBy, Timestamp updateTime, Set roles, Set userInfos) {
		this.userId = userId;
		this.dept = dept;
		this.userName = userName;
		this.password = password;
		this.state = state;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.roles = roles;
		this.userInfos = userInfos;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public Set getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set userInfos) {
		this.userInfos = userInfos;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", dept=" + dept +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", state=" + state +
				", createBy='" + createBy + '\'' +
				", createDept='" + createDept + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				", roles=" + roles +
				", userInfos=" + userInfos +
				'}';
	}
}