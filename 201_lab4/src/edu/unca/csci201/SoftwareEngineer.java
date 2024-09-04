package edu.unca.csci201;

public class SoftwareEngineer extends Employee {

	protected String favoriteProgrammingLanguage;
	
	public String getFavoriteProgrammingLanguage() {
		return favoriteProgrammingLanguage;
	}
	
	public SoftwareEngineer(String firstName, String lastName, int employeeId, double salary, String favoriteProgrammingLanguage) {
		super (firstName, lastName, employeeId, salary);
		this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
	}
}
