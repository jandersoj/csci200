package edu.unca.csci201;

public class Main {

	public static void main(String[] args) {
		// create some cards
//		Card c1= new Card(1);
//		Card c2 = new Card(1,"Spades");
//		System.out.println(c1);
//		System.out.println(c2);

//		for (int i=1; i<=52; i++) {
//			Card c = new Card(i);
//			System.out.println(c);
//		}
		
		Deck d = new Deck();
//		System.out.println("Cards remaining: "+d.getCardsRemaining());
//		Card c = d.draw();
//		System.out.println("I drew card with value: "+c.getValue());
		d.shuffle();
		System.out.println(d);
		
		System.out.println();
		System.out.println("drawing 5 cards:");
		Card[] hand = new Card[5];
		for (int i=0; i<hand.length; i++) {
			hand[i]=d.draw();
		}
		// print them:
		for (int i=0; i<hand.length; i++) {
			System.out.println(hand[i]);
		}
	}

}
