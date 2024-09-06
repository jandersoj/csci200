package traffic_light_finished;

public class Main {

	public static void main(String[] args) {
//		Car c1 = new Car( 0, 5);
//		Car c2 = new Car( 3, 4);
//
//		System.out.println(c1);
//		System.out.println(c2);
		
		TrafficLight light = new TrafficLight(true,20,40);
		light.simulate(100,.1);
	}

}
