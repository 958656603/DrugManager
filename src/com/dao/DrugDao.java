package com.dao;

import java.util.List;

import com.bean.SaleDrug;
import com.bean.StockDrug;
import com.bean.Warehouse;

public interface DrugDao {
	//以下是库存表操作
	public List<Warehouse> queryAllWareDrug();//查询所有库存药品
	public void editWarehouse(Warehouse warehouse);
	public void addWarehouse(Warehouse warehouse);
	public Warehouse findWareById(Integer id);
	public Warehouse findWareByDrugId(String drug_id);
	
	//以下是进药表操作
	public List<StockDrug> queryAllStockDrug();
	public void addStockDrug(StockDrug stockDrug);
	public void editStockDrug(StockDrug stockDrug);
	
	//进药库存没写查询
	
	//以下是售药表操作
	public List<SaleDrug> queryAllSaleDrug();
	public void addSaleDrug(SaleDrug saleDrug); 
	public void editSaleDrug(SaleDrug saleDrug);
	public void delSale(Integer id);
	
	
	//查询操作
	public List<Warehouse> queryWareByCondition(Warehouse warehouse);
	public List<StockDrug> queryStockByCondition(StockDrug stockDrug);
	public List<SaleDrug> querySaleByCondition(SaleDrug saleDrug);
}
