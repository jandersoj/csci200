package parking_lot_demo;

public abstract class Vehicle {
	protected int width;
	
	public Vehicle(int width) {
		if (width<=0) {
			System.out.println("ERROR: width must be positive. Setting to 0.");
			width=0;
		} else {
			this.width=width;			
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public abstract void go();
}
