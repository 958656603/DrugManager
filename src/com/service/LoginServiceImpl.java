package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.bean.Warehouse;
import com.dao.DrugDao;
import com.dao.UserDao;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private DrugDao drugDao;
	
	
	@Override
	public Integer login(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User u = null;
		u = userDao.queryByCondition(user);
		if(u!=null){
			return u.getUsertype();
		}
		return -1;
	}
	
	@Override
	public List<User> queryAllUser() {
		
		return userDao.queryAllUser();
		
	}
	
	public List<Warehouse> queryAllWareDrug(){
		return drugDao.queryAllWareDrug();
	}

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public DrugDao getDrugDao() {
		return drugDao;
	}

	public void setDrugDao(DrugDao drugDao) {
		this.drugDao = drugDao;
	}

	


	

	
	
	
}
