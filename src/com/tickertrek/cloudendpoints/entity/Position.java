package com.tickertrek.cloudendpoints.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
    private Key  strategykey;
    private String  exchange;
    private String  symbol;
    private Integer  quantity;
    private Date  opendate;
    private Double  adjcost;
    private Double  adjcostpershare;
    private String  openordertype;
    private Date  closedate;
    private Double  closepricepershare;
    private Double  adjproceeds;
    private String  closeordertype;
    private Double  adjgain;
    private Double  adjgainpercentage;
    private String  positiontype;
    private String  term;
    private Double lastprice;
    private Double marketvalue;
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public Key getStrategykey() {
		return strategykey;
	}
	public void setStrategykey(Key strategykey) {
		this.strategykey = strategykey;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public Double getAdjcost() {
		return adjcost;
	}
	public void setAdjcost(Double adjcost) {
		this.adjcost = adjcost;
	}
	public Double getAdjcostpershare() {
		return adjcostpershare;
	}
	public void setAdjcostpershare(Double adjcostpershare) {
		this.adjcostpershare = adjcostpershare;
	}
	public String getOpenordertype() {
		return openordertype;
	}
	public void setOpenordertype(String openordertype) {
		this.openordertype = openordertype;
	}
	public Date getClosedate() {
		return closedate;
	}
	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}
	public Double getClosepricepershare() {
		return closepricepershare;
	}
	public void setClosepricepershare(Double closepricepershare) {
		this.closepricepershare = closepricepershare;
	}
	public Double getAdjproceeds() {
		return adjproceeds;
	}
	public void setAdjproceeds(Double adjproceeds) {
		this.adjproceeds = adjproceeds;
	}
	public String getCloseordertype() {
		return closeordertype;
	}
	public void setCloseordertype(String closeordertype) {
		this.closeordertype = closeordertype;
	}
	public Double getAdjgain() {
		return adjgain;
	}
	public void setAdjgain(Double adjgain) {
		this.adjgain = adjgain;
	}
	public Double getAdjgainpercentage() {
		return adjgainpercentage;
	}
	public void setAdjgainpercentage(Double adjgainpercentage) {
		this.adjgainpercentage = adjgainpercentage;
	}
	public String getPositiontype() {
		return positiontype;
	}
	public void setPositiontype(String positiontype) {
		this.positiontype = positiontype;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public Double getLastprice() {
		return lastprice;
	}
	public void setLastprice(Double lastprice) {
		this.lastprice = lastprice;
	}
	public Double getMarketvalue() {
		return marketvalue;
	}
	public void setMarketvalue(Double marketvalue) {
		this.marketvalue = marketvalue;
	}
}
