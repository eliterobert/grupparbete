package application;

/*
 *Metoder:
 *Time lapsed: r�nkar hur l�nge spelet p�g�tt,
 *Score: l�gger till po�ng till den aktiva spelaren,
 *
 *instansvariabler:
 *Score: po�ngen som skickas till spelaren,
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