package edu.unca.csci201;
import java.lang.Math;

public class Sphere extends Shape3D {
	protected double radius;
	
	public Sphere(String shapeName, double newRadius) {
		super (shapeName);
		radius = newRadius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getVolume() {
		return (4 / 3) * Math.PI * Math.pow(radius, 3);
	}

}
