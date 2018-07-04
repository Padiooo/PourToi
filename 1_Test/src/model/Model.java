package model;

public class Model {

	private Player playerOne;
	private Player playerTwo;
	private SpriteSheet spriteSheet;

	private int playerOneScore = 0;
	private int playerTwoScore = 0;

	public Model() {
		this.spriteSheet = new SpriteSheet();
		this.playerOne = new Player(spriteSheet, "red", 1);
		this.playerTwo = new Player(spriteSheet, "blue", 2);
	}
	

	public String getPlayerOneScore() {
		return String.valueOf(playerOneScore);
	}

	public String getPlayerTwoScore() {
		return String.valueOf(playerTwoScore);
	}
	
	/************ Normal Getters and Setters ************/

	public Player getPlayerOne() {
		return playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public void setSpriteSheet(SpriteSheet spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

	public void setPlayerOneScore(int playerOneScore) {
		this.playerOneScore = playerOneScore;
	}

	public void setPlayerTwoScore(int playerTwoScore) {
		this.playerTwoScore = playerTwoScore;
	}


}
