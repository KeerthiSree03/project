package com.capg.fms.dao;

import java.util.List;
import java.util.Map;

import com.capg.fms.model.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public List<User> viewUsers();
	public Map<Long,User> getUserList();
	public User viewUserById(long userId);
	public void addSomeUsers();

}
