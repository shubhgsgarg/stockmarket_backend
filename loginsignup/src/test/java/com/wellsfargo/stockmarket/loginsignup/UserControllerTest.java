package com.wellsfargo.stockmarket.loginsignup;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
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
	
	@MockBean
	private User user;
	
	private String mockString;

	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Test login found")
	public void testFindByIdURL() throws Exception {
		
		user = new User ("u36","p3","u36@gmail.com", false);
		String mockString = null;

			doReturn(mockString).when(userService).findbyID(user.getUserName(),user.getPassword());
			mockMvc.perform(MockMvcRequestBuilders.get("/login").param("username","u36").param("password","p3"))
			.andExpect(status().isOk())
			.andExpect(content().string("<h1>SUCCESS</h1>"));
		
	} 

}
