package interface_demo;

/*
 * abstract class, compare and contract with Shape2D interface
 */
public abstract class Shape2DAbstract {
	
	// instance variables all subclasses will have
	// (not possible with an interface)
	protected int vertices;
	public int getVertices() {
		return vertices;
	}
	
	//should have a constructor! not implemented
	
	// implemented method in abstract class
	// (not possible with an interface)
	public void printShape2DAbstract() {
		System.out.println("...printShape2DAbstract...");
	}
	
	// abstract methods subclasses must implement
	// (similar to requirements in an interface)
	public abstract void draw();
	public abstract double area();
}
