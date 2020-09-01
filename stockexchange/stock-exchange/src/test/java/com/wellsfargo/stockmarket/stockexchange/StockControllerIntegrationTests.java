package com.wellsfargo.stockmarket.stockexchange;

import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import com.wellsfargo.stockmarket.stockexchange.controller.StockExchangeController;
import com.wellsfargo.stockmarket.stockexchange.entity.StockExchange;
import com.wellsfargo.stockmarket.stockexchange.service.StockExchangeService;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@WebMvcTest(StockExchangeController.class)
public class StockControllerIntegrationTests {
	
    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private StockExchangeService service;
    
	@Test
	public void getAllStockExchangesTest()throws Exception {
		
		StockExchange stockExchange = new StockExchange(1,"wqd","Wqd","dwqd","Ewf");
		 
	    List<StockExchange> stockExchangeList = Arrays.asList(stockExchange);
	 
	    when(service.getStockExchangeList()).thenReturn(stockExchangeList);
	 
	    mvc.perform(get("/stockexchanges")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	   
	}
	
	
	

}
