package com.service;

import java.util.List;

import com.bean.User;

public interface UserService {
	public void delUser(Integer id);
	public void edit(Integer id,String username,String password,String usertype);
	public boolean add(String username,String password,String usertype);
	public List<User> queryUserByCondition(String username,String usertype);
}
