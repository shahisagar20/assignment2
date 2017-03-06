package assignment2;

import java.util.Stack;

/* Sagar Shahi
 * Assignment #2
 * Deck Class
 * 
 */

public class Deck {
	private static final int NCARDS = 52;	//Keeps the number of cards in the deck constant
	
	
	private Card[] deckOfCards;
	private int[] notDealtCards = new int[52];// Contains all 52 cards
	private int currentCard; // deal THIS card in deck

	public Deck() // Constructor for Deck class
	{
		deckOfCards = new Card[NCARDS];

		int i = 0;
		
		for (int suit = Card.SPADE; suit <= Card.CLUB; suit++)
			for (int rank = 1; rank <= 13; rank++)
				deckOfCards[i] = new Card(suit, rank);
				notDealtCards[i] =0; 
				i++;

		currentCard = 0;
		
	}
	//method dealOne
	//This method will remove the card from the top of the deck to return it.

	public Card dealOne() {
		if (currentCard < NCARDS) {
			
			return (deckOfCards[currentCard++]);
			
		} else {
			System.out.println("Out of cards error");
			return (null); // Error;
		}
	}

	//This method will print the deck in the Not Deal order
	public void print() {
		for (int i=0; i<deckOfCards.length; i++){
			 System.out.println( deckOfCards[i].print());
		}
		
	}
	//This method will shuffle the deck and with the goodness factor
	//0 for very good shuffle and 1 for no shuffling at all
	public void shuffle(double goodness) {
		int n= 52;
		for (int i = 0; i < n; i++) {
			int r=(int) (Math.random() * (goodness*52));
			System.out.println(r);
			Card temp = deckOfCards[r];
			System.out.println(r);
			deckOfCards[r] = deckOfCards[i];
			deckOfCards[i] = temp;
		}
	}
}