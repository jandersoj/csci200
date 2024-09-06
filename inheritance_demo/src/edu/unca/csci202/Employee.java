package edu.unca.csci202;

public class Employee extends Person {
	protected String jobTitle;
	
	public Employee(String name, int age, String title) {
		super(name,age);
		jobTitle=title;
	}

	@Override
	public String toString() {
		return "Employee [jobTitle=" + jobTitle + ", age=" + age + ", name=" + name + "]";
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	
}
