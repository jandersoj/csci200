package edu.unca.csci201;

public class Janitor extends Employee {

	protected String building;
	
	public String getBuilding() {
		return building;
	}
	
	public Janitor(String firstName, String lastName, int employeeId, double salary, String building) {
		super(firstName, lastName, employeeId, salary);
		this.building = building;
	}
	
}
