package com.bean;

public class Warehouse {
	/*	id				int			主键
		drug_id			varchar		药品编码
		stock_number	int			库存量
		manufacturer	varchar		生产厂家
		standard		archar		规格
		sale_price		double		零售价*/
	/*
	 * 给相应记录设置生产厂家、规格、零售价等信息
	 * 。不能修改药品编码、库存量。
	 */
	private Integer id;
	private String drug_id;
	private Integer stock_number;
	private String manufacturer;
	private String standard;
	private Double sale_price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(String drug_id) {
		this.drug_id = drug_id;
	}
	public Integer getStock_number() {
		return stock_number;
	}
	public void setStock_number(Integer stock_number) {
		this.stock_number = stock_number;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Double getSale_price() {
		return sale_price;
	}
	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}
}
