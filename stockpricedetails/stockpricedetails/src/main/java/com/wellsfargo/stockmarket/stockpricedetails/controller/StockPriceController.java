package com.wellsfargo.stockmarket.stockpricedetails.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.stockmarket.stockpricedetails.entity.StockPriceEntity;
import com.wellsfargo.stockmarket.stockpricedetails.response.ResponseMessage;
import com.wellsfargo.stockmarket.stockpricedetails.service.StockPriceService;

@Controller
@CrossOrigin("http://localhost:4200")
public class StockPriceController {
	@Autowired
	private StockPriceService upload;
	private List<StockPriceEntity> s;

	// Run in browser using http://localhost:3003/upload and set a key with name file and values as the excel sheet
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws Throwable {
		String message = "";

		if (upload.hasExcelFormat(file)) {
			try {
				this.s = upload.save(file);
				int sz = s.size();
				long code = s.get(0).getCompanyCode();
				Date d1 = s.get(0).getStockPriceDate();
				Date d2 = s.get(sz-1).getStockPriceDate();
				message = "success " + file.getOriginalFilename() ;
				ResponseMessage ms = new ResponseMessage(message, sz, code, d1, d2);
				return ResponseEntity.status(HttpStatus.OK).body(ms);
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));

			}
		}
		message = "Please upload an excel file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

	}
}
