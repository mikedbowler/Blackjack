import java.io.*;
import java.util.ArrayList;

public class Player {

	private BufferedReader br;
	String name;
	ArrayList<Card> hand;
	Card faceDown;
	Deck deck;
	
	public Player(String name, Deck deck){
		
		br = new BufferedReader(new InputStreamReader(System.in));
		this.name = name;
		hand = new ArrayList<Card>();
		faceDown = null;
		this.deck = deck;
	}
	
	//Handles the process of making the player's move.
	public void move() throws IOException{
		
		System.out.println(name+" your current hand value = "+getHandValue());
		System.out.println("Hit or Stay? (H or S): ");
		String answer = br.readLine();
		
		if(answer.equalsIgnoreCase("H")){
			hit(deck.drawCard());
		}
		else{
			stay();
		}
		
	}
	
	//Add a card to the palyer's hand.
	public void hit(Card c) throws IOException{
		
		//Prevents player from hitting after 21 has been reached or exceeded.
		if(getHandValue()>=21){
			
			System.out.println("Cannot hit! Hand value = "+getHandValue());
			
			//Returns unused card to the deck.
			deck.addCard(c);
			return;
		}
		
		hand.add(c);
		System.out.println("Added "+c.name+" to hand.");
		System.out.println("New hand value = "+getHandValue());
		
		//Asks player if they want to make their Ace worth 11, not 1.
		if(c.name.charAt(0)=='A'){
			
			String answer = "";
			System.out.print("Change Ace from 1 to 11? (Y or N): ");
			answer = br.readLine();
			
			if(answer.equalsIgnoreCase("y")){
				c.changeValue();
				System.out.println("New hand value = "+getHandValue());
			}
		}
		
		
	}
	
	//Keep current cards.
	public void stay(){
		System.out.println(name+" decided to stay");
		System.out.println("Current hand value = "+getHandValue());
	}
	
	//Determine value of the player's entire hand
	public int getHandValue(){
		
		int total = 0;
		
		for(Card c: hand){
			total+=c.value;
		}
		
		return total;
	}
	
	//Prints the player's hand for testing purposes.
	public void showHand(){
		
		System.out.println(name+"'s hand contains: ");
		
		for(Card c: hand){
			System.out.println(c);
		}
	}
}
