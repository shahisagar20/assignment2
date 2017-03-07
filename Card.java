package assignment2;

public class Card {

	public final static int SPADES = 0, // Codes for the 4 suits.
			DIAMONDS = 1, HEARTS = 2, CLUBS = 3;

	public final static int ACE = 13, // Codes for the non-numeric cards.
			JACK = 10, // Cards 2 through 10 have their
			QUEEN = 11, // numerical values for their codes.
			KING = 12;

	private final int suit; // The suit of this card, one of the constants
	// SPADES, HEARTS, DIAMONDS, CLUBS.

	private final int value; // The value of this card, from 1 to 11.

	public Card(int theValue, int theSuit) {
		// Construct a card with the specified value and suit.
		// Value must be between 1 and 13. Suit must be between
		// 0 and 3. If the parameters are outside these ranges,
		// the constructed card object will be invalid.
		value = theValue;
		suit = theSuit;
	}

	public int getSuit() {
		// Return the int that codes for this card's suit.
		return suit;
	}

	public int getValue() {
		// Return the int that codes for this card's value.
		return value;
	}

	public String getSuitAsString() {
		// Return a String representing the card's suit.
		// (If the card's suit is invalid, "??" is returned.)
		switch (suit) {
		case SPADES:
			return "Spades";
		case HEARTS:
			return "Hearts";
		case DIAMONDS:
			return "Diamonds";
		case CLUBS:
			return "Clubs";
		default:
			return "??";
		}
	}

	public String getValueAsString() {
		// Return a String representing the card's value.
		// If the card's value is invalid, "??" is returned.
		switch (value) {
		case 1:
			return "2";
		case 2:
			return "3";
		case 3:
			return "4";
		case 4:
			return "5";
		case 5:
			return "6";
		case 6:
			return "7";
		case 7:
			return "8";
		case 8:
			return "9";
		case 9:
			return "10";
		case 10:
			return "Jack";
		case 11:
			return "Queen";
		case 12:
			return "King";
		case 13:
			return "Ace";
		default:
			return "??";
		}
	}

	public String print() {
		// Return a String representation of this card, such as
		// "10 of Hearts" or "Queen of Spades".
		return getValueAsString() + " of " + getSuitAsString();
	}

	public void printCardType() {
		System.out.println("Type of card " + getSuitAsString());
	}

} // end class Card