package com.bank.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;
import com.bank.mapper.AccountMapper;
import com.bank.repo.AccountRepo;
import com.bank.service.AccountService;


@Service
public class AccountImp implements AccountService{

	private AccountRepo accountRepo;
	
	public AccountImp(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override 
	public AccountDto createAccount(AccountDto accountDto) {

		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountRepo.save(account);
		
		return AccountMapper.mapToDto(savedAccount);
	}
	
	public AccountDto getAccountById(long id) {
		
	Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist..!"));
		
	return AccountMapper.mapToDto(account);
	}

	@Override
	public AccountDto deposit(long id, double amount) {
		
		Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist..!"));

		double totalBalance= account.getBalance()+amount;
		
		account.setBalance(totalBalance);
		Account savedAccount =accountRepo.save(account);
		
		return AccountMapper.mapToDto(savedAccount);
		
	}

	@Override
	public AccountDto withdraw(long id, double amount) {

	Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist..!"));
	
	if(account.getBalance()<amount) {
		
			throw new RuntimeException("Insufficient Balance");	
		
	}
	double totalBalance=account.getBalance()-amount;
	account.setBalance(totalBalance);
	
	Account savedBalance=accountRepo.save(account);
	
	 return AccountMapper.mapToDto(savedBalance);
	}

	@Override
	public List<AccountDto> getAllAccounts() {

		return accountRepo.findAll().stream().map((account)->AccountMapper.mapToDto(account))
		.collect(Collectors.toList());
		
	}

	@Override
	public void deleteAccount(long id) {
		
		Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist..!"));
		accountRepo.delete(account);
		
	}

	
	
	

}
