package com.codechallenge.ccm.vo;

public class CCMMaxProfitVo {
	private String code;
	private String buyValue;
	private String buyTime;
	private String sellValue;
	private String sellTime;
	private String maxProfit;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBuyValue() {
		return buyValue;
	}
	public void setBuyValue(String buyValue) {
		this.buyValue = buyValue;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public String getSellValue() {
		return sellValue;
	}
	public void setSellValue(String sellValue) {
		this.sellValue = sellValue;
	}
	public String getSellTime() {
		return sellTime;
	}
	public void setSellTime(String sellTime) {
		this.sellTime = sellTime;
	}
	public String getMaxProfit() {
		return maxProfit;
	}
	public void setMaxProfit(String maxProfit) {
		this.maxProfit = maxProfit;
	}
}