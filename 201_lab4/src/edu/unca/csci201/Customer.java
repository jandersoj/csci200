package edu.unca.csci201;

public class Customer extends Person {

	protected int customerId;
	
	public int getCustomerId() {
		return customerId;
	}
	
	public Customer(String firstName, String lastName, int customerId) {
		super (firstName, lastName);
		this.customerId = customerId;
	}
}
