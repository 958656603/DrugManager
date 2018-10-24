package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SaleDrug;
import com.bean.Warehouse;
import com.dao.DrugDao;

@Service
@Transactional
public class SaleDrugServiceImpl implements SaleDrugService {

	@Resource
	private DrugDao drugDao;
	
	
	@Override
	public List<SaleDrug> queryAllSaleDrug() {
		
		return drugDao.queryAllSaleDrug();
	}

	@Override
	public boolean addSaleDrug(String customer_id, String drug_id,
			Integer sale_number, String date, Double price) {
		
		Warehouse warehouse = drugDao.findWareByDrugId(drug_id);
		if(warehouse.getStock_number()>sale_number){
			SaleDrug saleDrug = new SaleDrug();
			saleDrug.setCustomer_id(customer_id);
			saleDrug.setDate(date);
			saleDrug.setDrug_id(drug_id);
			saleDrug.setPrice(price);
			saleDrug.setSale_number(sale_number);
			Integer ware = warehouse.getStock_number();
			warehouse.setStock_number(ware-sale_number);
			drugDao.addSaleDrug(saleDrug);
			drugDao.editWarehouse(warehouse);
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean editSaleDrug(String drugid,Integer saleNum, Integer id, String customer_id, String drug_id,
			Integer sale_number, String date, Double price) {
		Warehouse warehouse = drugDao.findWareByDrugId(drugid);
		SaleDrug saleDrug = new SaleDrug();
		saleDrug.setCustomer_id(customer_id);
		saleDrug.setDate(date);
		saleDrug.setDrug_id(drug_id);
		saleDrug.setId(id);
		saleDrug.setPrice(price);
		saleDrug.setSale_number(sale_number);
		Integer ware = warehouse.getStock_number();
		if(drugid.equals(drug_id)){
			
			warehouse.setStock_number(ware+saleNum-sale_number);
			drugDao.editWarehouse(warehouse);
			drugDao.editSaleDrug(saleDrug);
			return true;
		}else{
			warehouse.setStock_number(ware+saleNum);
			drugDao.editWarehouse(warehouse);
			Warehouse warehouse2 = drugDao.findWareByDrugId(drug_id);
			Integer ware2 = warehouse2.getStock_number();
			
			if(warehouse2.getStock_number()>sale_number){
			
				warehouse2.setStock_number(ware2-sale_number);
				drugDao.editWarehouse(warehouse2);
				drugDao.editSaleDrug(saleDrug);
				return true;
			}else{
				return false;
			}
		}
		
	}
	
	
	public void delSale(String drug_id,Integer sale_number,Integer id){
		Warehouse warehouse = drugDao.findWareByDrugId(drug_id);
		Integer ware = warehouse.getStock_number();
		warehouse.setStock_number(ware+sale_number);
		drugDao.editWarehouse(warehouse);
		drugDao.delSale(id);
	}
	

	public DrugDao getDrugDao() {
		return drugDao;
	}


	public void setDrugDao(DrugDao drugDao) {
		this.drugDao = drugDao;
	}

	@Override
	public List<SaleDrug> querySaleByCondition(String drug_id, String date) {
		SaleDrug saleDrug = new SaleDrug();
		saleDrug.setDrug_id(drug_id);
		saleDrug.setDate(date);
		return drugDao.querySaleByCondition(saleDrug);
	
		
	}

	

	
	
	

}
