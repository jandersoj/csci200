package edu.unca.csci202;

/**
 * a simple person class
 * 
 * @author ksanft
 *
 */
public class Person {

	protected String userId;
	protected String firstName;
	protected String lastName;
	
	/**
	 * Constructor, creates userId as first initial+lastName
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		userId=(firstName.charAt(0)+lastName).toLowerCase();
	}

	/**
	 * Constructor, attempts to create userId as first initial+lastName
	 * but if that userId is already in the Community, it appends the next
	 * available int starting with first initial+lastName+1, first initial+lastName+2, etc.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param comm the Community, used to ensure a unique userId is created
	 */
	public Person(String firstName, String lastName, Community comm) {
		this.firstName=firstName;
		this.lastName=lastName;
		String baseUserId=(firstName.charAt(0)+lastName).toLowerCase();
		// if this userId has not already been assigned, we're done
		if (!comm.containsKey(baseUserId)) {
			System.out.println("baseUserId is unique");
			userId=baseUserId;
			return;
		}
		// append the next available number to the id
		int num=1;
		userId=baseUserId+num;
		while (comm.containsKey(userId)) {
			num++;
			userId=baseUserId+num;
		}
		System.out.println("assigning userId: "+userId);
	}

	public String getUserId() {
		return userId;
	}

	public String toString() {
		return "("+userId+": "+firstName+" "+lastName+")";
	}
}
