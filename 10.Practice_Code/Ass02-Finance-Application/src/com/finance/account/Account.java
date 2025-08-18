package com.finance.account;

public class Account 
{
	private String holderName;
	private double balance;
	
	public Account() {};
	
	public Account(String holderName,double balance)
	{
		this.holderName=holderName;
		this.balance=balance;
	}
	
	public void deposit(double amount)
	{
		balance +=amount;
	}
	
	public String getHolderName() 
	{
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void withdrawal(double amount)
	{
		if(balance>=amount)
		{
			balance-=amount;
		}
		else
		{
			System.out.println("Insuffiesent Balance !!");
		}
	}
	
	public void showBalance()
	{
		System.out.println(holderName+" Balance "+balance);
	}
	
}
