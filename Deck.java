package assignment2;

class Deck {
	private String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

	private String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	private int dealtCounter;

	// initialize deck
	private int n = SUITS.length * RANKS.length;
	private int[] D = new int[52]; // D = 1 then dealt D = 0 then no-dealt
	public Card[] deck = new Card[52];;
	/**
	 * Constructor for the Deck class
	 */
	public Deck() {
		int cardCt = 0; // How many cards have been created so far.
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				deck[cardCt] = new Card(value, suit);
				D[cardCt] = 0;
				cardCt++;

			}
		}
		dealtCounter = 0;
	}

	/**This method shuffles the deck
	 * @ param Takes a double value as goodness
	 */
	public void shuffle(double goodness) {
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * goodness);
			Card temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
	}
	/**This method deals the card to the players
	 * 
	 * @return Returns the card from top of the deck 
	 */

	public Card dealOne() {
		if (dealtCounter == deck.length)
			throw new IllegalStateException("No cards are left in the deck.");
		dealtCounter++;
		return deck[dealtCounter - 1];
	}

	/**
	 * This method prints the shuffled deck
	 */
	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(deck[i]);
		}
	}

}
