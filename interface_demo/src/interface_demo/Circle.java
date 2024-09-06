package interface_demo;

// example of a class extending an abstract class
public class Circle extends Shape2DAbstract {

	protected double radius;
	
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

}
