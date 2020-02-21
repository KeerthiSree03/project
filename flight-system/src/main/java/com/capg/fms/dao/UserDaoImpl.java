package com.capg.fms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capg.fms.model.User;

public class UserDaoImpl implements UserDao {

	Map<Long,User> userList=new HashMap<Long , User>();
	
	public void addSomeUsers() {

		User admin1=new User(12343456L,"Keerthi","dfgh456",9876543210L,"keerthi@gmail.com");
		User admin2=new User(12343459L,"Kavya","34fsgj",9876543211L,"kavya@gmail.com");
		userList.put(admin1.getUserId(),admin1);
		userList.put(admin2.getUserId(),admin2);
		
	}

	public boolean addUser(User user) {
		if(userList.containsKey(user.getUserId())){
			return false;
		}
		userList.put(user.getUserId(), user);
		return true;
	}

	public List<User> viewUser() {
		
		List<User> listOfUsers = new ArrayList<User>();
		for(Long l:userList.keySet()) {
			listOfUsers.add(userList.get(l));
		}
		return listOfUsers;
	}

	public Map<Long, User> getUser() {
		
		return userList;
	}
	public User viewUser(long userId) {
		
		if(userList.containsKey(userId)) {
			return userList.get(userId);
		}
		return null;
	}

	public boolean updateUser(User user) {
		
		if(!userList.containsKey(user)) {
			return false;
		}
		User userUpdate=userList.get(user);
		userUpdate.setUserName(user.getUserName());
		userUpdate.setUserPassword(user.getUserPassword());
		userUpdate.setUserId(user.getUserId());
		userUpdate.setUserPhone(user.getUserPhone());
		userUpdate.setUserEmail(user.getUserEmail());
		return true;
	}

	public boolean deleteUser(long userId) {
		
		if(userList.containsKey(userId)) {
			userList.remove(userId, userList.containsKey(userId));
			return true;
		}
		return false;
	}
}
