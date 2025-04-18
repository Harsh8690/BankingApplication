package com.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.bank.dto.AccountDto;
import com.bank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	

	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}


	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){

		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable long id){
	AccountDto accountDto=	accountService.getAccountById(id);
	
		return ResponseEntity.ok(accountDto);
	}
	
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable long id,@RequestBody HashMap<String, Double> request){
	
	double amount=request.get("amount");
	AccountDto accountDto=	accountService.deposit(id, amount);
		
		
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long id,@RequestBody Map<String,Double> request){
		
		double amount=request.get("amount");
		AccountDto accountDto=accountService.withdraw(id, amount);
		
		return ResponseEntity.ok(accountDto);
	}
	
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountDto=accountService.getAllAccounts();
		return ResponseEntity.ok(accountDto);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable long id){
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok("Account delete successfully...!");
	}
	
}
