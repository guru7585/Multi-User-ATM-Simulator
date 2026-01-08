package multiuseratmsimulatorproject;

import java.time.LocalDateTime;

public class Transaction 
{
	private String type;
	private double amount;
	private double balance;
	private LocalDateTime dateTime;
	
	
	public Transaction(String type, double amount, double balance) {
		super();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.dateTime = LocalDateTime.now();
	}
	
	

	public String toString()
	{
		return dateTime +" | "+ type + " | Amount : - "+ amount+" | Balance : - " + balance;
	}
	
	

}
