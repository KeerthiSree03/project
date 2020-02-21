package com.capg.fms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capg.fms.dao.UserDao;
import com.capg.fms.dao.UserDaoImpl;
import com.capg.fms.model.User;
import com.capg.fms.uitl.InvalidDetailsException;

public class UserServiceImpl implements UserService {
	
	static UserDao d=new UserDaoImpl();
	
	public boolean addUser(User user) {
		return d.addUser(user); 
	}

	public List<User> viewUser() {
		return d.viewUser();
		
	}

	public Map<Long, User> getUser() {
		return d.getUser();
		
	}

	public User viewUser(long userId) {
		return d.viewUser(userId);
		
	}

	public void initialUsersList() {
		d.addSomeUsers();
	}
	
	public boolean validatePhoneNo(long phoneNo) throws InvalidDetailsException {
		int count=0;
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
		while(id>0) {
			long d=id % 10;
			count++;
			id=id/10;
		}
		if(count==12)
			return true;
		else
			throw new InvalidDetailsException("Invalid ID");	
	}
}
