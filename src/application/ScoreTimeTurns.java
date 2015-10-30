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

public class ScoreTimeTurns {


	void calcScore(Player player) {

		if (player.isTurn()==true) {

			player.setScore(+1);

		}


	}

	// Klockan skriver endast ut till konsoll i dagsl�get.
	// La upp den f�r allas besk�dning om man vill tipsa och trixa.
	// St�m av innan med resten av gruppen om ni kommit p� eller hittat n�got!

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

	// Player turn
	int numOfTurns;
	int pTurn;

	int totalTurns() {
		numOfTurns++;
		return numOfTurns;
	}

	// �terst�ller antalet spelade rundor om man t.ex. startar om spelet.
	// B�r
	// kallas av den funktion som �terst�ller spelet till ett nytt spel
	void resetTurns() {
		numOfTurns -= numOfTurns;
	}

	int turnAdd() {
		return pTurn++;
	}

	boolean playerTurn() {

		if (pTurn % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}
}