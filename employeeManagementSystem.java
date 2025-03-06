import java.util.ArrayList;
import java.util.Scanner;

public class employeeManagementSystem {
	public static void main(String[] args) {
		ArrayList<fulltimeEmployee> fulltimeEmployeeList = new ArrayList<>();
		ArrayList<parttimeEmployee> parttimeEmployeeList = new ArrayList<>();
		ArrayList<intern> internList = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		int choice;
		
		while (true) {
			System.out.println("\n===== Main Menu =====");
			System.out.println("1. Display all employees");
			System.out.println("2. Edit Full-Time Employee List");
			System.out.println("3. Edit Part-Time Employee List");
			System.out.println("4. Edit Intern List");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			
			switch (choice) {
				case 1: 
					System.out.println("\n--- Full-Time Employees ---");
					if (fulltimeEmployeeList.isEmpty()) {
						System.out.println("No employee record found!");
					} else {
						for (fulltimeEmployee emp : fulltimeEmployeeList) {
							emp.displayInfo();
						}
					}
					System.out.println("\n--- Part-Time Employees ---");
					if (parttimeEmployeeList.isEmpty()) {
						System.out.println("No employee record found");
					} else {
						for (parttimeEmployee emp : parttimeEmployeeList) {
							emp.displayInfo();
						}
					}
					System.out.println("\n--- Intern ---");
					if (internList.isEmpty()) {
						System.out.println("No employee record found");
					} else {
						for (intern emp : internList) {
							emp.displayInfo();
						}
					}
					break;
				case 2: 
					fullTimeMenu(fulltimeEmployeeList, scan);
					break;
				case 3: 
					partTimeMenu(parttimeEmployeeList, scan);
					break;
				case 4:
					internMenu(internList, scan);
					break;
				case 5:
					System.out.println("Exiting the program.......");
					scan.close();
					return;
				default :
					System.out.println("\n----- Invalid Choice! -----");
					break;
			}
		}
	}
	
	public static void fullTimeMenu(ArrayList<fulltimeEmployee> fulltimeEmployeeList, Scanner scan) {
		while (true) {
			System.out.println("\n*** Full-Time Employee Menu ***");
			System.out.println("1. List Full-Time Employees");
			System.out.println("2. Add new Employee");
			System.out.println("3. Delete a Employee");
			System.out.println("4. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scan.nextInt();
			scan.nextLine();
		
			switch(choice) {
				case 1:
					System.out.println("\n--- Full-Time Employees ---");
					if (fulltimeEmployeeList.isEmpty()) {
						System.out.println("No employee record found!");
					} else {
						for (fulltimeEmployee emp : fulltimeEmployeeList) {
							emp.displayInfo();
						}
					}
					break;
				case 2:
					System.out.print("Name: ");
					String name = scan.nextLine();
					System.out.print("ID: ");
					int ID = scan.nextInt();
					System.out.print("Salary: ");
					double salary = scan.nextDouble();
					
					fulltimeEmployeeList.add(new fulltimeEmployee(name, ID, salary));
					System.out.println("Employee added Succesfully!");
					break;
				case 3: 
					System.out.print("Enter ID: ");
					int id = scan.nextInt();
					boolean removed = ListUtils.removeById(fulltimeEmployeeList, id);
					
					if (removed) {
						System.out.println("\nEmployee removed successfully!");
					} else {
						System.out.println("\nEmployee not found in records!");
					}
					break;
				case 4: 
					return;
				default :
					System.out.println("\n----- Invalid Choice! -----");
			}
		}
	}
	
	public static void partTimeMenu(ArrayList<parttimeEmployee> parttimeEmployeeList, Scanner scan) {
		while (true) {
			System.out.println("\n*** Part-Time Employee Menu ***");
			System.out.println("1. List Part-Time Employees");
			System.out.println("2. Add new Employee");
			System.out.println("3. Delete a Employee");
			System.out.println("4. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1:
					System.out.println("\n--- Part-Time Employees ---");
					if (parttimeEmployeeList.isEmpty()) {
						System.out.println("No employee record found!");
					} else {
						for (parttimeEmployee emp : parttimeEmployeeList) {
							emp.displayInfo();
						}
					}
					break;
				case 2:
					System.out.print("Name: ");
					String name = scan.nextLine();
					System.out.print("ID: ");
					int ID = scan.nextInt();
					System.out.print("Hourly Rate: ");
					double hourlyRate = scan.nextDouble();
					System.out.print("Hours Worked: ");
					int hoursWorked = scan.nextInt();
					
					parttimeEmployeeList.add(new parttimeEmployee(name, ID, hourlyRate, hoursWorked));
					System.out.println("Employee added Succesfully!");
					break;
				case 3: 
					System.out.print("Enter ID: ");
					int id = scan.nextInt();
					boolean removed = ListUtils.removeById(parttimeEmployeeList, id);;
					
					if (removed) {
						System.out.println("\nEmployee removed successfully!");
					} else {
						System.out.println("\nEmployee not found in records!");
					}
					break;
				case 4: 
					return;
				default :
					System.out.println("\n----- Invalid Choice! -----");
			}
		}
	}
	
	public static void internMenu(ArrayList<intern> internList, Scanner scan) {
		while (true) {
			System.out.println("\n*** Intern Menu ***");
			System.out.println("1. List Interns");
			System.out.println("2. Add new Employee");
			System.out.println("3. Delete a Employee");
			System.out.println("4. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1:
					System.out.println("\n--- Interns ---");
					if (internList.isEmpty()) {
						System.out.println("No employee record found!");
					} else {
						for (intern emp : internList) {
							emp.displayInfo();
						}
					}
					break;
				case 2:
					System.out.print("Name: ");
					String name = scan.nextLine();
					System.out.print("ID: ");
					int ID = scan.nextInt();
					System.out.print("Salary: ");
					double salary = scan.nextDouble();
					
					internList.add(new intern(name, ID, salary));
					System.out.println("Employee added Succesfully!");
					break;
				case 3: 
					System.out.print("Enter ID: ");
					int id = scan.nextInt();
					boolean removed = ListUtils.removeById(internList, id);
					
					if (removed) {
						System.out.println("\nIntern removed successfully!");
					} else {
						System.out.println("\nIntern not found in records!");
					}
					break;
				case 4: 
					return;
				default :
					System.out.println("\n----- Invalid Choice! -----");
			}
		}
	}
}

class employee {
	String name;
	int id;
	double salary;
	
	public employee(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	int getId() {
		return id;
	}
	
	void displayInfo() {
		System.out.println("Id: " + id + ", Name: " + name +", Salary: $" + salary);
	}
}

class fulltimeEmployee extends employee {
	public fulltimeEmployee(String name, int id, double salary) {
		super(name, id, salary);
	}
	
	int getId() {
		return id;
	}
}

class parttimeEmployee extends employee {
	int hoursWorked;
	double hourlyRate;
	
	public parttimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
		super(name, id, hourlyRate * hoursWorked);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	int getId() {
		return id;
	}
}

class intern extends employee {
	public intern(String name, int id, double salary) {
		super(name, id, salary);
	}
	
	int getId() {
		return id;
	}
}

class ListUtils {
    public static <T> boolean removeById(ArrayList<T> list, int id) {
        for (T item : list) {
            if ((item instanceof fulltimeEmployee && ((fulltimeEmployee) item).getId() == id) ||
                (item instanceof parttimeEmployee && ((parttimeEmployee) item).getId() == id) ||
				(item instanceof intern && ((intern) item).getId() == id)) {
                list.remove(item);
                return true;
            }
        }
        return false;
    }
}