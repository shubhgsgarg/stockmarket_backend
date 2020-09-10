package com.wellsfargo.stockmarket.companydetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyDetailsApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
	return springApplicationBuilder.sources(CompanyDetailsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CompanyDetailsApplication.class, args);
	}

}
