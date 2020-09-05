package com.wellsfargo.stockmarket.stockdataretrieval.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="companystockprice")
public class Stock {
	@Id
	@Column(name="companystockpriceid")
	private int stockId;
	@Column(name="companycode")
	private int companyCode;
	@Column(name="currentprice")
	private double currentPrice;
	@Column(name="stockpricedate")
	private String date;
	
	public Stock() {
		
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
