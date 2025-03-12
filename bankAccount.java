import java.util.Scanner;
import java.io.Console;

public class bankAccount {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Console console = System.console();
		int choice;
		
		System.out.println("Welcome to our Bank!");
		System.out.print("Enter the name of the Account Holder: ");
		String name = scan.nextLine();
		System.out.print("Enter the initial Deposite amount: ");
		double initialBalance = scan.nextDouble();
		String pinStr;
		while (true) {
			if (console != null) {
				char[] pinArray = console.readPassword("Create PIN (4 Digits only): ");
				pinStr = new String(pinArray);
			} else {
				System.out.print("Create PIN (4 digits only): ");
				pinStr = scan.nextLine();
			}
			
			if (pinStr.matches("\\d{4}")) {
				break;
			} else {
				System.out.println("Invalid PIN! Please enter a 4-digit number.");
			}
		}
		int pin = Integer.parseInt(pinStr);
		System.out.println("Pin set Successfully");
		
		scan.nextLine();
		bankAcc Account = new bankAcc(name, initialBalance, pin);

		do {
			System.out.println("\nSelect the operation you want to perform: ");
			System.out.println("1 to check Account information");
			System.out.println("2 to update Account name");
			System.out.println("3 to deposite Amount");
			System.out.println("4 to Withdraw Money");
			System.out.println("5 to Make Payment");
			System.out.println("6 to Exit");
			System.out.print("Enter your choice: ");
		
			choice = scan.nextInt();
			scan.nextLine(); //consumes the new line character caused by nextInt() 

			if (choice >= 1 && choice <= 5) {
				try {
					switchCases(choice, scan, Account, console);
				} catch (IllegalArgumentException e) {
						System.out.println("Error: " + e.getMessage());
				} catch (InsufficientBalanceException e) {
						System.out.println("Error: " + e.getMessage());
				}
			} else if (choice != 6) {
				System.out.println("Enter a valid choice!");
			}
		} while(choice != 6);
		scan.close();
		System.out.println("Thank you for using our services!");
	}
	
	private static void switchCases(int choice, Scanner scan, bankAcc Account, Console console) throws InsufficientBalanceException {
		switch (choice) {
			case 1:
				System.out.println("\nAccount Holder: " + Account.getAccountHolder());
				System.out.println("Balance: " + Account.getBalance() + "\n");
				break;
				
			case 2:
				System.out.print("\nEnter new name for Account Holder: ");
				String newName = scan.nextLine();
				Account.changeAccountHolder(newName);
				break;

			case 3:
				int n = 3;
				String pinStr;
				while (n != 0) {
					if (console != null) {
						char[] pinArray = console.readPassword("/nEnter PIN (4 Digits only): ");
						pinStr = new String(pinArray);
					} else {
						System.out.print("Create PIN (4 digits only): ");
						pinStr = scan.nextLine();
					}
					
					int pin = Integer.parseInt(pinStr);
					
					if (pin == Account.getPin()) {
						break;
					} else {
						System.out.println("Invalid PIN! Please enter a 4 digit number (Attempts left: " + (n-1) + ").");
					}
					n -= 1;
				}
				
				if (n == 0) {
					System.out.println("Invalid PIN! Transaction Aborted");
					break;
				} else {
					System.out.print("\nEnter the Amount to be Deposited: ");
					double Amount = scan.nextDouble();
					Account.depositMoney(Amount);
				}
				break;

			case 4:
				n = 3;
				while (n != 0) {
					if (console != null) {
						char[] pinArray = console.readPassword("Create PIN (4 Digits only): ");
						pinStr = new String(pinArray);
					} else {
						System.out.print("Create PIN (4 digits only): ");
						pinStr = scan.nextLine();
					}
					
					int pin = Integer.parseInt(pinStr);
					
					if (pin == Account.getPin()) {
						break;
					} else {
						System.out.println("Invalid PIN! Please enter a 4 digit number (Attempts left: " + (n-1) + ").");
					}
					n -= 1;
				}
				if (n != 0) {
					System.out.print("\nEnter the Amount to be Withdrawn: ");
					double Amount = scan.nextDouble();
					Account.withdrawMoney(Amount);
				} else {
					System.out.println("Invalid PIN! Transaction Aborted");
				}
				break;
			case 5:
				System.out.print("Name of Recipient: ");
				String RecipientName = scan.nextLine();
				System.out.print("Recipient Account ID: ");
				int id = scan.nextInt();
				System.out.print("Amount: ");
				double amount = scan.nextDouble();
				System.out.print("Enter your pin: ");
				int pin = scan.nextInt();
				if (Account.getPin() == pin) {
					Account.makePayment(RecipientName, amount, id);
				} else {
					System.out.print("Invalid pin!");
				}
		}
	}
}

class bankAcc implements Payment {
	private String accHolder;
	private double balance;
	private int pin;

	// Constructor 
	public bankAcc(String accHolder, double initialBalance, int pin) {
		this.accHolder = accHolder;
		if (initialBalance > 0) {
			this.balance = initialBalance;
		} else {
			this.balance = 0;
		}
		this.pin = pin;
	}
	
	//getter method to get Account Holder
	public String getAccountHolder() {
		return accHolder;
	}
	
	//getter method to get pin
	public int getPin() {
		return pin;
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
		if (amount < 0) {
			throw new IllegalArgumentException("Deposit amount must be greater than zero.");
		}
		balance += amount;
		System.out.println("Deposited: $" + amount);
	}

	//setter method to witdhraw Money
	public void withdrawMoney(double amount) throws InsufficientBalanceException {
		if (amount < 0) {
			throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
		} 
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance!\nBalance: $" + balance);
		}
		balance -= amount;
		System.out.println("Withdrawn: $" + amount);
	}
	
	//setter method to make payment
	public void makePayment(String RecipientName, double amount, int id) {
		if (amount > 0 && amount < balance) {
			balance -= amount;
			System.out.println("Transferred $" + amount + " to " + RecipientName + " bearing ID " + id);
		} else {
			System.out.println("Invalid Transfer Amount or Insufficient Balance!");
		}
	}
}

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

interface Payment {
	void makePayment(String RecipientName, double amount, int id);
}