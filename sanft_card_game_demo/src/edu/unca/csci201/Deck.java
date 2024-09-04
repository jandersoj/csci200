package edu.unca.csci201;

import java.util.Random;

public class Deck {
	private Card[] cards;
	private int cardsRemaining;
	
	public Deck( ) {
		cards = new Card[52];
		for (int i =0; i<52; i++) {
			cards[i]=new Card(i+1);
		}
		cardsRemaining=52;
	}
	
	public int getCardsRemaining() {
		return cardsRemaining;
	}
	
	public void shuffle() {
		cards = new Card[52];
		for (int i =0; i<52; i++) {
			cards[i]=new Card(i+1);
		}
		cardsRemaining=52;
		Random r = new Random();
		for (int i=0; i<cards.length; i++) {
			int swapIndex = r.nextInt(52);
			Card old = cards[i];
			cards[i]=cards[swapIndex];
			cards[swapIndex]=old;
		}
	}
	
	public Card draw() {
		cardsRemaining--;
		return cards[52-cardsRemaining-1];
	}
	
	public String toString() {
		String out="";
		for (int i=0; i<cards.length; i++) {
			out+=cards[i]+"\n";
		}
		return out;
	}
}
