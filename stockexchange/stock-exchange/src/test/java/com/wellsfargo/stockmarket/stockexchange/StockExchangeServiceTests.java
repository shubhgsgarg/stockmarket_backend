package com.wellsfargo.stockmarket.stockexchange;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wellsfargo.stockmarket.stockexchange.entity.StockExchange;
import com.wellsfargo.stockmarket.stockexchange.repository.StockExchangeRepository;
import com.wellsfargo.stockmarket.stockexchange.service.StockExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockExchangeServiceTests {

	@Autowired
	private StockExchangeService service;

	@MockBean
	private StockExchangeRepository repository;

	// Test to find all StockExchanges in our repository
	@Test
	public void getStockExchangeListTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new StockExchange(1, "nse", "abc", "asv", "asd"), new StockExchange(2, "bse", "gtn", "nyt", "dvr"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getStockExchangeList().size());
	}
	
	//Test to add a StockExchange
	@Test
	public void addStockExchangeTest() {
		StockExchange stockExchange = new StockExchange(1, "nse", "abc", "asv", "asd");
		when(repository.save(stockExchange)).thenReturn(stockExchange);
		assertEquals(stockExchange, service.addStockExchange(stockExchange));
	}
	
	//Test to find a stockExchange by id
	@Test
	public void findStockExchangeById() {
		
		Optional <StockExchange> stockExchange  = Optional.of(new StockExchange(2, "bse", "ewfe", "wefw", "trb"));
		Integer id = 2 ;
		when(repository.findById(id)).thenReturn(stockExchange);
		Optional <StockExchange> stockExchange1 =  Optional.of(service.getStockExchange(id));
		assertEquals(stockExchange,stockExchange1 );
		
	}
		
	
}
