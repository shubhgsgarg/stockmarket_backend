package com.wellsfargo.stockmarket.loginsignup;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.RequestBuilder;
import com.wellsfargo.stockmarket.loginsignup.entity.User;
import com.wellsfargo.stockmarket.loginsignup.service.UserService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@ExtendWith (SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@MockBean
	private UserService userService;
	
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Test login found")
	public void testFindByIdURL() throws Exception {
		
		User mockUser = new User ("u36","p3","u36@gmail.com", false);
		
		doReturn(mockUser).when(userService).findbyID(mockUser.getUserName(),mockUser.getPassword());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/login").param("username","u1").param("password","p1"))
		.andExpect(status().isOk());
		
	}
	
	 

}
