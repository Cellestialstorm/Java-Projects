import java.io.*;
import java.util.Scanner;

public class StudentRecordSystem {
	public static void main(String[] args) {
		File records = new File("Records.txt");
		Scanner scan = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n---------Student Record System---------");
			System.out.println("1. Display Students");
			System.out.println("2. Add Student");
			System.out.println("3. Remove Student");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1:
					try {
						displayStudents(records);
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 2:
					System.out.print("Name: ");
					String name = scan.nextLine();
					System.out.print("ID: ");
					long id = scan.nextLong();
					System.out.print("Marks: ");
					int marks = scan.nextInt();
					try {
						addStudent(name, id, marks);
					} catch (IOException e) {
						System.out.println("Error: " + e.getMessage());
					}
					break;
					
				case 3:
					System.out.print("Student ID to be removed: ");
					String removeID = scan.nextLine();
					if (removeID.length() == 12) {
						try {
							removeStudent(records, removeID);
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						break;
					} else {
						System.out.println("Invalid ID!");
						break;
					}
					
				case 4:
					System.out.println("Exiting the system..........Thank you");
					break;
					
				default:
					System.out.print("Invalid choice!");
					break;
			}
		} while(choice != 4);
	}
	
	public static void displayStudents(File records) throws IOException{
		System.out.println("\n-----Students List-----");
		if (!records.exists()) {
			throw new FileNotFoundException("Error: File not found!");
		}
		
		if (records.length() == 0) {
			throw new IOException("No data found!");
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(records))) {
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
	
	private static void addStudent(String name, long id, int marks) throws IOException {
		try (FileWriter appendRecords = new FileWriter("Records.txt", true);) {
			appendRecords.write("\nName: " + name + ", ID: " + id + ", Marks: " + marks);
			System.out.println("Student added Successfully!");
		}
	}
	
	private static void removeStudent(File records, String removeID)  throws IOException {
		File tempFile = new File("tempFile.txt");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(records)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
			String currentLine;
			int lineNumber = 0;
			boolean found = false;
			
			while ((currentLine = reader.readLine())!= null) {
				lineNumber++;
				
				if (currentLine.contains(removeID)) {
					found = true;
					continue;
				}
				
				writer.write(currentLine);
				writer.newLine();
			}
			
			if (!found) {
				System.out.println("Student not Found!");
			}
			
		} catch (IOException e) {
			System.out.println("Error while processing the file: " + e.getMessage());
		}
		
		if (records.delete()) {
			if (!tempFile.renameTo(records)) {
				System.out.println("Error: Could not update student records.");
			} else {
				System.out.println("Student removed Successfully");
			}
		} else {
			System.out.println("Error: Could not update student records.");
		}
	}
}