package com.wellsfargo.stockmarket.stockpricedetails.testService;



import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hamcrest.Matchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.stockmarket.stockpricedetails.entity.StockPriceEntity;
import com.wellsfargo.stockmarket.stockpricedetails.helper.ServiceHelperReadExcel;
import com.wellsfargo.stockmarket.stockpricedetails.service.StockPriceService;

 
@SpringBootTest
class StockpricedetailsApplicationTests2 {

	private static final String MESSAGE_ONE = "StockPriceExcelService does not load file properly into database";
//	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\admin\\Documents\\demo\\src\\main\\resources\\sample_stock_data.xlsx";
//	MultipartFile file=(MultipartFile) new File(SAMPLE_XLSX_FILE_PATH);
	
//	File file = new File("C:\\Users\\admin\\Documents\\demo\\src\\main\\resources\\sample_stock_data.xlsx");
//	MultipartFile multipartFile = new MockMultipartFile("test.xlsx", new FileInputStream(new File("C:\\Users\\admin\\Documents\\demo\\src\\main\\resources\\sample_stock_data.xlsx")));
	
	
	@Test
	void contextLoads() {
	}

	@Autowired
	private StockPriceService stockpriceexcelservice;
	 
	@Test
	public void CheckServiceFileUploading() throws Throwable {
		
		MultipartFile multipartFile = new MockMultipartFile("test.xlsx", new FileInputStream(new File("C:\\Users\\cackr\\sample_stock_data.xlsx")));
		
 		List<StockPriceEntity> value;
			value = (List<StockPriceEntity>)stockpriceexcelservice.save(multipartFile );
			assertThat(MESSAGE_ONE,value,Matchers.hasSize(9));
		
		}
	@Autowired
	ResourceLoader resourceLoader;
		
	@Test
	void matchesInputTrue() throws Exception {
		
		
		Resource resource=resourceLoader.getResource("classpath:sample_stock_data.xlsx");
		InputStream inputStream = resource.getInputStream();
		
		
		
		StockPriceEntity stock = new StockPriceEntity();
		stock.setCompanyCode(500112);
		stock.setStockExchange("BSE");
		stock.setStockPriceTime("10:30:00");
		stock.setCurrentPrice(356.23);
		stock.setStockPriceDate(null);
		
		StockPriceEntity stock1,stock2,stock3;
		
		List<StockPriceEntity> result = ServiceHelperReadExcel.readCellValues(inputStream);
		
		stock1 = result.get(0);
		stock2 = result.get(1);
		stock3 = result.get(2);
		
		
		
		assertEquals(stock.getCompanyCode(), stock1.getCompanyCode(), "company code not correct1");
		assertEquals(stock.getStockExchange(), stock1.getStockExchange(), "Exchange name not correct1");
		assertEquals(stock.getCurrentPrice(), stock1.getCurrentPrice(), "current price name not correct1");
		assertEquals(stock.getCompanyCode(), stock2.getCompanyCode(), "company code not correct2");
		assertEquals(stock.getStockExchange(), stock2.getStockExchange(), "Exchange name not correct2");
		assertEquals(stock.getCurrentPrice(), stock3.getCurrentPrice(), "current price name not correct2");
		assertEquals(stock.getCompanyCode(), stock3.getCompanyCode(), "company code not correct3");
		assertEquals(stock.getStockExchange(), stock3.getStockExchange(), "Exchange name not correct3");
		assertEquals(stock.getCurrentPrice(), stock3.getCurrentPrice(), "current price name not correct3");
		
	}
	@Test
	void matchesInputFalse() throws Exception {
				
		Resource resource=resourceLoader.getResource("classpath:sample_stock_data.xlsx");
		InputStream inputStream = resource.getInputStream();
		
		
		
		StockPriceEntity stock = new StockPriceEntity();
		stock.setCompanyCode(510112);
		stock.setStockExchange("BOE");
		stock.setStockPriceTime("10:30:00");
		stock.setCurrentPrice(356.25);
		stock.setStockPriceDate(null);
		
		StockPriceEntity stock1 = ServiceHelperReadExcel.readCellValues(inputStream).get(0);
		
		assertNotEquals(stock.getCompanyCode(), stock1.getCompanyCode(), "company code not correct1");
		assertNotEquals(stock.getStockExchange(), stock1.getStockExchange(), "Exchange name not correct1");
		assertNotEquals(stock.getCurrentPrice(), stock1.getCurrentPrice(), "current price name not correct1");
		
	}
	
	@Test 
	void inputTypeCheckFail() throws IOException{
		Resource resource=resourceLoader.getResource("classpath:sample_stock_data2.xlsx");//input type error
		InputStream inputStream = resource.getInputStream();
		StockPriceEntity stock1;
		int x = 1;
		try {	
			stock1 = ServiceHelperReadExcel.readCellValues(inputStream).get(0);//if throws, x is -1
		}
		catch(Exception e) {
			x = -1;
		}
		assertEquals(-1,x);
	}
	
	@Test
	void inputTypeCheckPasses() throws IOException{
		Resource resource=resourceLoader.getResource("classpath:sample_stock_data.xlsx");
		InputStream inputStream = resource.getInputStream();
		StockPriceEntity stock1;
		int x = 1;
		try {	
			stock1 = ServiceHelperReadExcel.readCellValues(inputStream).get(0);
		}
		catch(Exception e) {
			x = -1;
		}
		assertEquals(1,x);
	}
 		
}
	
	

