package edu.unca.csci201;

/*
 * Class representing a mathematical vector
 */
public class MathVector {
	//I asked Jamie for some help on this, since I wasn't sure where to even start.
	double[] points;
	
	public MathVector(double[] data) {
		points = new double [data.length];
		for(int i = 0; i < data.length; i++) {
			points[i] = data[i];
		}
	}
	
	public int numberOfElements() {
		return points.length;
	}
	
	public double norm2() {
		double sum = 0;
		for(int i = 0; i < points.length; i++) {
			sum += points[i]*points[i];
		}
		return Math.sqrt(sum);
	}
	
	public String toString() {
		String stringPoints = "[";
		for (int i = 0; i < points.length; i++) {
			stringPoints += points[i];
			if (i < points.length - 1) {
				stringPoints += ", ";
			}
		}
		stringPoints = stringPoints + "]";
		return stringPoints;
	}
}
