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
		int i = loginService.login(username, password);//i 就是usertype，用户类型
		ModelAndView model = new ModelAndView();
		if(i==-1){
			model.addObject("loginMessage","用户不存在！请重新输入！");
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
			model.addObject("usertype",i);//将用户类型带到前台
			
//			List<User> userList = loginService.queryAllUser();//查询所有user用户
//			model.addObject("userList",userList);
//			List<Warehouse> warehouseList = loginService.queryAllWareDrug();//查询所有库存药品
//			model.addObject("warehouseList",warehouseList);
//			List<StockDrug> stockDrugList = stockDrugService.queryAllStockDrug();//查询所有进货药品
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
