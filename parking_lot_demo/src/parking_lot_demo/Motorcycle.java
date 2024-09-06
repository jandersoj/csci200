package parking_lot_demo;

public class Motorcycle extends Vehicle {
	protected boolean windshield;
	
	public Motorcycle(int width) {
		super(width);
		windshield=false;
	}
	
	public Motorcycle(int width, boolean windshield) {
		super(width);
		this.windshield=windshield;
	}
	
	public String toString() {
		return "Motorcycle width="+width+", windshield="+windshield;
	}

	@Override
	public void go() {
		System.out.println("zip-zip");
		
	}
}
