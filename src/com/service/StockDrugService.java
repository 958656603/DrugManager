package com.service;

import java.util.List;

import com.bean.StockDrug;

public interface StockDrugService {
	public List<StockDrug> queryAllStockDrug();
	public void addStockDrug(String bill_id,String drug_id,Double price,Integer buy_num,String date,String supplier);
	public void editStockDrug (Integer buyNum,String drugid,Integer id,String bill_id,String drug_id,Double price,Integer buy_num,String date,String supplier);
	public List<StockDrug> queryStockByCondition(String drug_id,String date,String supplier);
}
