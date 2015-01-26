package com.tickertrek.cloudendpoints.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	private Key  strategykey;
    private String  exchange;
    private String  symbol;
    private String  instrument;
    private String  ordertype;
    private String  pricetype;
    private Integer  quantity;
    private String  term;
    private Double  price;
    private Double  executionprice;
    private Date  initiatetime;
    private Date  executiontime;
    private String  status;
    private String  comment;
    private Double  brokeragefee;
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
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getPricetype() {
		return pricetype;
	}
	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getExecutionprice() {
		return executionprice;
	}
	public void setExecutionprice(Double executionprice) {
		this.executionprice = executionprice;
	}
	public Date getInitiatetime() {
		return initiatetime;
	}
	public void setInitiatetime(Date initiatetime) {
		this.initiatetime = initiatetime;
	}
	public Date getExecutiontime() {
		return executiontime;
	}
	public void setExecutiontime(Date executiontime) {
		this.executiontime = executiontime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Double getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(Double brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
}
