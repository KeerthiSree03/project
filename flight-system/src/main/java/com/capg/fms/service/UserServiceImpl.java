package com.capg.fms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capg.fms.dao.UserDao;
import com.capg.fms.dao.UserDaoImpl;
import com.capg.fms.model.User;
import com.capg.fms.util.InvalidDetailsException;

public class UserServiceImpl implements UserService {
	
	static UserDao dao=new UserDaoImpl();
	
	public boolean addUser(User user) {
		return dao.addUser(user); 
	}

	public List<User> viewUsers() {
		return dao.viewUsers();
	}

	public Map<Long, User> getUserList() {
		return dao.getUserList();
		
	}

	public User viewUserById(long userId) {
		return dao.viewUserById(userId);
		
	}

	public void initialUsersList() {
		dao.addSomeUsers();
	}
	
	public boolean validatePhoneNo(long phoneNo) throws InvalidDetailsException {
		String s=Long.toString(phoneNo);
		if(s.length()==10 && s.charAt(0)!=0)
			return true;
		else
			throw new InvalidDetailsException("Invalid Phone Number");	
	}

	
	public boolean validateEmail(String email) throws InvalidDetailsException {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      if(email.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidDetailsException("Invalid email Id");
	   }


	public boolean validateId(long id) throws InvalidDetailsException {
		int count=0;
		long d;
		while(id>0) {
			d=id % 10;
			count++;
			id=id/10;
		}
		
		if(count!=12)
			throw new InvalidDetailsException("Invalid ID");	
			
		else
			return true;
	}

	
}
