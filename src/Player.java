import java.util.ArrayList;

public class Player {

	String name;
	ArrayList<Card> hand;
	
	public Player(String name){
		
		this.name = name;
		hand = new ArrayList<Card>();
	}
	
	//Add a card to the palyer's hand.
	public void hit(){
		
	}
	
	//Keep current cards.
	public void stay(){
		
	}
	
	public int getHandValue(){
		
		return 0;
	}
}