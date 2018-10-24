package com.service;

import java.util.List;

import com.bean.User;
import com.bean.Warehouse;


public interface LoginService {
	public Integer login(String username,String password);
	public List<User> queryAllUser();
	public List<Warehouse> queryAllWareDrug();
}
