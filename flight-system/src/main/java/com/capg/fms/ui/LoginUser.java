package com.capg.fms.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capg.fms.model.User;
import com.capg.fms.service.UserService;
import com.capg.fms.service.UserServiceImpl;
import com.capg.fms.util.InvalidDetailsException;

public class LoginUser {
	static Scanner sc=new Scanner(System.in);
	static User user=new User();
	static UserService service=new UserServiceImpl();
	
	public static void main(String[] args) {
		login();
	}
	
	public static void newUser() {
		
		System.out.println("Enter the userId:");
		long id=sc.nextLong();
		try {
			if(service.validateId(id)) {
				user.setUserId(id);
			}
		System.out.println("Enter the password: ");
		String password=sc.next()+sc.nextLine();
		user.setUserPassword(password);
		
		System.out.println("Enter the Name: ");
		String name=sc.next()+sc.nextLine();
		user.setUserName(name);
		
		System.out.println("Enter the phone: ");
		long ph=sc.nextLong();
		if(service.validatePhoneNo(ph)) {
			user.setUserPhone(ph);
		}
		System.out.println("Enter the email: ");
		String mail=sc.next()+sc.nextLine();
		if(service.validateEmail(mail)) {
			user.setUserEmail(mail);
		}
		
		
		if(service.addUser(user)) {
			System.out.println("Account created Successfully!!!.....you can login into your account now");
			login();
		}
		else {
			System.out.println("User id already exists....");
		}
		}
		catch (InvalidDetailsException e1) {
			System.out.println(e1.getMessage());
		}
		
	}

	public static void customerLogin() {
		
		service.initialUsersList();
		System.out.println("Enter the userId: ");
		long customerId = sc.nextLong();
		String customerPassword=null ;
		if(service.getUserList().containsKey(customerId)) {
			System.out.println("Enter the password: ");
			customerPassword = sc.next()+sc.nextLine();
			String p=service.viewUserById(customerId).getUserPassword();
			if(p.equals(customerPassword)) {
				System.out.println("Login Successful!!!");
			}
			else {
					System.out.println("Invalid password!!!.....try again");
					System.out.println("If new user then create a new account...or try to login again with correct credentials");
					login();
			}
		}
		else {
			System.out.println("Invalid Id");
			System.out.println("If new user then create a new account...");
		}	
		
			
	}
	public static void adminLogin() {
		
		service.initialUsersList();
		System.out.println("Enter the userId: ");
		long adminId = sc.nextLong();
		String adminPassword=null ;
		if(service.getUserList().containsKey(adminId)) {
			System.out.println("Enter the password: ");
			adminPassword = sc.next()+sc.nextLine();
			String p=service.viewUserById(adminId).getUserPassword();
			if(p.equals(adminPassword)) {
				System.out.println("Login Successful");
			}
			else {
					System.out.println("Invalid password!!!......try again");
					login();
			}
		}
		else {
			System.out.println("Invalid id");
		}
	}
	
	public static void login() {
		
		System.out.println("Choose the type of user : ");
		System.out.println("1 - Admin");
		System.out.println("2 - Customer");
		System.out.println("3 - New User");
		try {
		
		int choice=sc.nextInt();
		
		switch(choice) {
			case 1:
				adminLogin();
				break;
			
			case 2:
				customerLogin();
				break;
				
			case 3:
				newUser();
				break;
				
			default:
				System.out.println("Invalid choice....Please try again");
				login();
		}
	}
		catch(InputMismatchException err){
			System.out.println("Please choose valid option...");
		}
			
		}
}
