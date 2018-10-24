package com.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Warehouse;
import com.dao.DrugDao;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {
	
	@Resource
	private DrugDao drugDao;
	
	@Override
	public void editWarehouse(Integer id,String drug_id,Integer stock_number,String manufacturer,String standard,Double sale_price) throws UnsupportedEncodingException {
		
		Warehouse warehouse = new Warehouse();
		warehouse.setDrug_id(drug_id);
		warehouse.setId(id);
		warehouse.setManufacturer(manufacturer);
		warehouse.setSale_price(sale_price);
		warehouse.setStandard(standard);
		warehouse.setStock_number(stock_number);
		
		
		drugDao.editWarehouse(warehouse);

	}
	
	@Override
	public void addWarehouse(String drug_id,Integer stock_number,String manufacturer,String standard,Double sale_price) throws UnsupportedEncodingException {
		
		Warehouse warehouse = new Warehouse();
		warehouse.setDrug_id(drug_id);
		warehouse.setManufacturer(manufacturer);
		warehouse.setSale_price(sale_price);
		warehouse.setStandard(standard);
		warehouse.setStock_number(stock_number);
		
		
		drugDao.addWarehouse(warehouse);

	}
	
	public List<Warehouse> queryWareByCondition(String drug_id){
		Warehouse warehouse = new Warehouse();
		warehouse.setDrug_id(drug_id);
		return drugDao.queryWareByCondition(warehouse);
	}
	
	public List<Warehouse> queryAllWareDrug(){
		return drugDao.queryAllWareDrug();
	}
	

	public DrugDao getDrugDao() {
		return drugDao;
	}

	public void setDrugDao(DrugDao drugDao) {
		this.drugDao = drugDao;
	}

	
	
}
