package com.bos.domain;

import java.sql.Timestamp;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private String userInfoId;
	private User user;
	private String name;
	private Timestamp joinDate;
	private Double salary;
	private Timestamp birthday;
	private String gender;
	private String station;
	private String telephone;
	private Integer degree;
	private String remark;
	private Integer orderNo;
	private String createBy;
	private String createDept;
	private Timestamp createTime;
	private String updateBy;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userInfoId, Timestamp joinDate, Timestamp birthday, Timestamp createTime,
			Timestamp updateTime) {
		this.userInfoId = userInfoId;
		this.joinDate = joinDate;
		this.birthday = birthday;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public UserInfo(String userInfoId, User user, String name, Timestamp joinDate, Double salary, Timestamp birthday,
			String gender, String station, String telephone, Integer degree, String remark, Integer orderNo,
			String createBy, String createDept, Timestamp createTime, String updateBy, Timestamp updateTime) {
		this.userInfoId = userInfoId;
		this.user = user;
		this.name = name;
		this.joinDate = joinDate;
		this.salary = salary;
		this.birthday = birthday;
		this.gender = gender;
		this.station = station;
		this.telephone = telephone;
		this.degree = degree;
		this.remark = remark;
		this.orderNo = orderNo;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
	}

	// Property accessors

	public String getUserInfoId() {
		return this.userInfoId;
	}

	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getDegree() {
		return this.degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
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

	@Override
	public String toString() {
		return "UserInfo{" +
				"userInfoId='" + userInfoId + '\'' +
				", user=" + user +
				", name='" + name + '\'' +
				", joinDate=" + joinDate +
				", salary=" + salary +
				", birthday=" + birthday +
				", gender='" + gender + '\'' +
				", station='" + station + '\'' +
				", telephone='" + telephone + '\'' +
				", degree=" + degree +
				", remark='" + remark + '\'' +
				", orderNo=" + orderNo +
				", createBy='" + createBy + '\'' +
				", createDept='" + createDept + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				'}';
	}
}