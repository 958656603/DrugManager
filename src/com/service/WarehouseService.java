package com.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.bean.Warehouse;


public interface WarehouseService {
	public void editWarehouse(Integer id,String drug_id,Integer stock_number,String manufacturer,String standard,Double sale_price) throws UnsupportedEncodingException;
	public List<Warehouse> queryAllWareDrug();
	public void addWarehouse(String drug_id, Integer stock_number,String manufacturer,String standard,Double sale_price) throws UnsupportedEncodingException;
	public List<Warehouse> queryWareByCondition(String drug_id);
}
