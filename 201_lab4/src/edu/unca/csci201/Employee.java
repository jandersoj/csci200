package edu.unca.csci201;

public class Employee extends Person {

	protected int employeeId;
	protected double salary;
	
	public int getEmployeeId() {
		return employeeId;
	}

	public double getSalary() {
		return salary;
	}
	
	public Employee(String firstName, String lastName, int employeeId, double salary) {
		super (firstName, lastName);
		this.employeeId = employeeId;
		this.salary = salary;
	}
}
	
	

