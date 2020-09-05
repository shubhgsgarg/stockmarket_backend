package com.wellsfargo.stockmarket.stockpricedetails.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.stockmarket.stockpricedetails.entity.StockPriceEntity;
import com.wellsfargo.stockmarket.stockpricedetails.helper.ServiceHelperReadExcel;
import com.wellsfargo.stockmarket.stockpricedetails.repository.StockPriceRepository;



@Service
public class StockPriceService {

	 @Autowired
	 StockPriceRepository repository;
	 
	 public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	 
	 public boolean hasExcelFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }
	    

	  public List<StockPriceEntity> save(MultipartFile file) throws Throwable {
		  try {
	    List<StockPriceEntity> result = ServiceHelperReadExcel.readCellValues(file.getInputStream());
	    	
	      repository.saveAll(result);
	      return result;
		  }
		  
		  catch (Exception e) {
			  
	      throw new RuntimeException("fail to store excel data: ");
	    }
	  }
}
