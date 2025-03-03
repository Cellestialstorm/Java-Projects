import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\nSelect the operation you want to perform: ");
			System.out.println("1 for Addition");
			System.out.println("2 for Substraion");
			System.out.println("3 for Multiplication");
			System.out.println("4 for Division");
			System.out.println("5 to Exit");
			System.out.print("Enter your choice: ");
			
			choice = scan.nextInt();

			if (choice >= 1 && choice <= 4) {
				System.out.print("\nEnter your first number: ");
				int num1 = scan.nextInt();

				System.out.print("Enter your second number: ");
				int num2 = scan.nextInt();
				
				performAction(choice, num1, num2);
			} else if (choice != 5) {
				System.out.println("\nEnter a valid choice!!");
			}
		} while (choice != 5);

		System.out.println("\nThank you for using this calculator");
		scan.close();
	}

	private static void performAction(int choice, int num1, int num2) {
		switch(choice) {
			case 1: 
				System.out.println("\nMultiplication of these numbers is " + (num1 * num2));
				break;

			case 2: 
				System.out.println("\nAddition of these numbers is " + (num1 + num2));
				break;

			case 3:
				System.out.println("\nSubtraction of these numbers is " + (num1 - num2));
				break;

			case 4: 
				if (num2 == 0) {
					System.out.println("Can't divide by zero");
					break;
				} else {
					System.out.printf("\nDivision of these numbers is %.2f%n", ((double)num1 / num2));
					break;
				}
		}
	}
} 
