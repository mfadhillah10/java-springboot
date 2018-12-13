package com.sti.bootcamp.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sti.bootcamp.dao.impl.AccountDaoImpl;
import com.sti.bootcamp.dao.impl.CustomerDaoImpl;
import com.sti.bootcamp.dao.impl.TrxDaoImpl;
import com.sti.bootcamp.dao.interfc.AccountDao;
import com.sti.bootcamp.dao.interfc.CustomerDao;
import com.sti.bootcamp.dao.interfc.TransactionDao;

@Configuration
public class DaoSpringConfig {
	
	@Bean
	public CustomerDao customerDao() {
		
		return new CustomerDaoImpl();
	}
	
	@Bean
	public AccountDao accountDao() {
		return new AccountDaoImpl();
	}
	
	@Bean
	public TransactionDao transactionDao() {
		return new TrxDaoImpl();
	}
}
