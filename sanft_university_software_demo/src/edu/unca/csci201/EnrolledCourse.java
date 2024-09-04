package edu.unca.csci201;

import java.util.Arrays;

public class EnrolledCourse {
	private Course course;
	private Student[] roster;
	private int enrolledStudents;
	public EnrolledCourse(Course course) {
		this.course = course;
		// initialize the array to size 2
		roster = new Student[2];
		enrolledStudents=0;
	}
	
	public void enrollStudent(Student s) {
		// check if array is full
		if (enrolledStudents==roster.length) {
			// make array bigger
			Student[] temp = new Student[2*roster.length];
			// copy values from roster into temp
			for (int i=0; i<roster.length; i++) {
				temp[i]=roster[i];
			}
			roster=temp;
		}
		roster[enrolledStudents]=s;
		enrolledStudents++;
		
	}

	@Override
	public String toString() {
		return "EnrolledCourse [course=" + course + ", roster=" + Arrays.toString(roster) + ", enrolledStudents="
				+ enrolledStudents + "]";
	}
}
