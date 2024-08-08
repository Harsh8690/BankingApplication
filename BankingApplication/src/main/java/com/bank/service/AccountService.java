package com.bank.service;

import java.util.List;

import com.bank.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccountById(long id);
	
	AccountDto deposit(long id, double amount);
	
	AccountDto withdraw(long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(long id);
	 

}
