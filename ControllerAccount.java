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

import com.sti.bootcamp.dao.interfc.AccountDao;
import com.sti.bootcamp.model.Account;

@RestController
@RequestMapping("/acc")
public class ControllerAccount {
	@Autowired
	private AccountDao accountDao;
	
	// create/save
	@PostMapping("/account")
	public Account create(@RequestBody Account account) throws Exception {
		accountDao.save(account);
		return account;
	}
	
	//get by id
	@GetMapping("/account")
	public String show(@RequestParam (value="account_number", defaultValue="") String accountnumber) {
		try {
			Account show= accountDao.getById(Integer.parseInt(accountnumber));
			if (show == null) {
				return "Data not found";
			} else {
				return "Account Number :"+show.getAccountNumber();
			}	
		} catch (Exception e) {
			return "Wrong input format";
			// TODO: handle exception
		}
	}
	
	// getList
	@GetMapping("/accounts")
	public List<Account> getAll() {
		try {
			List<Account> list = accountDao.getList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	//delete
	@DeleteMapping("/account/{custnumber}")
	public void delete(Account account) throws Exception {
		accountDao.delete(account);
	}	
}