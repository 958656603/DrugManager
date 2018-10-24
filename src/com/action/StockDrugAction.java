package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.StockDrug;
import com.bean.Warehouse;
import com.service.StockDrugService;
import com.service.WarehouseService;

@Controller
@RequestMapping(value="/stock")
public class StockDrugAction {
	
	@Resource
	private StockDrugService stockDrugService;
	
	@Resource
	private WarehouseService warehouseService;
	
	@RequestMapping(value="login")
	public ModelAndView prestocklist(){
		ModelAndView model = new ModelAndView();
		List<StockDrug> stockDrugList = stockDrugService.queryAllStockDrug();
		model.addObject(stockDrugList);
		model.setViewName("stocklist");
		return model;
	}
	
	
	@RequestMapping(value="preAdd")
	public ModelAndView preAdd(){
		ModelAndView model = new ModelAndView();
		model.setViewName("stockDrugAdd");
		return model;
	}
	
	@RequestMapping(value="add")
	public ModelAndView add(String bill_id,String drug_id,Double price,Integer buy_num,String date,String supplier){
		stockDrugService.addStockDrug(bill_id, drug_id, price, buy_num, date, supplier);
		List<StockDrug> stockDrugList = stockDrugService.queryAllStockDrug();
		ModelAndView model = new ModelAndView();
		List<Warehouse> warehouseList = warehouseService.queryAllWareDrug();
		model.addObject(warehouseList);
		model.addObject(stockDrugList);
		model.setViewName("stocklist");
		return model;
	}
	
	@RequestMapping(value="preEdit")
	public ModelAndView preEdit(Integer id, String bill_id, String drug_id,
			Double price, Integer buy_num, String date, String supplier) throws UnsupportedEncodingException{
		ModelAndView model = new ModelAndView();
		StockDrug stockDrug = new StockDrug();
		stockDrug.setBill_id(bill_id);
		stockDrug.setBuy_num(buy_num);
		stockDrug.setDate(date);
		stockDrug.setDrug_id(drug_id);
		stockDrug.setSupplier(new String(supplier.getBytes("ISO-8859-1"),"utf-8"));
		stockDrug.setPrice(price);
		stockDrug.setId(id);
		model.addObject(stockDrug);
		model.setViewName("stockEdit");
		return model;
	}

	@RequestMapping(value="edit")
	public ModelAndView editStockDrug(Integer buyNum,String drugid,Integer id, String bill_id, String drug_id,
			Double price, Integer buy_num, String date, String supplier){
		stockDrugService.editStockDrug(buyNum,drugid, id, bill_id, drug_id, price, buy_num, date, supplier);
		List<StockDrug> stockDrugList = stockDrugService.queryAllStockDrug();
		ModelAndView model = new ModelAndView();
		List<Warehouse> warehouseList = warehouseService.queryAllWareDrug();
		model.addObject(warehouseList);
		model.addObject(stockDrugList);
		model.setViewName("stocklist");
		return model;
	}
	
	@RequestMapping(value="find")
	public ModelAndView queryStockByCondition(String drug_id,String date,String supplier){
		ModelAndView model = new ModelAndView();
		List<StockDrug> stockDrugList = stockDrugService.queryStockByCondition(drug_id, date, supplier);
		model.addObject(stockDrugList);
		model.setViewName("stocklist");
		return model;
	}
	
	public StockDrugService getStockDrugService() {
		return stockDrugService;
	}

	public void setStockDrugService(StockDrugService stockDrugService) {
		this.stockDrugService = stockDrugService;
	}

	public WarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}
	
	
	
}
