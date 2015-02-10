package com.tickertrek.cloudendpoints.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	   
    private String  fullName;
    private String  userName;
    private String  email;
    private String  contactEmail;
    private String  assetClass;
    private String  style;
    private String  holdingPeriod;
    private String  experience;
    private String  aboutMe;
    private String  profession;    
    private Integer championship;
    private Key following;
    private Key followers;
    private Integer sitescore;
    private Integer userRating;
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullname) {
		this.fullName = fullname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String nickname) {
		this.userName = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactemail) {
		this.contactEmail = contactemail;
	}
	public String getAssetClass() {
		return assetClass;
	}
	public void setAssetClass(String assetclass) {
		this.assetClass = assetclass;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getHoldingPeriod() {
		return holdingPeriod;
	}
	public void setHoldingPeriod(String holdingperiod) {
		this.holdingPeriod = holdingperiod;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutme) {
		this.aboutMe = aboutme;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Integer getChampionship() {
		return championship;
	}
	public void setChampionship(Integer championship) {
		this.championship = championship;
	}
	public Key getFollowing() {
		return following;
	}
	public void setFollowing(Key following) {
		this.following = following;
	}
	public Key getFollowers() {
		return followers;
	}
	public void setFollowers(Key followers) {
		this.followers = followers;
	}
	public Integer getSitescore() {
		return sitescore;
	}
	public void setSitescore(Integer sitescore) {
		this.sitescore = sitescore;
	}
	public Integer getUserRating() {
		return userRating;
	}
	public void setUserRating(Integer userrating) {
		this.userRating = userrating;
	}
}
