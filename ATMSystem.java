package multiuseratmsimulatorproject;

import java.util.HashMap;
import java.util.Scanner;

public class ATMSystem 
{
	
	private static HashMap<Integer, Account> accounts = new HashMap<> ();
	private static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) 
	{
		
		accounts.put(1111, new Account(1111, 1234, 5000));
		accounts.put(2222, new Account(2222, 5678, 8000));
		accounts.put(3333, new Account(3333, 91011, 12000));
		accounts.put(4444, new Account(4444, 121314, 10000));
		
		System.out.println("===== Welcome to Multi User ATM System =====");
		
		while(true)
		{
			System.out.print("\nEnter ATM Number : - ");
			int atmNo = sc.nextInt();
			
			System.out.print("Enter ATM PIN : - ");
			int pin = sc.nextInt();
			
			Account user = accounts.get(atmNo);
			
			if(user != null && user.getPin() == pin)
			{
				System.out.println("\nLogin Successfully!");
				userMenu(user);
				
			}
			
			else 
			{
				System.out.println("Invalid ATM Number or PIN");
			}
		}
		
	}
	
	private static void userMenu(Account user)
	{
		while(true)
		{
			System.out.println("\n1. For Balance Inquiry");
			System.out.println("2. For  Deposit");
			System.out.println("3. For Withdraw");
			System.out.println("4. For Fund Transfer");
			System.out.println("5. For Transaction History");
			System.out.println("6. For Logout");
			System.out.println("7. For Exit");
			
			System.out.print("Choose an Option among Above Options : - ");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1 :
					System.out.print("\n**** Current Balance **** : - "+user.getBalance());
					break;
					
				case 2 :
					System.out.print("\nEnter Amount to Deposit : - ");
					double depo = sc.nextDouble();
					user.deposit(depo);
					break;
					
				case 3 :
					System.out.print("\nEnter a Amount to Withdraw Balance : - ");
					double wd = sc.nextDouble();
					user.withdraw(wd);
					break;
					
				case 4 :
					System.out.print("\nEnter Receiver ATM Number : - ");
					int recAtm = sc.nextInt();
					
					Account receiver = accounts.get(recAtm);
					if(receiver == null)
					{
						System.out.print("Receiver Account Not Found");
						
					}
					
					else
					{
						
						System.out.print("Enter a Amount to Transfer : - ");
						double amt = sc.nextDouble();
						user.transfer(receiver, amt);
						
					}
					
					break;
					
				case 5 :
					user.showTransactions();
					break;
					
					
				case 6 :
					System.out.println("\nLogged Out Successfully !");
					return;

				case 7 :
					System.out.println("\n***** Thank You For Visiting Our ATM. Have a Nice Day *****");
					System.exit(0);
					
					
				default :
					System.out.println("Invalid Option");
					
			}
			
		}
		
	}

}


