package application;

import java.util.Timer;

/*
 *Metoder:
 *Time lapsed: r�nkar hur l�nge spelet p�g�tt. Spr�ngsv�rt
 *Score: l�gger till po�ng till den aktiva spelaren,
 *
 *instansvariabler:
 *Score: po�ngen som skickas till spelaren,
 *Time: en nummervariabel
 *
 *ScoreAndTime och Turns kommer antagligen sl�s ihop
 *
 */

public class ScoreAndTime {

	
		// stopwatch p� google. Label 
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