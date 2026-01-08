package multiuseratmsimulatorproject;

import java.util.ArrayList;

public class Account 
{
	
	private int atmNumber;
	private int pin;
	private double balance;
	private ArrayList <Transaction> transactions;
	
	
	

	public Account(int atmNumber, int pin, double balance) 
	{
		super();
		this.atmNumber = atmNumber;
		this.pin = pin;
		this.balance = balance;
		this.transactions = new ArrayList<> ();
	}


	public int getAtmNumber() {
		return atmNumber;
	}


	public int getPin() {
		return pin;
	}


	public double getBalance() {
		return balance;

	}
	
	public void deposit(double amount)
	{
		if(amount <= 0)
		{
			System.out.println("\n**** Invalid Deposit Amount. Please Enter a Valid Deposit Amount ****");
			return;
		}
		
		balance = balance + amount;
		transactions.add(new Transaction("Deposit ", amount, balance));
		System.out.println("**** Deposit Successfully ****");
	}
	
	public void withdraw(double amount)
	{
		if(amount <= 0)
		{
			System.out.println("\n**** Invalid Withdrawal Amount. Please Enter a Valid Withdraw Amount ****");
			return;
		}
		
		if(amount > balance)
		{
			System.out.println("\n**** Insufficient Balance ****");
			return;
		}
		
		balance = balance - amount;
		transactions.add(new Transaction("Withdraw", amount, balance));
		System.out.println("**** Withdraw Successfully ****");
	}
	
	public void transfer(Account receiver, double amount)
	{
		if(receiver == null)
		{
			System.out.println("\n**** Receiver Account Not Found ****");
			return;
		}
		
		if(amount <= 0)
		{
			System.out.println("\n**** Invalid Transfer Amount. Please Enter a Valid Amount ****");
			return;
		}
		
		if(amount > balance)
		{
			System.out.println("\n**** Insufficient Balance For Transfer ****");
			return;
		}
		
		balance = balance - amount;
		receiver.balance += amount;
		
		transactions.add(new Transaction("Transfer Sent", amount, balance));
		receiver.transactions.add(new Transaction("Transfer Received", amount, receiver.balance));
		
		System.out.println("**** Fund Transfer Successfully ****");
		
	}
	
	public void showTransactions()
	{
		if(transactions.isEmpty())
		{
			System.out.println("\n**** No Transaction Available ****");
			return;
			
		}
		
		System.out.println("\n------------ Transaction History ------------");
		for(Transaction t : transactions)
		{
			System.out.println(t);
		}
		
		
	}

	
}
