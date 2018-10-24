package com.bean;

public class StockDrug {
	/**
	 * 	id			int		主键
		bill_id		varchar	单据号
		drug_id		varchar	药品编码
		price		double	采购价
		buy_num		int		采购数量
		date		varchar	采购日期
		supplier	varchar	供应商
	 */
	
	private Integer id;
	private String bill_id;
	private String drug_id;
	private Double price;
	private Integer buy_num;
	private String date;
	private String supplier;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBill_id() {
		return bill_id;
	}
	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}
	public String getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(String drug_id) {
		this.drug_id = drug_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(Integer buy_num) {
		this.buy_num = buy_num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}
