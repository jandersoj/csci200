package edu.unca.csci201;

public class Student {
	private Person person;
	private int studentId;
	
	public static int count=0; // initialize static variable ok
	
	public Student(Person person) {
		this.person=person;
		studentId=count++;
	}

	public Student(String first, String last, int age) {
		this.person=new Person(first,last,age);
		studentId=count++;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	@Override
	public String toString() {
		return "Student [person=" + person + ", studentId=" + studentId + "]";
	}
	
}
