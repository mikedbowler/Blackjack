import java.io.*;
import java.util.ArrayList;

public class Deck {
	
	ArrayList<Card> cards;
	
	public Deck(){
		
		cards = new ArrayList<Card>();
	}
	
	//Draws one card from the top of the deck.
	public Card drawCard(){
		
		//Ensures deck is not empty.
		if(cards.isEmpty()){
			System.out.println("Deck is Empty!");
			return null;
		}
		
		//Returns top card
		return cards.remove(0);
	}
	
	//Adds a card to the deck
	public void addCard(Card card){
		
		//Ensures deck is not full (Assuming a 52 card deck).
		if(cards.size()==52){
			System.out.println("Deck is Full!");
			return;
		}
		
		//Adds a card to the deck.
		cards.add(card);
	}
	
	//Fills the deck with 52 cards from local text file.
	public void initializeDeck() throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("cards.txt"));
		String line = "";
		Suit suit = Suit.CLUBS;
		
		while((line = br.readLine()) != null){
			
		}
			
		br.close();
	}
}
