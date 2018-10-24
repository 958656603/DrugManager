package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SaleDrug;
import com.bean.StockDrug;
import com.bean.User;
import com.bean.Warehouse;
import com.service.LoginService;
import com.service.SaleDrugService;
import com.service.StockDrugService;

@Controller
@RequestMapping(value="/userLogin")
public class LoginAction {
	
	
	@Resource
	private LoginService loginService;
	
	@Resource
	private StockDrugService stockDrugService;
	
	@Resource
	private SaleDrugService saleDrugService;
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(String username,String password,HttpServletResponse resp){
		int i = loginService.login(username, password);//i ����usertype���û�����
		ModelAndView model = new ModelAndView();
		if(i==-1){
			model.addObject("loginMessage","�û������ڣ����������룡");
			model.setViewName("index");
		}else{
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("passwordCookie", password);
			Cookie usertypeCookie = new Cookie("usertypeCookie", String.valueOf(i));
			usernameCookie.setPath("/");
			passwordCookie.setPath("/");
			usertypeCookie.setPath("/");
			resp.addCookie(usertypeCookie);
			resp.addCookie(passwordCookie);
			resp.addCookie(usernameCookie);
			model.addObject("usertype",i);//���û����ʹ���ǰ̨
			
//			List<User> userList = loginService.queryAllUser();//��ѯ����user�û�
//			model.addObject("userList",userList);
//			List<Warehouse> warehouseList = loginService.queryAllWareDrug();//��ѯ���п��ҩƷ
//			model.addObject("warehouseList",warehouseList);
//			List<StockDrug> stockDrugList = stockDrugService.queryAllStockDrug();//��ѯ���н���ҩƷ
//			model.addObject(stockDrugList);
//			List<SaleDrug> saleDrugList = saleDrugService.queryAllSaleDrug();
//			model.addObject(saleDrugList);
			model.setViewName("welcome");
		}
		
		return model;
	}
	
	

	public LoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}



	public StockDrugService getStockDrugService() {
		return stockDrugService;
	}



	public void setStockDrugService(StockDrugService stockDrugService) {
		this.stockDrugService = stockDrugService;
	}



	public SaleDrugService getSaleDrugService() {
		return saleDrugService;
	}



	public void setSaleDrugService(SaleDrugService saleDrugService) {
		this.saleDrugService = saleDrugService;
	}
	
	
	
}
