/*
 * Exam 1 Pixel class
 * 
 * 02/03/24
 * 
 * Josie Anderson
 */
package edu.unca.csci202;

public class Pixel {
	int red;
	int green;
	int blue;
	
	public Pixel(int r, int g, int b) {
		this.red = r;
		this.green = g;
		this.blue = b;
		
	}

	
	public String toString() {
		return red + " " + green + " " + blue;
	}
	
	
}
