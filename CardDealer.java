package assignment2;

import java.util.Scanner;

import ash.Deck;
import ash.Hand;

public class CardDealer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of runs: ");
		int numberOfRuns = sc.nextInt();
		System.out.println("Enter the number of players: ");
		int numberOfPlayers = sc.nextInt();
		System.out.println("Enter the goodness factor: between 0 and 1 inclusive :");
		double goodness = sc.nextDouble();
		// Checks for valid goodness value
		while (goodness < 0 && goodness > 1) {
			System.out.println("Enter the goodness factor: between 0 and 1 inclusive :");
			goodness = sc.nextDouble();
		}
		// total numbers of hands after the run
		int totalHands = numberOfRuns * numberOfPlayers;

		Hand hands[] = new Hand[numberOfPlayers];// hands for players

		while (numberOfRuns > 0) {
			Deck deck = new Deck(); // create Deck of cards
			deck.shuffle(goodness); // deck based on goodness factor
			int i = 0;
			while (numberOfPlayers > 0) {
				hands[i] = new Hand();
				hands[i].addCard(deck.deck[(int) Math.random() % 52]);
				Card c = deck.dealOne();
				i++;
				numberOfPlayers--;
			}

			numberOfRuns--;
		}

		int count = 0;
		for (int i = 0; i < hands.length - 1; i++) {
			if (hands[i].hasStraight(3, false))
				count++;
		}

		System.out.println("chances of getting a 3 card straight: " + count / totalHands);

	}

} // end class CardDealer