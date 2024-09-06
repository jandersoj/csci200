package traffic_light_finished;

public class Car {
	private static int carCount=0;
	private int id;
	// could have chosen to have a crossingTime variable
	// and a currentCrossingTime to record if this car is
	// currently crossing an intersection
	private int crossingTime;
	private int arrivalTime;
	private int exitTime;
	// could have a status like "not arrived", "waiting", "crossing", "gone"
	
	public Car(int arrivalTime, int crossingTime) {
		id=carCount++;
		this.arrivalTime=arrivalTime;
		this.crossingTime=crossingTime;
		exitTime=-1;
	}
	
	public int getId() {
		return id;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getCrossingTime() {
		return crossingTime;
	}
	
	public void setExitTime(int time) {
		exitTime=time;
	}
	
	public String toString() {
		return "(id="+id+", arrivalTime="+arrivalTime+", crossingTime="+crossingTime+", exitTime="+exitTime+")";
	}
}
