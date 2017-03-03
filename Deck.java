package assignment2;

import java.util.Stack;

/* Sagar Shahi
 * Assignment #2
 * Deck Class
 * 
 */

public class Deck {
	public static final int NCARDS = 52;	//Keeps the number of cards in the deck constant
	
	
	private Card[] deckOfCards;
	private Card[] dealtCards;// Contains all 52 cards
	private int currentCard; // deal THIS card in deck

	public Deck() // Constructor for Deck class
	{
		deckOfCards = new Card[NCARDS];

		int i = 0;
		
		for (int suit = Card.SPADE; suit <= Card.CLUB; suit++)
			for (int rank = 1; rank <= 13; rank++)
				deckOfCards[i++] = new Card(suit, rank);

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
	public void shuffle( int goodness){
		Deck d = new Deck();
	}
}