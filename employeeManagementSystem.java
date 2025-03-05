public class employeeManagementSystem {
	public static void main(String[] args) {
		fulltimeEmployee emp1 = new fulltimeEmployee("Dharma Kumar", 101, 23400.19);
		parttimeEmployee emp2 = new parttimeEmployee("Lushan Sharma", 201, 100, 24);
		intern emp3 = new intern("Solan Gurung", 301, 10000.00);
		
		System.out.println("\n--- Full-Time Employee ---");
        emp1.displayInfo();
        emp1.benefits();
		
		System.out.println("\n--- Part-Time Employee ---");
		emp2.displayInfo();
		emp2.workedFor();
		
		System.out.println("\n--- Intern Employee ---");
		emp3.displayInfo();
		emp3.internshipPeriod();
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
	
	void displayInfo() {
		System.out.println("Name: " + name); 
		System.out.println("Id: " + id); 
		System.out.println("Salary: $" + salary); 
	}
}

class fulltimeEmployee extends employee {
	public fulltimeEmployee(String name, int id, double salary) {
		super(name, id, salary);
	}
	
	void benefits() {
		System.out.println(name + " enjoys health benefits");
	}
}

class parttimeEmployee extends employee {
	int hoursWorked;
	
	public parttimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
		super(name, id, hourlyRate * hoursWorked);
		this.hoursWorked = hoursWorked;
	}
	
	void workedFor() {
		System.out.println(name + " worked for" + hoursWorked + " hours this week");
	}
}

class intern extends employee {
	public intern(String name, int id, double salary) {
		super(name, id, salary);
	}
	
	void internshipPeriod() {
		System.out.println(name + " is a intern for 6 months");
	}
}