package application;

/*
 *Metoder:
 *Time lapsed: ränkar hur länge spelet pågått,
 *Score: lägger till poäng till den aktiva spelaren,
 *
 *instansvariabler:
 *Score: poängen som skickas till spelaren,
 *Time: en nummervariabel
 *
 */

public class ScoreAndTime {

	int score;

	// Constructor

	public ScoreAndTime(int score) {
		super();
		this.score = score;
	}

	// Getters och setters

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

//	int calcScore(boolean isSameKind, Player player) {

//		int scores = 0;

//		if (isSameKind == true && player.getName().isTurn()) {

//			scores = player.getName().getScore() + 1;

//		}

//		return scores;

//	}

}