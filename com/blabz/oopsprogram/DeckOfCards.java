package com.blabz.oopsprogram;

import java.util.Random;

public class DeckOfCards {
	 String[] suits = { "Hearts", "Clubs", "Diamonds", "Spades" };
	 String[] ranks = { "Ace","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	 String[] cards = new String[52];

	public static void main(String[] args) {

		DeckOfCards deck = new DeckOfCards();

		deck.getCards();
		deck.randomlyshuffle();

		String playerCards[][] = deck.distributecards(4, 9);

		deck.display(playerCards);

	}

	/**
	 * purpose to store the cards in string array
	 * @return  cards
	 */
	public String[] getCards() {
		int i = 0;
		for (String suit : suits)
		{
			for (String card : ranks) 
			{
				cards[i] = card + "-" + suit;
				i++;
			}
		}
		return cards;
	}
	
	/**
	 * to shuffle the cards randomly
	 */
	public void randomlyshuffle () 
	{

		Random random = new Random();
		for (int i = 0; i < cards.length; i++)
		{
			int index = random.nextInt(52);
			String temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}
	}

	/**
	 * @param playerCards--its shows that which player has which cards
	 */
	public void display(String[][] playerCards) 
	{
		int i = 1;
		for (String[] playerCard : playerCards)
		{
			System.out.println();
			System.out.println("player :" +i++ + " cards : ");

			for (String card : playerCard)
			{
				System.out.print(card + "  ");
			}
			System.out.println();

		}

	}

	
	/**
	 * @param noOfPlayers how many player players
	 * @param noOfCards how much cards we have to distribute them
	 * @return playerCards
	 */
	public String[][] distributecards(int noOfPlayers, int noOfCards) {

		String playerCards[][] = new String[noOfPlayers][noOfCards];
		int k = 0;
		for (int i = 0; i < noOfPlayers; i++) 
		{
			for (int j = 0; j < noOfCards; j++) 
			{
				playerCards[i][j] = cards[k];
				k++;
			}
		}
		return playerCards;
	}

	
	
	
	
}
