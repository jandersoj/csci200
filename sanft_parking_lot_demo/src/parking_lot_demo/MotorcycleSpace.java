package parking_lot_demo;

public class MotorcycleSpace extends ParkingSpace {
	protected boolean veryGood;
	
	public MotorcycleSpace(int width, boolean veryGood) {
		super(width);
		this.veryGood=veryGood;
	}

	public boolean park(Motorcycle cycle) {
		System.out.println("in MotorcycleSpace.park(Motorcycle)");
		return super.park(cycle);
	}
	
	// this version will handle anything that is not a motorcycle
	public boolean park(Vehicle cycle) {
		System.out.println("in MotorcycleSpace.park(Vehicle)");
		System.out.println("PROBLEM: NOT A MOTORCYCLE");
		return false;
	}

//	public boolean park(Vehicle cycle) {
//		
//		if (cycle==null) {
//			System.out.println("is null");
//		} else {
//			System.out.println("not null");
//		}
//		
//		System.out.println("in MotorcycleSpace.park");
//		if (cycle instanceof Motorcycle) {
//			System.out.println("No problem...");
//			return super.park(cycle);
//		} else {
//			System.out.println("PROBLEM, not a motorcycle.");
//			return false;
//		}
//		// could do something similar with getClass or isInstance
//		
//
//	}
}
