package edu.unca.csci202;

/**
 * Serves as a driver for a grocery store simulation, and holds the main method 
 * 
 * @author Josie Anderson
 */
public class StoreDriver {

	/**
	 * Main method, creates new GroceryStore objects and runs simulations.
	 * 
	 * @param args - Hypothetically, takes arguments
	 */
	public static void main(String[] args) {
		GroceryStore g1 = new GroceryStore(5);
		g1.run(30, 0.5, 3, 30);
		System.out.println();
		g1.run(1000, 0.7, 3, 25);
		System.out.println();

		
		GroceryStore g2 = new GroceryStore(8);
		g2.run(300, 0.0, 3, 30);
		System.out.println();
		g2.run(104, 0.9, 1, 25);
		System.out.println();
		g2.run(300, 0.2, 3, 0); //this will return an error about how the max items must be positive
		System.out.println();

		
		GroceryStore g3 = new GroceryStore(0); //and this one will return an error about needing > 0 lines
		g3.run(300, 0.2, 3, 60);

	}

}
