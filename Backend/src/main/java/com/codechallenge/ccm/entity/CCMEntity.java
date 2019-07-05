package com.codechallenge.ccm.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CCMDETAILS")
public class CCMEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String currency;
	private LocalDate tradeDate;
	private LocalTime tradeTime;
	private double price;
			
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getPrice() {
		return price;
	}
	public LocalDate getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}
	public LocalTime getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(LocalTime tradeTime) {
		this.tradeTime = tradeTime;
	}
	public void setPrice(double price) {
		this.price = price;
	}	

}
