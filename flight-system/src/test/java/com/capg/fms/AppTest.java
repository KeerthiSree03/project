package com.capg.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.capg.fms.dao.UserDao;
import com.capg.fms.dao.UserDaoImpl;
import com.capg.fms.model.User;
import com.capg.fms.service.UserService;
import com.capg.fms.service.UserServiceImpl;
import com.capg.fms.util.InvalidDetailsException;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
   
	UserService service=new UserServiceImpl();
	UserDao dao=new UserDaoImpl();
	static Map<Long,User> userList=UserDaoImpl.userList;
	static User admin1;
	
	@BeforeAll
	public static void addSomeUsers() {

		admin1=new User(123434567890L,"Keerthi","dfgh456",9876543210L,"keerthi@gmail.com");
		userList.put(admin1.getUserId(),admin1);
	}
	
	@Test
	public void testId() throws InvalidDetailsException{
		assertEquals(true, service.validateId(123434567890L));
	}
	
	@Test
	public void testEmail() throws InvalidDetailsException{
		assertEquals(true, service.validateEmail("keerthi@gmail.com"));
	}
	
	@Test
	public void testPhoneNo() throws InvalidDetailsException{
		assertEquals(true, service.validatePhoneNo(9876543210L));
	}
	
	@Test
	public void testUserById() {
		assertEquals(admin1, service.viewUser(123434567890L));
	}
	
	@Test
	public void testgetUser() {
		assertEquals(userList, service.getUser());
	}	
}
