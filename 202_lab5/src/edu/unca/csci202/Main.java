package edu.unca.csci202;

/**
 * Lab5 - Main class (TO BE DELETED BEFORE SUBMISSION)
 * 
 * Serves to test the LinkedDeque class
 * 
 * @author Josie Anderson
 * @author Jamie Nale
 * 
 */

public class Main {

	public static void main(String[] args) {
		LinkedDeque<String> newDeck = new LinkedDeque<String>();
		
		newDeck.addFirst("P"); //Testing addFirst
		newDeck.addFirst("E");
		newDeck.addFirst("S");
		newDeck.addFirst("O");
		newDeck.addFirst("J");
		newDeck.addFirst("J");
				
		newDeck.addLast("H"); //Testing addLast
		newDeck.addLast("I");
		newDeck.addLast("N");
		newDeck.addLast("E");
		
		newDeck.printForward(); //Testing printForward
		newDeck.printBackward(); //Testing printBackward

		String firstJ = newDeck.getFirst(); //Testing getFirst to a variable
		
		newDeck.removeFirst();	//Testing removeFirst
	
		newDeck.getFirst();
		
		String lastE = newDeck.getLast(); //Testing getLast to a variable
		
		newDeck.printForward();
		
		newDeck.removeLastOccurrence("E"); //Testing removeLastOccurence
		newDeck.removeLast(); //Testing removeLast
		newDeck.removeLastOccurrence("H");
		newDeck.removeLastOccurrence("P");
		newDeck.removeFirstOccurrence("E"); //Testing removeFirstOccurence
			
		newDeck.printForward();
		
		newDeck.addLast(lastE); //Testing addLast with a variable
		
		newDeck.addLast(firstJ);
		
		
		if(newDeck.removeLastOccurrence("B")) { //Testing removeLastOccurence's return
			System.out.println("Literally how did this get true??");
		} else {
			System.out.println("There is no B in this queue.");
		}
		
		newDeck.printForward();
		
		
	}

}
