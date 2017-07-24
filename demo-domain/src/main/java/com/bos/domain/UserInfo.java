package com.bos.domain;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo extends BaseEntity{

	// Fields

	private String id;
	private User user;//直属领导  多对一
	private String name;//姓名
	private Date joinDate;//入职时间
	private Double salary;//薪水
	private Date birthday;//出生日期
	private String gender;//性别
	private String station;//岗位
	private String telephone;//电话
	private Integer degree;//等级
	private String remark;//说明
	private Integer orderNo;//排序号

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	public UserInfo(String userInfoId, User user, String name, Date joinDate, Double salary, Date birthday, String gender, String station, String telephone, Integer degree, String remark, Integer orderNo, String createBy, String createDept, Date createTime, String updateBy, Date updateTime) {
		this.id = userInfoId;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
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

	@Override
	public String toString() {
		return "UserInfo{" +
				"id='" + id + '\'' +
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