package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Warehouse;
import com.service.WarehouseService;

@Controller
@RequestMapping(value="warehouse")
public class WarehouseAction {

	/*<td>${warehouse.drug_id }</td>
	<td>${warehouse.manufacturer }</td>
	<td>${warehouse.standard }</td>
	<td>${warehouse.stock_number }</td>
	<td>${warehouse.sale_price }</td>*/
	@Resource
	private WarehouseService warehouseService;
	
	@RequestMapping(value="login")
	public ModelAndView prewarelist(){
		ModelAndView model = new ModelAndView();
		List<Warehouse> warehouseList = warehouseService.queryAllWareDrug();
		model.addObject(warehouseList);
		model.setViewName("warelist");
		return model;
	}
	
	@RequestMapping(value="preEdit")
	public ModelAndView preeditWarehouse(Integer id,String drug_id,Integer stock_number,String manufacturer,String standard,Double sale_price) throws UnsupportedEncodingException{
		Warehouse warehouse = new Warehouse();
		warehouse.setDrug_id(drug_id);
		warehouse.setId(id);
		warehouse.setManufacturer(new String(manufacturer.getBytes("ISO-8859-1"),"utf-8"));
		warehouse.setSale_price(sale_price);
		warehouse.setStandard(new String(standard.getBytes("ISO-8859-1"),"utf-8"));
		warehouse.setStock_number(stock_number);
		ModelAndView model = new ModelAndView();
		model.addObject("warehouse", warehouse);
		model.setViewName("wareEdit");
		return model;
	}
	
	@RequestMapping(value="edit")//ÐÞ¸Ä¿â´æÁÐ±í
	public ModelAndView editWarehouse(Integer id,String drug_id,Integer stock_number,String manufacturer,String standard,Double sale_price) throws UnsupportedEncodingException{
		warehouseService.editWarehouse(id, drug_id, stock_number, manufacturer, standard, sale_price);
		List<Warehouse> warehouseList = warehouseService.queryAllWareDrug();
		ModelAndView model = new ModelAndView();
		model.addObject(warehouseList);
		model.setViewName("warelist");
		return model;
	}
		
	@RequestMapping(value="preAdd")
	public ModelAndView preWareAdd(){
		ModelAndView model = new ModelAndView();
		model.setViewName("wareAdd");
		return model;
	}
	
	
	@RequestMapping(value="add")
	public ModelAndView addWarehouse(String drug_id,Integer stock_number,String manufacturer,String standard,Double sale_price) throws UnsupportedEncodingException{
		warehouseService.addWarehouse(drug_id, stock_number, manufacturer, standard, sale_price);
		List<Warehouse> warehouseList = warehouseService.queryAllWareDrug();
		ModelAndView model = new ModelAndView();
		model.addObject(warehouseList);
		model.setViewName("warelist");
		return model;
	}
	
	@RequestMapping(value="find")
	public ModelAndView queryWareByCondition(String drug_id){
		ModelAndView model = new ModelAndView();
		List<Warehouse> warehouseList = warehouseService.queryWareByCondition(drug_id);
		
		model.addObject(warehouseList);
		model.setViewName("warelist");
		return model;
	}
	
	public WarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}
	
	
	
	
	
}
