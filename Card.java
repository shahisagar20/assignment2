package assignment2;
/* Sagar Shahi
 * Assignment #02
 * This is the card class
 */

public class Card{
	public static final int SPADE = 1; //Assigning an specific value to Spade, Diamond, Heart, and Club
	public static final int DIAMOND = 2;
	public static final int HEART = 3;
	public static final int CLUB = 4;
	
	// Create the private Stances of suits and ranks so we can get different suits and ranks
	private static final String[] suits = { "*", "Spade", "Diamond", "Heart", "Club" };
	private static final String[] ranks = { "*", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	private String cardSuit;
	private String cardRank;
	
	//Constructor for card class
	public Card(int suit, int rank) {
		this.cardRank = ranks[rank];
		this.cardSuit = suits[suit];
		
	}
	
	//To print the card suit and rank
	public String print() {
		
		return this.cardRank+" "+ this.cardSuit;
	}
	public String getSuit(){
		return cardSuit;
	}
	public String getRank(){
		return cardRank;
	}
	
}