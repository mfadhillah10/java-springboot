package com.sti.bootcamp.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sti.bootcamp.model.Transaction;

public interface TrxRepository extends PagingAndSortingRepository<Transaction, Integer> {
	
	Transaction findByAccount(int accountNumber);

}
