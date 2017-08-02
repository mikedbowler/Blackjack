import java.io.*;

public class Dealer extends Player{
	
	public Dealer(String name, Deck deck){
		
		//Must call superclass constructor first.
		super(name,deck);
		isDealer = true;
	}
	
	//The dealer will act according to a fixed algorithm.
	public void autoPlay() throws IOException{
		
		int handValue = getHandValue();
		
		//Dealer always hits if hand value is under 17.
		if(handValue<17){
			
			Card c = deck.drawCard();
			
			if(c.name.charAt(0)=='A' && handValue <= 10){
				c.changeValue();
			}
			
			hit(c);
		}
		//Dealer always stays if hand value is 17 or more.
		else if(handValue>=17){
			
			stay();
		}
	}
	
	//Initializes the player's hand.
	public void initializeHand(){
			
			hand.add(deck.drawCard());
	}
}
