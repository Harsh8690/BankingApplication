package com.bank.mapper;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		
		Account account=new Account(
				accountDto.getId(), 
				accountDto.getAccountHolderName(),
				accountDto.getBalance());
		
		return account;
	}

	public static AccountDto mapToDto(Account account) {
		
		AccountDto accountDto=new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		return accountDto; 
	}

}
