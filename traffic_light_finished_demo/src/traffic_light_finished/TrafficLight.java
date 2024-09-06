package traffic_light_finished;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TrafficLight {
	private boolean green;
	int greenTime;
	int redTime;
	int crossingTime;//time remaining for the car currently crossing to clear (0 if no car currently crossing)
	Queue<Car> queue;
	
	public TrafficLight(boolean isGreen, int greenTime, int redTime) {
		green=isGreen;
		this.greenTime=greenTime;
		this.redTime=redTime;
		queue=new LinkedList<Car>();
	}
	
	public void simulate(int time, double arrivalProbability) {
		int currentTime=0;
		int nextChangeTime = green ? greenTime : redTime;
		System.out.println("starting simulation, light is "+(green ? "green":"red"));
		Random gen = new Random();
		while (currentTime<=time) {
			// see if it's time to change the light
			if (currentTime==nextChangeTime) {
				green = !green;
				System.out.println("light turned "+(green ? "green":"red")+" at time "+currentTime);
				nextChangeTime+=green ? greenTime : redTime;
			}
			// see if a car arrived this time step
			if (gen.nextDouble() < arrivalProbability) {
				System.out.print("A car arrived at time "+currentTime);
				Car car = new Car(currentTime,gen.nextInt(5)+1);
				System.out.println(" (car "+car.getId()+")");
				queue.add(car);
			}
			
			//if the light is green...
			
			// whether green or red, if there's a car in the intersection,
			// decrement time for them to get through
			if (crossingTime!=0) {
				crossingTime--;
			}
			// if the light is green and no car in intersection
			// remove a car from the queue
			if (green && crossingTime==0 && !queue.isEmpty()) {
				// to compute different statistics, might need
				// to save the Car somewhere
				Car car = queue.remove();
				car.setExitTime(currentTime);
				System.out.println("car "+car.getId()+" crossing at time "+currentTime+" (waited "+(currentTime-car.getArrivalTime())+")");
				crossingTime = car.getCrossingTime();
			}
			
			currentTime++;
		}
		System.out.println("simultion ends at time "+time);
		System.out.println("queue:");
		System.out.println(queue);
	}
}
