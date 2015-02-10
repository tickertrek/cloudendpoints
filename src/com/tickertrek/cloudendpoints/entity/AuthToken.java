package com.tickertrek.cloudendpoints.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class AuthToken extends BaseEntity {
	String email;
    String userName;
    String userToken;
    String originalToken;
    String tokenType;
    Date createDate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getOriginalToken() {
		return originalToken;
	}
	public void setOriginalToken(String originalToken) {
		this.originalToken = originalToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
