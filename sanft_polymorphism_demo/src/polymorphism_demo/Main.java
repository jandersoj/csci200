package polymorphism_demo;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Kevin",43);
		//Student student1 = (Student)p1;//ok with compiler but crashes at runtime
		
		System.out.println(p1);
		
		Student s1 = new Student("Pam",24,123);
		System.out.println(s1);
		
		//int studentId = p1.getId();//no, p1 is a Person, which doesn't have getId method
		
		p1 = new Student("Kevin",43,124);
		//int studentId = p1.getId();
		//s1 = p1;
		int studentId = ((Student)p1).getId();//ok with compiler and works at runtime because p1 is actually a Student
		System.out.println("that id is "+studentId);
		s1 = (Student)p1;
	}

}
