package com.wellsfargo.stockmarket.stockexchange;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockExchangeControllerTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

//For running the tests please populate the database first.

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// Test to return all stock Exchanges present in the database
	@Test
	public void getAllStockExchangesTest() throws Exception {

		this.mockMvc.perform(get("/stockexchanges").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	// Test to return a specific stock Exchange present in the database
	@Test
	public void getStockExchangeTest() throws Exception {

		this.mockMvc.perform(get("/stockexchanges/2").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	// Test to return all companies present in a specific stock Exchange present in
	// the database
	@Test
	public void getAllComapniesListTest() throws Exception {

		this.mockMvc.perform(get("/stockexchanges/2/companies").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}