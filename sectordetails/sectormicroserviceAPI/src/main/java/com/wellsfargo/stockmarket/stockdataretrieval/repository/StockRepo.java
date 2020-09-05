package com.wellsfargo.stockmarket.stockdataretrieval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.stockmarket.stockdataretrieval.model.Stock;


public interface StockRepo extends JpaRepository<Stock,Integer> {

	List<Stock> findByCompanyCode(int companyCode);

}
