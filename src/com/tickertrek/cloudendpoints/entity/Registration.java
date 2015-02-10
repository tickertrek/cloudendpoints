package com.tickertrek.cloudendpoints.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Registration extends BaseEntity{
	String email;
    String fullname;
    String password;
    String userName;
    String code;
    Date createDate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String nickname) {
		this.userName = nickname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createdate) {
		this.createDate = createdate;
	}
}
