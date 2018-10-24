package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;
import com.service.LoginService;
import com.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserAction {
	
	@Resource
	private UserService userService;
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value="login")
	public ModelAndView preUserList(){
		ModelAndView model = new ModelAndView();
		model.setViewName("userlist");
		List<User> userList = loginService.queryAllUser();
		model.addObject(userList);
		return model;
	}
	
	@RequestMapping(value="exit")
	public ModelAndView exit(HttpServletResponse resp){
		Cookie usernameCookie = new Cookie("username", null);
		Cookie passwordCookie = new Cookie("passwordCookie", null);
		Cookie usertypeCookie = new Cookie("usertypeCookie",null);
		usernameCookie.setMaxAge(0);
		passwordCookie.setMaxAge(0);
		usertypeCookie.setMaxAge(0);
		usernameCookie.setPath("/");
		passwordCookie.setPath("/");
		usertypeCookie.setPath("/");
		resp.addCookie(usertypeCookie);
		resp.addCookie(passwordCookie);
		resp.addCookie(usernameCookie);
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	
	@RequestMapping(value="delUser")
	public ModelAndView delUser(Integer id){
		userService.delUser(id);
		
		return userList();
	}
	
	@RequestMapping(value="/userList")//返回所有用户列表的方法，节省代码量
	public ModelAndView userList(){
		List<User> userList = loginService.queryAllUser();
		ModelAndView model = new ModelAndView();
		model.addObject(userList);
		model.setViewName("userlist");
		return model;
	}
	
	@RequestMapping(value="preEdit")
	public ModelAndView preEdit(User user){
		ModelAndView model = new ModelAndView();
		model.addObject("user",user);
		model.setViewName("userEdit");
		return model;
	}
	
	@RequestMapping(value="edit")
	public ModelAndView edit(Integer id,String username,String password,String usertype){
		ModelAndView model = new ModelAndView();
		userService.edit(id,username,password,usertype);
		return userList();
	}
	
	@RequestMapping(value="preAdd")
	public ModelAndView preAdd(){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("userAdd");
		return model;
	}
	
	@RequestMapping(value="add")
	public ModelAndView add(String username,String password,String usertype){
		Boolean b = userService.add(username, password, usertype);
		if(!b){
			ModelAndView model = new ModelAndView();
			model.addObject("addMessage","用户已存在，请更换用户名！");
			model.setViewName("userAdd");
			return model;
		}
		return userList();
	}
	
	@RequestMapping(value="queryUserByCondition")//按照条件查询职员
	public ModelAndView queryUserByCondition(String username,String usertype){
		List<User> userList = userService.queryUserByCondition(username, usertype);
		ModelAndView model = new ModelAndView();
		model.addObject(userList);
		model.setViewName("userlist");
		return model;
		
	}
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
}
