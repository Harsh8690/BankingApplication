package com.bank.dto;

public class AccountDto {
	
	private long id;
	private String accountHolderName;
	private double balance;
	
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountDto(long id, String accoutnHolderName, double balance) {
		super();
		this.id = id;
		this.accountHolderName = accoutnHolderName;
		this.balance = balance;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accoutnHolderName) {
		this.accountHolderName = accoutnHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
