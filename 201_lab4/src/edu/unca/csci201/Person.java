package edu.unca.csci201;

public abstract class Person {

	protected String firstName;
	protected String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
