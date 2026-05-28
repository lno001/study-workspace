package com.kh.study.member.model.dto;

import java.sql.Date;

public class MemberDto {
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	public MemberDto() {
		super();
	}
	public MemberDto(String userId, String userPwd, String userName, String email, Date enrollDate, Date modifyDate,
			String status) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	
}
