package parking_lot_demo;

public class Car extends Vehicle {
	protected int doors;
	public Car(int doors, int width) {
		super(width);
		this.doors=doors;
	}
	
	// Eclipse created toString method using fields (and inherited fields)
	@Override
	public String toString() {
		return "Car [doors=" + doors + ", width=" + width + "]";
	}

	@Override
	public void go() {
		System.out.println("VROOM!");
		
	}
	
}
