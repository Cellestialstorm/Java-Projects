import java.util.*;

public class ATMSystem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<Integer, String[]> users = FileHandler.readUsers();
		
		System.out.print("Enter User ID: ");
		int userID = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter PIN: ");
		String enteredPin = scan.nextLine();
		
		if (!users.containsKey(userID) || !users.get(userID)[1].equals(enteredPin)) {
			System.out.println("Invalid credentials! Exiting...");
			return;
		}
		
		String name = users.get(userID)[0];
		double balance = Double.parseDouble(users.get(userID)[2]);
		
		ATM atm = new ATM(userID, name, enteredPin, balance);
		
		Thread t1 = new Thread(() -> atm.deposit(1000));
		Thread t2 = new Thread(() -> atm.withdraw(200));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		atm.checkBalance();
		scan.close();
	}
}