package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDao {
	public User queryByCondition(User u);//µÇÂ¼²éÑ¯
	public List<User> queryAllUser();
	public void delUser(Integer id);
	public void edit(User user);
	public boolean add(User user);
	public User findUserByName(String username);
	public List<User> queryUserByCondition(User user);
}
