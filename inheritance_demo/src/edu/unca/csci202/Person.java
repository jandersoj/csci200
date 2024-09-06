package edu.unca.csci202;

public class Person {
	// instance variables
	protected int age;
	protected String name;
	
	// constructors
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}

	
	
	// instance methods
	public int getAge() {
		return age;
	}



	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
