package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SaleDrug;
import com.bean.StockDrug;
import com.service.SaleDrugService;

@Controller
@RequestMapping(value="/sale")
public class SaleDrugAction {
	
	@Resource
	private SaleDrugService saleDrugService;

	@RequestMapping(value="login")
	public ModelAndView presalelist(){
		ModelAndView model = new ModelAndView();
		List<SaleDrug> saleDrugList = saleDrugService.queryAllSaleDrug();
		model.addObject(saleDrugList);
		model.setViewName("salelist");
		return model;
	}
	
	@RequestMapping(value="preAdd")
	public ModelAndView preAdd(){
		ModelAndView model = new ModelAndView();
		model.setViewName("saleAdd");
		return model;
	}
	
	@RequestMapping(value="add")
	public ModelAndView addSaleDrug(String customer_id, String drug_id,
			Integer sale_number, String date, Double price){
		ModelAndView model = new ModelAndView();
		boolean b = saleDrugService.addSaleDrug(customer_id, drug_id, sale_number, date, price);
		
		if(b){//即库存表中数量大于售药数量，可以正常销售
			List<SaleDrug> saleDrugList = saleDrugService.queryAllSaleDrug();
			model.addObject(saleDrugList);
			model.setViewName("salelist");
		}else{
			model.addObject("saleMessage","库房药品数量不足！");
			model.setViewName("saleAdd");
		}
		return model;
	}
	
	@RequestMapping(value="preEdit")
	public ModelAndView preEdit(Integer id,String customer_id,String drug_id,Integer sale_number,String date,Double price){
		SaleDrug saleDrug = new SaleDrug();
		 saleDrug.setCustomer_id(customer_id);
		 saleDrug.setDate(date);
		 saleDrug.setDrug_id(drug_id);
		 saleDrug.setId(id);
		 saleDrug.setPrice(price);
		 saleDrug.setSale_number(sale_number);
		 ModelAndView model = new ModelAndView();
		 model.addObject(saleDrug);
		 model.setViewName("saleEdit");
		 return model;
	}
	
	@RequestMapping(value="edit")
	public ModelAndView edit(String drugid,Integer saleNum, Integer id, String customer_id, String drug_id,
			Integer sale_number, String date, Double price){
		
		ModelAndView model = new ModelAndView();
		boolean b = saleDrugService.editSaleDrug(drugid, saleNum, id, customer_id, drug_id, sale_number, date, price);
		if(b){
			List<SaleDrug> saleDrugList = saleDrugService.queryAllSaleDrug();
			model.addObject(saleDrugList);
			model.setViewName("salelist");
		}else{
			model.addObject("saleMessage","库房药品数量不足！");
			model.setViewName("saleEdit");
		}
		return model;
	}
	
	@RequestMapping(value="del")
	public ModelAndView delSale(String drug_id,Integer sale_number,Integer id){
		saleDrugService.delSale(drug_id, sale_number, id);
		ModelAndView model = new ModelAndView();
		List<SaleDrug> saleDrugList = saleDrugService.queryAllSaleDrug();
		model.addObject(saleDrugList);
		model.setViewName("salelist");
		return model;
	}
	
	
	public SaleDrugService getSaleDrugService() {
		return saleDrugService;
	}

	public void setSaleDrugService(SaleDrugService saleDrugService) {
		this.saleDrugService = saleDrugService;
	}
	
	
	@RequestMapping(value="find")
	public ModelAndView findByCondition(String drug_id,String date){
		List<SaleDrug> saleDrugList = saleDrugService.querySaleByCondition(drug_id, date);
		ModelAndView model = new ModelAndView();
		model.addObject(saleDrugList);
		model.setViewName("salelist");
		return model;
	}
	
	
}
