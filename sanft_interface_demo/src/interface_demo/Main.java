package interface_demo;

/*
 * demonstrate interfaces and abstract classes
 */
public class Main {

	public static void main(String[] args) {
		Square square1 = new Square(7,"Blue");
		//square1.draw();//works

		Shape2D shape = square1; // works because square1 is a Square, which implements the Shape2D interface
		shape.draw();
		
		Shape2DAbstract shape2 = new Circle(7);//works because Circle extands Shape2DAbstract abstract class
	}

}
