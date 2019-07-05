package com.codechallenge.ccm.vo;

import java.time.LocalDate;
import java.util.List;

public class CCMVo {
	
	private String currency;	
	private LocalDate tradeDate;
	List<CCMDetailVo> quotes;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public LocalDate getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}
	public List<CCMDetailVo> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<CCMDetailVo> quotes) {
		this.quotes = quotes;
	}								

}
