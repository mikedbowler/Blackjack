import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	ArrayList<Card> cards;
	
	public Deck() throws IOException{
		
		cards = new ArrayList<Card>();
		initializeDeck();
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
	
	//Shuffles the deck recursively to increase randomness of shuffling.
	public void shuffle(int numOfShuffles){
		
		//Base case
		if(numOfShuffles==0){return;}
		
		Random r = new Random();
		
		for(int i=0;i<52;i++){
			
			Card c = cards.remove(r.nextInt(52));
			cards.add(c);
		}
		
		//Recursive call
		shuffle(numOfShuffles-1);
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
		int s=0;
		
		while((line = br.readLine()) != null){
			
			if(line.length()>3){
				suit = Suit.values()[s++];
			}
			else{
				char ch = line.charAt(0);
				
				switch(ch){
				
				case 'A': 
					addCard(new Card(line,suit,1));
					break;
					
				case '1':
					addCard(new Card(line,suit,10));
					break;
					
				case 'J':
					addCard(new Card(line,suit,10));
					break;
					
				case 'Q':
					addCard(new Card(line,suit,10));
					break;
					
				case 'K':
					addCard(new Card(line,suit,10));
					break;
					
				default:
					addCard(new Card(line,suit,ch-'0'));
					break;
				}//End Switch Statement
			}
			
		}//End While Statement
		
		//Shuffle the deck.
		shuffle(3);
		
		br.close();
	}
	
	//Print deck for testing purposes.
	public void printDeck(){
		
		System.out.println("Deck Contains:");
		
		for(Card c: cards){
			System.out.println(c);
		}
	}
}
