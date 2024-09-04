package edu.unca.csci201;

public class Course {
	private String prefix;
	private int number;
	public Course(String prefix, int number) {
		this.prefix = prefix;
		this.number = number;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Course [prefix=" + prefix + ", number=" + number + "]";
	}
	
	
	
}
