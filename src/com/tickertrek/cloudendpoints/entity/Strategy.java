package com.tickertrek.cloudendpoints.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Strategy {	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key key;
  
  private Key  userkey;
  private String  strategyname;
  private String  type;
  private String  listingtype;
  private Double  initialbalance;
  private String  currency;
  private String  instrumentoptions;
  private String  description;
  private String  market;
  private Date    startdate;
  private Integer  ordercount;
  private Integer  tradecount;
  private Integer  profittradecount;
  private Integer  loosingtradecount;
  private Double  profitfactor;
  private Double  annualreturn;
  private Double  overallreturn;
  private Double  ytdreturn;
  private Double  _3mreturn;
  private Double  maxdrawdown;
  private Integer  sitescore;
  private Double  avgwin;
  private Double  avgloss;
  private Integer  viewtimes;
  private Integer age;
  private Double  power;
  private Double  balance;
  private Key  followers;
  private Double  fee;
  private Integer freetrial;
  private Double  brokeragefee;
  private String  brokeragefeetype;
  private String  href;
  private Double  totalvalue;
  private Double  equity;
  private Double  grossgain;
  private Double  grossloss;
public Key getKey() {
	return key;
}
public void setKey(Key key) {
	this.key = key;
}
public Key getUserkey() {
	return userkey;
}
public void setUserkey(Key userkey) {
	this.userkey = userkey;
}
public String getStrategyname() {
	return strategyname;
}
public void setStrategyname(String strategyname) {
	this.strategyname = strategyname;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getListingtype() {
	return listingtype;
}
public void setListingtype(String listingtype) {
	this.listingtype = listingtype;
}
public Double getInitialbalance() {
	return initialbalance;
}
public void setInitialbalance(Double initialbalance) {
	this.initialbalance = initialbalance;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public String getInstrumentoptions() {
	return instrumentoptions;
}
public void setInstrumentoptions(String instrumentoptions) {
	this.instrumentoptions = instrumentoptions;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getMarket() {
	return market;
}
public void setMarket(String market) {
	this.market = market;
}
public Date getStartdate() {
	return startdate;
}
public void setStartdate(Date startdate) {
	this.startdate = startdate;
}
public Integer getOrdercount() {
	return ordercount;
}
public void setOrdercount(Integer ordercount) {
	this.ordercount = ordercount;
}
public Integer getTradecount() {
	return tradecount;
}
public void setTradecount(Integer tradecount) {
	this.tradecount = tradecount;
}
public Integer getProfittradecount() {
	return profittradecount;
}
public void setProfittradecount(Integer profittradecount) {
	this.profittradecount = profittradecount;
}
public Integer getLoosingtradecount() {
	return loosingtradecount;
}
public void setLoosingtradecount(Integer loosingtradecount) {
	this.loosingtradecount = loosingtradecount;
}
public Double getProfitfactor() {
	return profitfactor;
}
public void setProfitfactor(Double profitfactor) {
	this.profitfactor = profitfactor;
}
public Double getAnnualreturn() {
	return annualreturn;
}
public void setAnnualreturn(Double annualreturn) {
	this.annualreturn = annualreturn;
}
public Double getOverallreturn() {
	return overallreturn;
}
public void setOverallreturn(Double overallreturn) {
	this.overallreturn = overallreturn;
}
public Double getYtdreturn() {
	return ytdreturn;
}
public void setYtdreturn(Double ytdreturn) {
	this.ytdreturn = ytdreturn;
}
public Double get_3mreturn() {
	return _3mreturn;
}
public void set_3mreturn(Double _3mreturn) {
	this._3mreturn = _3mreturn;
}
public Double getMaxdrawdown() {
	return maxdrawdown;
}
public void setMaxdrawdown(Double maxdrawdown) {
	this.maxdrawdown = maxdrawdown;
}
public Integer getSitescore() {
	return sitescore;
}
public void setSitescore(Integer sitescore) {
	this.sitescore = sitescore;
}
public Double getAvgwin() {
	return avgwin;
}
public void setAvgwin(Double avgwin) {
	this.avgwin = avgwin;
}
public Double getAvgloss() {
	return avgloss;
}
public void setAvgloss(Double avgloss) {
	this.avgloss = avgloss;
}
public Integer getViewtimes() {
	return viewtimes;
}
public void setViewtimes(Integer viewtimes) {
	this.viewtimes = viewtimes;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public Double getPower() {
	return power;
}
public void setPower(Double power) {
	this.power = power;
}
public Double getBalance() {
	return balance;
}
public void setBalance(Double balance) {
	this.balance = balance;
}
public Key getFollowers() {
	return followers;
}
public void setFollowers(Key followers) {
	this.followers = followers;
}
public Double getFee() {
	return fee;
}
public void setFee(Double fee) {
	this.fee = fee;
}
public Integer getFreetrial() {
	return freetrial;
}
public void setFreetrial(Integer freetrial) {
	this.freetrial = freetrial;
}
public Double getBrokeragefee() {
	return brokeragefee;
}
public void setBrokeragefee(Double brokeragefee) {
	this.brokeragefee = brokeragefee;
}
public String getBrokeragefeetype() {
	return brokeragefeetype;
}
public void setBrokeragefeetype(String brokeragefeetype) {
	this.brokeragefeetype = brokeragefeetype;
}
public String getHref() {
	return href;
}
public void setHref(String href) {
	this.href = href;
}
public Double getTotalvalue() {
	return totalvalue;
}
public void setTotalvalue(Double totalvalue) {
	this.totalvalue = totalvalue;
}
public Double getEquity() {
	return equity;
}
public void setEquity(Double equity) {
	this.equity = equity;
}
public Double getGrossgain() {
	return grossgain;
}
public void setGrossgain(Double grossgain) {
	this.grossgain = grossgain;
}
public Double getGrossloss() {
	return grossloss;
}
public void setGrossloss(Double grossloss) {
	this.grossloss = grossloss;
}
}
