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
	   
    private String  fullname;
    private String  nickname;
    private String  email;
    private String  contactemail;
    private String  assetclass;
    private String  style;
    private String  holdingperiod;
    private String  experience;
    private String  aboutme;
    private String  profession;    
    private Integer championship;
    private Key following;
    private Key followers;
    private Integer sitescore;
    private Integer userrating;
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactemail() {
		return contactemail;
	}
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}
	public String getAssetclass() {
		return assetclass;
	}
	public void setAssetclass(String assetclass) {
		this.assetclass = assetclass;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getHoldingperiod() {
		return holdingperiod;
	}
	public void setHoldingperiod(String holdingperiod) {
		this.holdingperiod = holdingperiod;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
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
	public Integer getUserrating() {
		return userrating;
	}
	public void setUserrating(Integer userrating) {
		this.userrating = userrating;
	}
}
