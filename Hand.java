package assignment2;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	public void print() {
		for(int i = 0; i<hand.size(); i++){
			System.out.println(hand.get(i));
		}
	}

	public void add(Card card) {
		hand.add(card);

	}

	public void sortBySuits() {
		while(hand.size()>0){
			
		}

	}

	public void sortByValue() {

	}

	public boolean hasStraight(int len, String sameSuit) {
		return false;

	}

}
