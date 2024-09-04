package edu.unca.csci201;

public abstract class Shape3D {
	protected String shapeName;
	
	public String getShapeName() {
		return shapeName;
	}
	
	public abstract double getVolume();

	public Shape3D(String newName) {
		shapeName = newName;
	}
}
