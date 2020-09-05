package com.wellsfargo.stockmarket.stockpricedetails.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.stockmarket.stockpricedetails.entity.StockPriceEntity;

public class ServiceHelperReadExcel {

//	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\admin\\Documents\\demo\\src\\main\\resources\\sample_stock_data.xlsx";
	
//	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\admin\\Documents\\demo\\src\\main\\resources\\sample_stock_data.xlsx";
//	MultipartFile file=(MultipartFile) new File(SAMPLE_XLSX_FILE_PATH);

	public static List<StockPriceEntity> readCellValues(InputStream inputStream)
			throws Exception {

		Workbook workbook = WorkbookFactory.create(inputStream);
		


		

		List<StockPriceEntity> stockList = new ArrayList<StockPriceEntity>();

		/*
		 * Iterating over all the rows and columns in a Sheet
		 */

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);


		int counterCell = 0, counterRow = 1;

		for (Row row : sheet) {
			if (row.getFirstCellNum() == -1)
				continue;
			if (counterRow == 1) {
				counterRow = -1;
				continue;
			}
			StockPriceEntity stock = new StockPriceEntity();
			counterCell = 0;
			for (Cell cell : row) {
				switch (cell.getCellTypeEnum()) {
				// check if cell values in excel sheet are numeric type or string type
				case STRING:
					switch (counterCell) {
					// Get cell values and set the values of StockPriceEntity class by calling it's
					// setter methods
					case 0:
						String s1 = ((String) cell.getStringCellValue());
						String s2 = "";
						for (char c : s1.toCharArray()) {
							if (c >= '0' && c <= '9')
								s2 = s2 + c;
						}
						long code = Long.valueOf(s2);
						stock.setCompanyCode(code);
						break;
					case 1:
						stock.setStockExchange(cell.getRichStringCellValue().getString());
						break;

					case 4:
						stock.setStockPriceTime((String) cell.getStringCellValue());
						break;
					default:
						
						throw new RuntimeException("fail to store excel data: invalid entry");
						
					}
					break;
				case NUMERIC:
					switch (counterCell) {
					case 0:
						stock.setCompanyCode((long) cell.getNumericCellValue());
						break;
					case 2:
						stock.setCurrentPrice((double) cell.getNumericCellValue());
						break;

					case 3:
						stock.setStockPriceDate((Date) cell.getDateCellValue());
						break;
					default:	
						throw new RuntimeException("fail to store excel data: invalid entry");
					}
					break;
				default:
					throw new RuntimeException("fail to store excel data: invalid entry");

				}
				counterCell++;

			}

			stockList.add(stock);
		}

		workbook.close();
		return stockList;
	}

}
