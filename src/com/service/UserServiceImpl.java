package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Resource
	private UserDao userDao; 
	
	@Override
	public void delUser(Integer id) {
		userDao.delUser(id);
	}
	
	public void edit(Integer id,String username,String password,String usertype){
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setUsername(username);
		user.setUsertype(Integer.parseInt(usertype));
		userDao.edit(user);
	}
	
	public boolean add(String username,String password,String usertype){
		User u = null;
		u = userDao.findUserByName(username);//查询用户是否已存在
		if(u==null){
			User user = new User();
			user.setPassword(password);
			user.setUsername(username);
			user.setUsertype(Integer.parseInt(usertype));
			userDao.add(user);
			return true;
		}else{
			return false;
		}
		
	}
	
	public List<User> queryUserByCondition(String username,String usertype){
		User u;
		if(Integer.parseInt(usertype)!=-1){
			u = new User();
			u.setUsername(username);
			u.setUsertype(Integer.parseInt(usertype));
		}else{
			u = new User();
			u.setUsername(username);
		}
		
		return userDao.queryUserByCondition(u);
		
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
