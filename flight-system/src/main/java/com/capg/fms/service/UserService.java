package com.capg.fms.service;

import java.util.List;
import java.util.Map;

import com.capg.fms.model.User;
import com.capg.fms.util.InvalidDetailsException;

public interface UserService {
	
	public void initialUsersList();
	public boolean addUser(User user);
	public List<User> viewUser();
	public Map<Long,User> getUser();
	public User viewUser(long userId);
	public boolean validatePhoneNo(long phoneNo) throws InvalidDetailsException;
	public boolean validateEmail(String mail) throws InvalidDetailsException;
	public boolean validateId(long id) throws InvalidDetailsException;
	
}
