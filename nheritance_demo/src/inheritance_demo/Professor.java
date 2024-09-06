package inheritance_demo;

public class Professor extends Person {
	private String prefix;

	public Professor(String name, int age, String prefix) {
		super(name, age);
		this.prefix = prefix;
	}
	
	public void newYear() {
		age++;
	}
	
	public String toString() {
		return prefix+" "+super.toString();
	}
}
