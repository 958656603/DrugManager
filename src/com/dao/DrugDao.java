package com.dao;

import java.util.List;

import com.bean.SaleDrug;
import com.bean.StockDrug;
import com.bean.Warehouse;

public interface DrugDao {
	//�����ǿ������
	public List<Warehouse> queryAllWareDrug();//��ѯ���п��ҩƷ
	public void editWarehouse(Warehouse warehouse);
	public void addWarehouse(Warehouse warehouse);
	public Warehouse findWareById(Integer id);
	public Warehouse findWareByDrugId(String drug_id);
	
	//�����ǽ�ҩ�����
	public List<StockDrug> queryAllStockDrug();
	public void addStockDrug(StockDrug stockDrug);
	public void editStockDrug(StockDrug stockDrug);
	
	//��ҩ���ûд��ѯ
	
	//��������ҩ�����
	public List<SaleDrug> queryAllSaleDrug();
	public void addSaleDrug(SaleDrug saleDrug); 
	public void editSaleDrug(SaleDrug saleDrug);
	public void delSale(Integer id);
	
	
	//��ѯ����
	public List<Warehouse> queryWareByCondition(Warehouse warehouse);
	public List<StockDrug> queryStockByCondition(StockDrug stockDrug);
	public List<SaleDrug> querySaleByCondition(SaleDrug saleDrug);
}
