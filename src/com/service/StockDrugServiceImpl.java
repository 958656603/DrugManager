package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.StockDrug;
import com.bean.Warehouse;
import com.dao.DrugDao;

@Service
@Transactional
public class StockDrugServiceImpl implements StockDrugService {

	@Resource
	private DrugDao drugDao;
	
	
	@Override
	public List<StockDrug> queryAllStockDrug() {//��ѯ����ҩƷ������¼
		return drugDao.queryAllStockDrug();
	}


	@Override
	public void addStockDrug(String bill_id, String drug_id, Double price,
			Integer buy_num, String date, String supplier) {
		Warehouse warehouse = null;
		warehouse = drugDao.findWareByDrugId(drug_id);
		StockDrug stockDrug = new StockDrug();
		stockDrug.setBill_id(bill_id);
		stockDrug.setBuy_num(buy_num);
		stockDrug.setDate(date);
		stockDrug.setDrug_id(drug_id);
		stockDrug.setPrice(price);
		stockDrug.setSupplier(supplier);
		if(warehouse!=null){
			
			
			drugDao.addStockDrug(stockDrug);//�����ҩƷ����ҩƷ��¼�м�һ����¼
			Integer ware = warehouse.getStock_number();
			warehouse.setStock_number(buy_num+ware);
			drugDao.editWarehouse(warehouse);//�ÿ��ӽ���������֮���޸�
		}else{
			drugDao.addStockDrug(stockDrug);
			warehouse = new Warehouse();
			warehouse.setDrug_id(drug_id);
			warehouse.setStock_number(buy_num);
			drugDao.addWarehouse(warehouse);
		}
	}

	@Override
	public void editStockDrug(Integer buyNum,String drugid,Integer id, String bill_id, String drug_id,
			Double price, Integer buy_num, String date, String supplier) {
		StockDrug stockDrug = new StockDrug();
		stockDrug.setId(id);
		stockDrug.setBill_id(bill_id);
		stockDrug.setBuy_num(buy_num);
		stockDrug.setDate(date);
		stockDrug.setDrug_id(drug_id);
		stockDrug.setPrice(price);
		stockDrug.setSupplier(supplier);
		
		Warehouse warehouse = drugDao.findWareByDrugId(drugid);
		Integer ware = warehouse.getStock_number();//��õ�ǰ�����
		if(warehouse.getDrug_id().equals(drug_id)){
			
			
			warehouse.setStock_number(ware-buyNum+buy_num);
			drugDao.editWarehouse(warehouse);
			drugDao.editStockDrug(stockDrug);
		}else{
			warehouse.setStock_number(ware-buyNum);//ҩƷ�������������ȥ֮ǰ�Ĺ���
			Warehouse warehouse2 = new Warehouse();
			warehouse2.setDrug_id(drug_id);
			warehouse2.setStock_number(buy_num);
			drugDao.addWarehouse(warehouse2);//�޸ĵ�ǰ���
			drugDao.editWarehouse(warehouse);//�����¿��
			drugDao.editStockDrug(stockDrug);//�޸Ľ�ҩ�б�
		}
		
	}

	
	
	
	
	public DrugDao getDrugDao() {
		return drugDao;
	}


	public void setDrugDao(DrugDao drugDao) {
		this.drugDao = drugDao;
	}


	@Override
	public List<StockDrug> queryStockByCondition(String drug_id,String date,String supplier) {
		StockDrug stockDrug = new StockDrug();
		stockDrug.setDate(date);
		stockDrug.setDrug_id(drug_id);
		stockDrug.setSupplier(supplier);
		return drugDao.queryStockByCondition(stockDrug);
		
	}


	

	
	
	
}
