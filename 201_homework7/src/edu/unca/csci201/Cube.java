package edu.unca.csci201;
import java.lang.Math;

public class Cube extends Shape3D{
	protected double sideLength;
	protected String color;
	
	public Cube(String shapeName, double newSideLength, String newColor) {
		super (shapeName);
		sideLength = newSideLength;
		color = newColor;
	}

	public double getSideLength() {
		return sideLength;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getVolume() {
		return Math.pow(sideLength, 3);
	}

}
