package interface_demo;

// example of a class implementing an interface
public class Square implements Shape2D {

	protected int sideLength;
	protected String color;
	
	public Square(int sideLength, String color) {
		this.sideLength = sideLength;
		this.color = color;
	}
	
	@Override
	public void draw() {
		for (int i=0; i<sideLength; i++) {
			for (int j=0; j<sideLength; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Override
	public double area() {
		return sideLength*sideLength;
	}

	

}
