package application;

public class Player {

	private String name;
	private int score;
	private boolean isTurn;

	public Player(String name) {
		this.name = name;
		score = 0;
	}
	
	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	void increaseScore() {
		this.score++;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

}
