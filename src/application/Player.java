package application;

public class Player {

	private String name;
	private int score;
	private boolean isTurn;

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	void increaseScore() {
		this.score += 1;
	}

	void setCurrent(boolean isCurrent) {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
