package edu.unca.csci201;

public class Main {

	public static void main(String[] args) {
		Sphere s1 = new Sphere("sphere1",2);
		Sphere s2 = new Sphere("sphere2",3);
		Cube c1 = new Cube("cube1",5,"blue");
		Cube c2 = new Cube("cube2",6,"yellow");

		System.out.println(s1.getShapeName()+ " volume: " + s1.getVolume());
		System.out.println(s2.getShapeName()+ " radius: " +s2.getRadius());
		
		System.out.println(c1.getShapeName()+ " volume: " + c1.getVolume());
		System.out.println(c2.getShapeName()+ " side length: " +c2.getSideLength());
		System.out.println(c2.getShapeName()+ " color: " +c2.getColor());
	}

}
