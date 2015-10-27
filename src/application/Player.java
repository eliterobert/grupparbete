package application;

public class Player {

	private String name;
	private int score;

	public Player(String name) {
		super();
		this.name = name;
	}

	void increaseScore() {
		score += 1;
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
