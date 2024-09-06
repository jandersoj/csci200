package edu.unca.csci201;

public class Card {
	// normally I would do this:
	//private int value;
	//private String suit;
	// just for fun, I'm going to do this:
	private int cardNumber;// 1 through 52
	
	//constructors
	public Card(int cardNumber) {
		// ensure cardNumber is between 1 and 52
		if (cardNumber<1 || cardNumber>52) {
			System.out.println("Error: invalid cardNumber. Terminating.");
			System.exit(0);// we haven't seen this...ok
		}
		
		this.cardNumber=cardNumber;
	}
	public Card(int value, String suit) {
		if (suit.equals("Spades")) {
			cardNumber=value;
		} else if (suit.equals("Hearts")) {
			cardNumber=value+13;
		} else if (suit.equals("Diamonds")) {
			cardNumber=value+26;
		} else {
			cardNumber=value+39;
		}
	}
	
	public int getValue() {
		return ((cardNumber-1)%13)+1;
	}
	public String getSuit() {
		if (cardNumber<=13) {
			return "Spades";
		} else if (cardNumber<=26) {
			return "Hearts";
		} else if (cardNumber<=39) {
			return "Diamonds";
		} else {
			return "Clubs";
		}
	}
	
	public String toString() {
		return getValue()+" of "+getSuit();
	}
}
