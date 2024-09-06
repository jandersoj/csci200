package edu.unca.csci201;

public class Main {

	public static void main(String[] args) {
//		System.out.println("Welcome to my cool university software!");
//		System.out.println("What action would you like to do:");
//		System.out.println("1. Create a new student");
//		System.out.println("2. Create a new instructor");
//		System.out.println("3. Create a new course");
//		System.out.println("4. Enroll student in a course");
		
		Person p1 = new Person("Kevin","Sanft",43);
		Student s1 = new Student(p1);
		System.out.println(s1);
		System.out.println("count="+Student.count);
		
		Student s2 = new Student("J.","Human",22);
		System.out.println(s2);
		Person p2 = s2.getPerson();
		
		Course csci201 = new Course("CSCI",201);
		EnrolledCourse csci201fall = new EnrolledCourse(csci201);
		
		System.out.println(csci201fall);
		csci201fall.enrollStudent(s1);
		csci201fall.enrollStudent(s2);
		System.out.println(csci201fall);
		csci201fall.enrollStudent(new Student("Your","Name",33));
		System.out.println(csci201fall);
	}

}
