package parking_lot_demo;

public class ParkingSpace {
	protected boolean free;//true if no car is parked in this space
	int width;//width of the space in ...units
	Vehicle vehicle;//reference to the vehicle parked in this space, null if space is free

	public ParkingSpace(int width) {
		this.width=width;
		free=true;
		vehicle=null;
	}

	public boolean park(Vehicle vehicle) {
		System.out.println("in ParkingSpace.park");
		//handle the case where park fails
		if (!free || vehicle.getWidth()>width) {
			return false;
		}
		
		//handle usual case where park is successful
		free=false;
		this.vehicle=vehicle;
		return true;
	}
	
	public void unpark() {
		free=true;
		vehicle=null;
	}
	
	@Override
	public String toString() {
		return "ParkingSpace [free=" + free + ", width=" + width + ", vehicle=" + vehicle + "]";
	}
	
	
}
