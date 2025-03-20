public class ATM {
	private int userID;
	private String name;
	private String pin;
	private double balance;
	
	public ATM(int userID, String name, String pin, double balance) {
		this.userID = userID;
		this.name = name;
		this.pin = pin;
		this.balance = balance;
	}
	
	public void checkBalance() {
		System.out.println("Current Balance: " + balance);
	}
	
	public synchronized void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount!");
			return;
		}
		
		balance += amount;
		FileHandler.updateBalance(userID, balance);
		FileHandler.logTransaction(userID, "Deposit", amount);
		System.out.println("Deposited: $" + amount);
	}
	
	public synchronized void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount!");
			return;
		}
		
		if (amount > balance) {
			System.out.println("Insufficient balance!");
			return;
		}
		
		balance -= amount;
		FileHandler.updateBalance(userID, balance);
		FileHandler.logTransaction(userID, "Withdraw", amount);
		System.out.println("Withdrawn: $" + amount);
	}
} 