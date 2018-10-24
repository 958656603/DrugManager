package com.service;

import java.util.List;

import com.bean.SaleDrug;

public interface SaleDrugService {
	public List<SaleDrug> queryAllSaleDrug();
	public boolean addSaleDrug(String customer_id,String drug_id,Integer sale_number,String date,Double price);
	public boolean editSaleDrug(String drugid,Integer saleNum,Integer id,String customer_id,String drug_id,Integer sale_number,String date,Double price);
	public void delSale(String drug_id,Integer sale_number,Integer id);
	public List<SaleDrug> querySaleByCondition(String drug_id,String date);
}
