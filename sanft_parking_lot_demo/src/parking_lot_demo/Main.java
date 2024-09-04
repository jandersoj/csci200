package parking_lot_demo;

public class Main {

	public static void main(String[] args) {
		//Vehicle v1 = new Vehicle(8); // can't: abstract
		
		Motorcycle bike1 = new Motorcycle(8);
		System.out.println(bike1);
		
		Car c1 = new Car(4,10);
		System.out.println(c1);

		c1.go();
		
		Vehicle someVehicle;
		someVehicle=bike1;//=c1;//=new Motorcycle(...
		someVehicle.go();
		
		ParkingSpace s1 = new ParkingSpace(10);
		System.out.println(s1);
		ParkingSpace s2 = new ParkingSpace(10);
		System.out.println(s2);
		
		s1.park(c1);
		System.out.println(s1);
		
		System.out.println(s1.park(bike1));
		System.out.println(s1);
		System.out.println(s2.park(new Car(2,20)));
		
		MotorcycleSpace mspace1 = new MotorcycleSpace(10,false);
		System.out.println(mspace1);
		//mspace1.park(bike1);
		mspace1.park(c1); 
		System.out.println(mspace1);
		
		// verify we didn't break it and can park a motorcycle
		mspace1.park(bike1);
		System.out.println(mspace1);
		
	}

}
