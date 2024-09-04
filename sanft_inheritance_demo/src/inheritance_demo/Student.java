package inheritance_demo;

/* alternative to inheritance ("composition") */

public class Student {
	private Person person;
	private int studentId;
	
	public Person getPerson() {
		return person;
	}
	
	public String toString() {
		return person.getName()+", id="+studentId;
	}
}
