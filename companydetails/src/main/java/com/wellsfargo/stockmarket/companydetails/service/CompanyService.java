package com.wellsfargo.stockmarket.companydetails.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.repository.CompanyRepository;
/*
 * @author
 * Team1
 * 
 */


@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;
		
	
	public List<String> getMatchingCompanies(String name){
		
		return companyRepository.findByCompanyName(name);
	}
	
	public List<Company> getAllCompanies()
	{
		return companyRepository.findAll();
		
	}
	
	
	public Optional<Company> getCompanyByCompanyCode(long companyCode)
	{
		return companyRepository.findByCompanyCode(companyCode);
		
	}
	
	
	public Company saveCompany(Company inputCompnay)
	{
		Company company = companyRepository.save(inputCompnay);
		return company;
	}
	
	
	
	public Company updateCompany(Company inputCompnay)
	{
		return companyRepository.save(inputCompnay);
		
	}
	
	
	public boolean deleteCompany(long companyId)
	{
		companyRepository.deleteById(companyId);
		Optional<Company> company = companyRepository.findById(companyId);
		if(company.isPresent())
		return false;
		return true;
	}
	
	
	
	
	
	
}
