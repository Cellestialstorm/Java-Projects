import java.util.Scanner;

public class bankAccount {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice;
		
		System.out.println("Welcome to our Bank!");
		System.out.print("Enter the name of the Account Holder: ");
		String name = scan.nextLine();
		System.out.print("Enter the initial Deposite amount: ");
		double initialBalance = scan.nextDouble();
		bankAcc Account = new bankAcc(name, initialBalance);

		do {
			System.out.println("\nSelect the operation you want to perform: ");
			System.out.println("1 to check Account information");
			System.out.println("2 to update Account name");
			System.out.println("3 to deposite Amount");
			System.out.println("4 to Withdraw Money");
			System.out.println("5 to Exit");
			System.out.print("Enter your choice: ");
		
			choice = scan.nextInt();
			scan.nextLine(); //consumes the new line character caused by nextInt() 

			if (choice >= 1 && choice <= 4) {
				switchCases(choice, scan, Account);
			} else if (choice != 5) {
				System.out.println("Enter a valid choice!");
			}
		} while(choice != 5);
		scan.close();
		System.out.println("Thank you for using our services!");
	}
	
	private static void switchCases(int choice, Scanner scan, bankAcc Account) {
		switch (choice) {
			case 1:
				System.out.println("\nAccount Holder: " + Account.getAccountHolder());
				System.out.println("Balance: " + Account.getBalance() + "\n");
				break;
				
			case 2:
				scan.nextLine();
				System.out.print("\nEnter new name for Account Holder: ");
				String newName = scan.nextLine();
				Account.changeAccountHolder(newName);
				break;

			case 3:
				System.out.print("\nEnter the Amount to be Deposited: ");
				double Amount = scan.nextDouble();
				Account.depositMoney(Amount);
				break;

			case 4:
				System.out.print("\nEnter the Amount to be Withdrawn: ");
				Amount = scan.nextDouble();
				Account.withdrawMoney(Amount);
				break;
		}
	}
}

class bankAcc {
	private String accHolder;
	private double balance;
	
	// Constructor 
	public bankAcc(String accHolder, double initialBalance) {
		this.accHolder = accHolder;
		if (initialBalance > 0) {
			this.balance = initialBalance;
		} else {
			this.balance = 0;
		}
	}
	
	//getter method to get Account Holder
	public String getAccountHolder() {
		return accHolder;
	}
	
	//setter method to change Account Holder
	public void changeAccountHolder(String accHolder) {
		this.accHolder = accHolder;
		System.out.println("Account Holder changed successfully!");
	}
	
	//getter method to get Balance
	public double getBalance() {
		return balance;
	}
	
	//setter method to deposit Money
	public void depositMoney(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: $" + amount);
		} else {
			System.out.println("Invalid deposit amount!");
		}
	}

	//setter method to witdhraw Money
	public void withdrawMoney(double amount) {
		if (amount > 0 && amount < balance) {
			balance -= amount;
			System.out.println("Withdrawn: $" + amount);
		} else {
			System.out.println("Invalid withdrawal amount or Insufficient Balance!");
		}
	}
}