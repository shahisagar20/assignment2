package assignment2;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand; // The cards in the hand.

	/*
	 * Create a hand that is initially empty.
	 */
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	// print hand
	public void print() {

		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i));
		}

	}

	/*
	 * Add a card to the hand. It is added at the end of the current hand.
	 * 
	 * @param c
	 *            the non-null card to be added.
	 * @throws NullPointerException
	 *             if the parameter c is null.
	 */
	public void addCard(Card c) {
		if (c == null)
			throw new NullPointerException("Can't add a null card to a hand.");
		hand.add(c);
	}

	/*
	 * Returns the number of cards in the hand.
	 */
	public int getCardCount() {
		return hand.size();
	}

	/*
	 * Sorts the cards in the hand so that cards of the same suit are grouped
	 * together, and within a suit the cards are sorted by value. Note that aces
	 * are considered to have the lowest value, 1.
	 */
	public void sortBySuit() {
		ArrayList<Card> newHand = new ArrayList<Card>();
		while (hand.size() > 0) {
			int pos = 0; // Position of minimal card.
			Card c = hand.get(0); // Minimal card.
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = hand.get(i);
				if (c1.getSuit() < c.getSuit() || (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
					pos = i;
					c = c1;
				}
			}
			hand.remove(pos);
			newHand.add(c);
		}
		hand = newHand;
	}

	/*
	 * Sorts the cards in the hand so that cards of the same value are grouped
	 * together. Cards with the same value are sorted by suit. Note that aces
	 * are considered to have the lowest value, 1.
	 */
	public void sortByValue() {
		ArrayList<Card> newHand = new ArrayList<Card>();
		while (hand.size() > 0) {
			int pos = 0; // Position of minimal card.
			Card c = hand.get(0); // Minimal card.
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = hand.get(i);
				if (c1.getValue() < c.getValue() || (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
					pos = i;
					c = c1;
				}
			}
			hand.remove(pos);
			newHand.add(c);
		}
		hand = newHand;
	}

	public boolean hasStraight(int len, boolean sameSuit) {
		if (sameSuit) {
			if (hand.size() < len)
				return false;
			else {
				for (int i = 0; i < hand.size() - 1; i++) {
					int suit = hand.get(i).getSuit();
					int j;
					for (j = i + 1; j < 2; j++) {
						if (hand.get(j).getSuit() != suit)
							break;
					}
					if (j == 2)
						return true;
				}
				return false;
			}

		} else {
			for (int i = 0; i < hand.size() - 2; i++) {
				int value = hand.get(i).getValue();
				int j;
				for (j = i + 1; j < 2; j++) {
					if (hand.get(j).getValue() != value + 1)
						break;
					else
						value++;
				}
				if (j == 2)
					return true;
			}
			return false;
		}

	}

}