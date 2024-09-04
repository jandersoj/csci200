package edu.unca.csci201;

//completed by Jamie Nale and Josie Anderson

public class Rectangle {
//	instance variables
	private Point corner1;
	private Point corner2;
//	constructor
	public Rectangle(Point corner1, Point corner2) {
		this.corner1 = corner1;
		this.corner2 = corner2;
		
	}
//	instance methods
	public int getArea() {
		int length = Math.abs(corner2.getX()-corner1.getX());
		int width = Math.abs(corner2.getY()-corner1.getY());
		int area = length*width;
		return area;
	}
	public boolean isLarger(Rectangle other){
		if (this.getArea() > other.getArea()){ 
			return true;
		} else {
			return false;
		}
		
	}

}
