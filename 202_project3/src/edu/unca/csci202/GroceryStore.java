package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

/**
 * Simulates a grocery store checkout with multiple queues
 * 
 * @author Josie Anderson
 */
public class GroceryStore {

	protected ArrayList<Queue<Customer>> checkout;
		
	/**
	 * The following variables are instantiated within methods and later used for the printData method.
	 */
	protected int stepsRun;
	protected int linesQty;
	protected double customerArrivalProb;
	protected int timePerItem;
	protected int maxItems;
	protected int[] maxQueueLength; //array will track the max length of each queue
	protected int[] customersLeft;	//will return the customers left in each queue. I'm not sure if a 2d array would be better here?
	protected int customersServed;
	
	/**
	 * Creates a new grocery store object
	 * 
	 * @param linesNum - how many queues are going to be in the store
	 */
	public GroceryStore(int linesNum){
		
		if(linesNum < 1) { //In case you try to make a store with 0 or negative queues
			throw new IllegalArgumentException("You can't have a grocery store with less than one line!");		
		}
		
		linesQty = linesNum; //for the later printData
		
		checkout = new ArrayList<>();
		maxQueueLength = new int[linesNum];
		customersLeft = new int[linesNum];
		
		for(int i = 0; i < linesNum; i++) { //instantiates each queue in the store
			checkout.add(new ArrayDeque<Customer>());
		}
	}
	
	/**
	 * Runs a grocery store checkout simulation for a certain period of time
	 * 
	 * @param steps - How many time-steps the simulation will loop through
	 * @param arrivalProb - The probability that a new customer will arrive at each time-step
	 * @param itemTime - How long each item takes to scan and bag
	 * @param itemsMax - The maximum number of items a customer can have
	 */
	public void run(int steps, double arrivalProb, int itemTime, int itemsMax) {
				
		timePerItem = itemTime; //all for printData
		customerArrivalProb = arrivalProb;
		stepsRun = steps;
		maxItems = itemsMax;
				
		Random r = new Random(); 
		
		for(int time = 0; time < steps; time++) { //at each time step
			
			if(r.nextDouble() <= arrivalProb) {	//If a random double is less than the probability a customer will arrive,
				int itemsQty = r.nextInt(itemsMax)+1; 
				newCustomer(itemsQty, itemTime); //A new one will be added with a random amount of items
			}
			
			for(int i = 0; i < linesQty; i++) {
				Queue<Customer> currQueue = checkout.get(i); 
				
				if(currQueue != null && currQueue.peek() != null) { //if the line exists and there is a customer 
					Customer currCust = currQueue.peek(); //look at the customer in front
					currCust.decrementTime();
					
					if(currCust.getTimeLeft() == 0) { //Check if said customer is finished checking out
						currQueue.remove(); 
						customersLeft[i]--;
						customersServed++;
					}
				}
			}
		}
		printData();	
		closingShift(); //resets everything, I thought the name was amusing
	}
	
	
	/**
	 * Creates and adds a new customer to the shortest line.
	 * 
	 * @param itemsQty - How many items the customer has
	 * @param itemTime - The time needed per item to check out
	 */
	public void newCustomer(int itemsQty, int itemTime) {
		Queue<Customer> shortestQueue = checkout.get(0);
		int shortestIndex = 0;
		
		for(int i = 0; i < linesQty; i++) {
			Queue<Customer> currQueue = checkout.get(i);
			
			if(currQueue.size() < shortestQueue.size()) { //find the current shortest queue
				shortestQueue = checkout.get(i);
				shortestIndex = i;
			}
		}
		
		Customer newCustomer = new Customer(itemsQty, itemTime);	
		shortestQueue.add(newCustomer);
		customersLeft[shortestIndex]++;
		
		if(checkout.get(shortestIndex).size() > maxQueueLength[shortestIndex]) {
			maxQueueLength[shortestIndex]++; //updates that line's longest length, if needed	
		}
	}
	
	
	/**
	 * Clears each queue and most variables, "resetting" the store.
	 */
	public void closingShift(){ 
		
		for(int i = 0; i < linesQty; i++) {
			checkout.get(i).clear();
			maxQueueLength[i] = 0;
			customersLeft[i] = 0;
		}
		
		stepsRun = 0;
		customerArrivalProb = 0;
		timePerItem = 0;
		maxItems = 0;
		customersServed = 0;
	}
	
	/**
	 * Prints relevant data after running a simuation. 
	 */
	public void printData() {
	
//		simulation setup information:
		System.out.println("Number of timesteps: "+stepsRun);
		System.out.println("Number of lines: "+linesQty);
		System.out.println("Probability of customer arriving: "+customerArrivalProb);
		System.out.println("Time per item: "+timePerItem);
		System.out.println("Maximum number of items: "+maxItems);
		
//		for each checkout line:
		for(int i = 0; i < linesQty; i++) {
			System.out.println("Maximum length of line "+i+" is: "+maxQueueLength[i]);
			System.out.println("Customers left in line "+i+" is: "+customersLeft[i]);
		}
		
//		the total number of customers served:
		System.out.println("Total number of customers served is: "+customersServed);
	}
	
	/**
	 * My own print function to show the queues as the simulation is run.
	 */
	public void printLines() {
		
		for(int i = 0; i < linesQty; i++) {
			String str = "line "+ i +": ";
			Queue<Customer> currQueue = checkout.get(i);
			str += currQueue.toString();
			
			System.out.println(str);
			System.out.println("Max length: "+maxQueueLength[i]+". Customers remaining: "+customersLeft[i]);
		}
		System.out.println("customers served: "+customersServed);
	}
}
