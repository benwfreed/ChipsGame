import java.util.*;


public class ChipsGame {
	
	private boolean playerOneTurn;		//There are two players in the Chips Game.
	private boolean playerTwoTurn;		//Each player is represented by her turn.
										//Player One is the user.
	private int choice;					//Player Two is the CPU opponent.
	
	private int chipsRemaining;
	
	private boolean isFinished;
	
	private String message;
	
	private String repeatMessage;
	
	Random rand = new Random();
	
	public ChipsGame() {				//This constructor creates a Chips Game that
										//begins with a random number of chips between
		playerOneTurn = true;			//17 and 19.
		playerTwoTurn = false;
		
		
		chipsRemaining = rand.nextInt(3) + 17;
		
		isFinished = false;
		
		message = getInstructions();
		
		repeatMessage = "Ready to play again? You move first "
				+ "There are "+getChipsRemaining()+" "
				+ "chips remaining. How many would you like "
				+ "to remove?";
		
	}
	
	public ChipsGame(String s) {		//This constructor creates a Chips Game that
										//begins by displaying s as the opening message.
		playerOneTurn = true;
		playerTwoTurn = false;
		
		Random rand = new Random();
		chipsRemaining = rand.nextInt(3) + 17;
		
		isFinished = false;
		
		message = s;
	}
	
	public ChipsGame(int n) {			//This constructor creates a Chips Game that
										//begins with n chips.
		playerOneTurn = true;
		playerTwoTurn = false;
		
		chipsRemaining = n;
		
		isFinished = false;
		
		message = getInstructions();
		
	}
	
	
	public ChipsGame(int n, int m) {		//This constructor creates a Chips Game that
											//begins with a random number of chips between
		playerOneTurn = true;				//n and m.
		playerTwoTurn = false;
		
		Random rand = new Random();
		chipsRemaining = rand.nextInt(m - n + 1) + n;
		
		isFinished = false;
		
		message = getInstructions();
		
	}
	
	public String getInstructions() {
		
		String instructions =   
				  "You are about to play a game of strategy against Nelson Mandela! "
				+ "There is a pile of "+getChipsRemaining()+" chips. You and "
				+ "your opponent, Nelson, take turns removing chips from the pile until "
				+ "there are none left. Each player is allowed to remove one, "
				+ "two, or three chips from the pile during her turn. Each "
				+ "player must remove at least one chip during her turn. No "
				+ "player may remove more than three chips during her turn. Your "
				+ "aim in the game is to remove the last chip from the pile. The "
				+ "player that removes the last chip from the pile wins. Ready "
				+ "to begin? You move first. There are "+getChipsRemaining()+" "
				+ "chips in the pile. How many would you like to remove?";
		
		return instructions;
		
	}
	
	public String getRepeatMessage() {
		
		return repeatMessage;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getEndMessage() {
		String endMessage = 
				"There are no more games to play. Thank you for playing!";
		return endMessage;
	}
	
	public int getChipsRemaining() {
		return chipsRemaining;
	}
	
	public void setChipsRemaining(int numOfChips) {
		chipsRemaining = chipsRemaining - numOfChips;
	}
	
	public boolean getPlayerOneTurn() {
		return playerOneTurn;
	}
	
	public boolean getPlayerTwoTurn() {
		return playerTwoTurn;
	}
	
	public void updateIsFinished() {
		if (chipsRemaining <= 0) {
			isFinished = true;
			if (getPlayerOneTurn() == true) {
				message = "Your opponent removes the last "+(choice)+", "
						+ "leaving none. Your opponent removed the "
						+ "last chip. You lose!";
			}
			else message = "You remove the last "+(choice+chipsRemaining)+", "
					     + "leaving none. You removed the last chip. You win!";
		}
	}
	
	public void setChoice(int n) {
		choice = n;
	}
	
	public int getChoice() {
		return choice;
	}
	
	public void playerOneTurn() {
		setChipsRemaining(choice);
		message = "From the remaining chips, you remove "
				+choice+", leaving "+getChipsRemaining()+".";
		playerOneTurn = false;
		playerTwoTurn = true;
	}
	
	public void playerTwoTurn() {
		if (chipsRemaining % 4 == 0) choice = rand.nextInt(3)+1;
		else choice = chipsRemaining % 4;
		setChipsRemaining(choice);
		message = "From these, your opponent removes "+choice+", "
				+ "leaving "+getChipsRemaining()+" in the pile. "
				+ "How many chips would you like to remove?";
		playerOneTurn = true;
		playerTwoTurn = false;
	}
	
	public boolean getIsFinished() {
		return isFinished;
	}
	
	
}
