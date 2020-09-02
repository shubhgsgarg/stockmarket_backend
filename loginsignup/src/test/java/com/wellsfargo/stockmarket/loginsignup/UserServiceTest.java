package com.wellsfargo.stockmarket.loginsignup;


import org.junit.runner.RunWith;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wellsfargo.stockmarket.loginsignup.entity.User;
import com.wellsfargo.stockmarket.loginsignup.repository.UserRepository;
import com.wellsfargo.stockmarket.loginsignup.service.UserService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = LoginsignupApplication.class )
@SpringBootTest
public class UserServiceTest {
	
	@Autowired 
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	@DisplayName("TEST FOR LOGIN")
	public void testFindByID() {
		
		User mockUser = new User("u25","p25","email25@gmail.com",false);
		mockUser.setVerified(true);
		
		String foundUserName = userService.findbyID("u25", "p25"); 
		Assertions.assertNotNull(foundUserName);
		Assertions.assertSame("<h1>SUCCESS</h1>", foundUserName);
		
		String foundUserName1 = userService.findbyID("u25", "p26");
		Assertions.assertNotNull(foundUserName1);
		Assertions.assertSame("<h1>WRONG PASSWORD</h1>", foundUserName);
		
		String foundUserName2 = userService.findbyID("u30", "p26");
		Assertions.assertNotNull(foundUserName2);
		Assertions.assertSame("<h1>USER NOT PRESENT</h1>", foundUserName);
	}
}
