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

	int score;

	public ScoreAndTime(int score) {
		super();
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	int calcScore(boolean isSameKind, Player player) {

		int scores = 0;

		if (isSameKind == true && player.isTurn()) {

			scores = player.getScore() + 1;

		}

		return scores;

	}

	// Klockan skriver endast ut till konsoll i dagsläget.
	// La upp den för allas beskådning om man vill tipsa och trixa.
	// Stäm av innan med resten av gruppen om ni kommit på eller hittat något!

	void clock() {

		long startTime = System.currentTimeMillis() / 1000;

		while (true) {

			long currentTime = System.currentTimeMillis() / 1000 - startTime;

			long remainingMinutes = currentTime / 60;

			long minutes = remainingMinutes % 60;

			long hours = minutes / 60;

			long remainingsSeconds = currentTime % 60;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(hours + ":" + minutes + ":" + remainingsSeconds);
		}

	}

}