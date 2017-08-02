import java.io.*;
import java.util.ArrayList;

public class Player {

	private BufferedReader br;
	String name;
	ArrayList<Card> hand;
	Deck deck;
	boolean isDealer;
	boolean didStay;
	
	public Player(String name, Deck deck){
		
		br = new BufferedReader(new InputStreamReader(System.in));
		this.name = name;
		hand = new ArrayList<Card>();
		this.deck = deck;
		isDealer = false;
		didStay = false;
	}
	
	//Handles the process of making the player's move.
	public void move() throws IOException{
		
		System.out.println("\n"+name+" your current hand value = "+getHandValue());
		System.out.println("Hit, Stay, Show Hand, or Change Ace Value? (H/S/P/C): ");
		String answer = br.readLine();
		
		if(answer.equalsIgnoreCase("h")){
			hit(deck.drawCard());
		}
		else if(answer.equalsIgnoreCase("p")){
			showHand();
		}
		else if(answer.equalsIgnoreCase("c")){
			changeAce();
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
		System.out.println("Added "+c.name+" to "+name+"'s hand.");
		System.out.println("New hand value = "+getHandValue());
		
		//Asks player if they want to make their Ace worth 11, not 1.
		if(c.name.charAt(0)=='A' && !isDealer){
			
			String answer = "";
			System.out.print("Change Ace from 1 to 11? (Y or N): ");
			answer = br.readLine();
			
			if(answer.equalsIgnoreCase("y")){
				c.changeValue();
				System.out.println("New hand value = "+getHandValue());
			}
		}
		
		
	}
	
	/*
	* Allows player to change the value of one 
	*or more Ace's in their hand.
	*/
	public void changeAce() throws IOException{
		
		for(Card c: hand){
			
			if(c.name.charAt(0)=='A'){
				System.out.println("This Ace is worth "+c.value);
				System.out.print("To change this value type C now: ");
				
				if(br.readLine().equalsIgnoreCase("c")){
					c.changeValue();
				}
			}
		}
		
	}
	
	//Keep current cards.
	public void stay(){
		System.out.println(name+" decided to stay");
		System.out.println("Current hand value = "+getHandValue()+"\n");
		didStay = true;
	}
	
	//Determine value of the player's entire hand
	public int getHandValue(){
		
		int total = 0;
		
		for(Card c: hand){
			total+=c.value;
		}
		
		return total;
	}
	
	//Initializes the player's hand.
	public void initializeHand(){
		
		hand.add(deck.drawCard());
		hand.add(deck.drawCard());
	}
	
	//Prints the player's hand.
	public void showHand(){
		
		System.out.println(name+"'s hand contains: ");
		
		for(Card c: hand){
			System.out.println(c);
		}
	}
}
