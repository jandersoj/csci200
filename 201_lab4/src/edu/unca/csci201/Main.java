package edu.unca.csci201;

//Josie Anderson, Jamie Nale

public class Main {

	public static void main(String[] args) {
		Person p1 = new Customer("Jane", "Doe", 1);
		Employee e1 = new Employee("Jim", "Doe", 2, 80000.00);
		SoftwareEngineer se1 = new SoftwareEngineer("Jamie", "Nale", 3, 120000.00, "Java");
		Janitor j1 = new Janitor("Josie", "Anderson", 4, 300000.00, "Chem lab");
		
		System.out.println(p1.getLastName()+ ", " + p1.getFirstName());
		System.out.println(e1.getSalary()+ ", " + e1.getEmployeeId());
		System.out.println(se1.getFirstName()+ ", " + se1.getFavoriteProgrammingLanguage());
		System.out.println(j1.getFirstName()+ ", " + j1.getBuilding());

		
	}

}
