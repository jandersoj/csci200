package edu.unca.csci202;

/**
 * Represents a customer with a number of items and time needed to complete their transaction
 * 
 * @author Josie Anderson
 */
public class Customer {

		protected int itemsQty; //The number of items the customer has
		protected int timeLeft; //the time remaining in the transaction
		
		/* potential additions for future semesters?
		boolean unrulyCustomer; 
		boolean checkID;
		boolean intoxicatedCashier; //like when teenage employees are stoned at work?
		boolean callForManager;
		boolean chattyGolferCustomer; //you know who you are
		int broughtOwnBags;	//either takes less time (helpful customer) or more time (customer forgot to tell you)
		int grabForgottenItems; //when your mom abandons you at the checkout :,(
		int weighProduce;
		*/
		
		
		/**
		 * Customer constructor
		 * 
		 * @param items - how many items the customer will have
		 * @param processTime - how long each item takes to process
		 */
		public Customer(int items, int processTime) {
			itemsQty = items;
			timeLeft = (items * processTime);
		}
		
		
		/**
		 * Customer toString
		 * 
		 * @return a string with the customer's item qty. and the time left in their transaction.
		 */
		public String toString() {
			return "[" + itemsQty + ", "+timeLeft+"]";
		}


		/**
		 * Decrements the time needed to finish the customer's transaction
		 */
		protected void decrementTime() {
			timeLeft--;
		}
		
		/**
		 * Gets the number of items the customer has 
		 * 
		 * @return said number
		 */
		protected int getItemsQty() {
			return itemsQty;
		}

		/**
		 * Gets the amount of time remaining in the customer's transaction
		 * 
		 * @return said time
		 */
		protected int getTimeLeft() {
			return timeLeft;
		}

		
		
		
}
