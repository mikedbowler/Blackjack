import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Deck deck = new Deck();
		
		//Adds a player and dealer, then initializes their hands.
		Dealer d = new Dealer("Dealer",deck);
		d.initializeHand();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Allows player to enter their name.
		System.out.println("Enter your name: ");
		String pname = br.readLine();
		pname = (pname.equals("")) ? "Player 1":pname;
		
		
		Player p = new Player(pname,deck);
		p.initializeHand();
		
		int turn = 0;
		boolean playOn = true;
		
		//Allows user to play again.
		while(playOn){
		
			System.out.println("*******************************");
			System.out.println("*****WELCOME TO BLACKJACK******");
			System.out.println("*******************************");
		
			//Display initial hand values.
			System.out.println("Dealer's Hand Value = "+d.getHandValue());
			System.out.println(p.name+"'s Hand Value = "+p.getHandValue());
		
			//Runs the game.
			while(turn!=2){
			
				//Player's turn.
				if(turn==0){
					p.move();
				
					if(p.didStay){
						turn = 1;
					}
				}
				else if(turn==1){
				
					//Dealer's turn.
					while(!d.didStay){
						d.autoPlay();
					}
				
					turn = 2;
				}
			
			}//End While Statement
		
			checkWinner(p,d);
		
			//Asks player if they want to continue playing or quit.
			System.out.println("P = Play Again or any letter to Quit:");
		
			if(!br.readLine().equalsIgnoreCase("p")){
				playOn = false;
			}
			
			//Reset the game.
			turn = 0;
			d.returnHand();
			d.didStay = false;
			p.returnHand();
			p.didStay = false;
			deck.shuffle(3);
			p.initializeHand();
			d.initializeHand();
			
		}//End Outer While Statement
		
		br.close();
		System.exit(0);
	}
	
	//Determines the result of the game.
	public static void checkWinner(Player p, Dealer d){
		
		int pValue = p.getHandValue();
		int dValue = d.getHandValue();
		
		//Determines the result of the game.
		if(pValue > 21 && dValue > 21){
			System.out.println("\nBoth Players Busted!");
		}
		else if(pValue > 21){
			System.out.println("\nDealer Wins!");
		}
		else if(dValue > 21){
			System.out.println("\n"+p.name+" Wins!");
		}
		else if(pValue <= 21 && pValue > dValue){
			System.out.println("\n"+p.name+" Wins!");
		}
		else if(dValue <= 21 && dValue > pValue){
			System.out.println("\nDealer Wins!");
		}
		else if(pValue==dValue){
			System.out.println("It's a Draw!");
		}
		else{
			System.out.println("Error, winner not correctly evaluated!");
		}	
	}
}
