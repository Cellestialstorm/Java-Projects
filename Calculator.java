import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inp = 0;
		int num1, num2;
		while (inp != 5) {
			System.out.println("\nSelect the operation you want to perform:\n1 for multiplication\n2 for Addition\n3 for Substraction\n4 for Division\n5 to exit\n");
			System.out.print("Enter your choice: ");
			inp = scan.nextInt();

			if (inp == 5) {
				System.out.println("Thank you for uisng this calculator");
				break;
			}

			switch(inp) {
				case 1: 
					System.out.print("Enter your first number: ");
					num1 = scan.nextInt();

					System.out.print("Enter your second number: ");
					num2 = scan.nextInt();

					System.out.println("\nMultiplication of these numbers is " + (num1 * num2));
					break;

				case 2: 
					System.out.print("Enter your first number: ");
					num1 = scan.nextInt();

					System.out.print("Enter your second number: ");
					num2 = scan.nextInt();

					System.out.println("\nAddition of these numbers is " + (num1 + num2));
					break;

				case 3:
					System.out.print("Enter your first number: ");
					num1 = scan.nextInt();

					System.out.print("Enter your second number: ");
					num2 = scan.nextInt();

					System.out.println("\nSubtraction of these numbers is " + (num1 - num2));
					break;

				case 4: 
					System.out.print("Enter your first number: ");
					num1 = scan.nextInt();

					System.out.print("Enter your second number: ");
					num2 = scan.nextInt();

					if (num2 == 0) {
						System.out.println("Can't divide by zero");
						break;
					} else {
						System.out.printf("\nDivision of these numbers is %.2f%n", ((double)num1 / num2));
						break;
					}

				default: System.out.println("\nPlease select a valid operation");
			}
		}
		scan.close();
	}
} 
