package com.wellsfargo.stockmarket.loginsignup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wellsfargo.stockmarket.loginsignup.entity.User;
import com.wellsfargo.stockmarket.loginsignup.service.UserService;

@SpringBootTest
public class UserTest {
	
	@Test
	void contextLoads() {
		
	}
	
	@Autowired
	private UserService userService;
	
	User user = new User ("u110","p110","u110@gmail.com",false);
	
	
	String value;
	
	@Test
	@DisplayName("LOGIN TEST PASSED")
	public void findByIdLoginTest()throws Exception{
		
		userService.addUser(user.getUserName(),user.getPassword(),user.getEmail(),user.getIsAdmin());
		
		value = userService.findbyID( user.getUserName(), user.getPassword());
		assertEquals("<h1>SUCCESS</h1>",value);
		
		value = userService.findbyID(user.getUserName(), "password");
		assertEquals("<h1>WRONG PASSWORD</h1>",value);
		
		value = userService.findbyID("userName", "password");
		assertEquals("<h1>USER NOT PRESENT</h1>",value);
	}
	
	@Test
	@DisplayName("ADD USER TEST PASSED")
	public void addUser() throws Exception{
		
		value = userService.addUser("newUser", "newPassword", "newemail", false);
		assertEquals("<h1>USER ADDED</h1>",value);
		
		value = userService.addUser("newUser", "newPassword", "newemail", false);
		assertEquals("<h1>USER ALREADY PRESENT</h1>",value);
		
		value = userService.addUser("newUser1", "newPassword", "newemail", false);
		assertEquals("<h1>EMAIL ALREADY EXISTS</h1>",value);
		
	}
	
	@Test
	@DisplayName("UPDATE USER TEST PASSED")
	public void updateUser() throws Exception{
		
		value = userService.updateUser(user.getUserName(), "updatedPassword", "updatedEmail");
		assertEquals("<h1> USER UPDATED</h1>",value);
		
		value = userService.updateUser("randomUser", "updatedPassword", "updatedEmail");
		assertEquals("<h1> USER NOT PRESENT</h1>",value);
		
	}
	

}
