package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Kevin",43);

		//System.out.println("age is: "+p1.getAge());
		System.out.println(p1);
		
		
		Employee e1 = new Employee("Becky",43,"Professor");
		System.out.println(e1);
		
		Person p2 = new Employee("Joe",20,"Barista");
		System.out.println(p2);
		((Employee)p2).getJobTitle();
	}

}
