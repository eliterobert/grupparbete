package application;

import java.util.Timer;

/*
 *Metoder:
 *Time lapsed: ränkar hur länge spelet pågått. Sprängsvårt
 *Score: lägger till poäng till den aktiva spelaren,
 *
 *instansvariabler:
 *Score: poängen som skickas till spelaren,
 *Time: en nummervariabel
 *
 *ScoreAndTime och Turns kommer antagligen slås ihop
 *
 */

public class ScoreAndTime {

	
		// stopwatch på google. Label 
	Timer timer = new Timer();

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

	// Utkast av metod.

	int calcScore(boolean isSameKind, Player player) {

		int scores = 0;

		if (isSameKind == true && player.isTurn()) {

			scores = player.getScore() + 1;

		}

		return scores;

	}

}