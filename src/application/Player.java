package application;

public class Player {

	private String name;
	private int score;

	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	void increaseScore() {

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
