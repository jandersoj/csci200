package inheritance_demo;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Eli",7);
		//p1.age=123;
		System.out.println(p1);
		
		Professor p2 = new Professor("Kevin Sanft",43,"Dr.");
		System.out.println(p2);
	}

}
