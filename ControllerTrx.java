package com.sti.bootcamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sti.bootcamp.dao.interfc.TransactionDao;
import com.sti.bootcamp.model.Transaction;

@RestController
@RequestMapping("/trx")
public class ControllerTrx {
	
	@Autowired
	private TransactionDao transactionDao;
	
	//get by id
	@GetMapping("/transaction")
	public String transaction(@RequestParam (value="id", defaultValue="")String id) {
		try {
			Transaction transaction = transactionDao.getById(Integer.parseInt(id));
			if (transaction == null) {
				return "Data not found";
			}
			else {
				return "ID: "+transaction.getId();
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	// create/save
	@PostMapping("/transaction")
	public Transaction create(@RequestBody Transaction transaction) throws Exception {
		transactionDao.save(transaction);
		return transaction;
	}
	
	// get list
	@GetMapping("/transactions")
	public List<Transaction> getAll() {
		try {
			List<Transaction> list = transactionDao.getList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
	// delete
	@DeleteMapping("/transaction/{id}")
	public void delete(Transaction transaction) throws Exception {
		transactionDao.delete(transaction);
	}
}
