package application;

public class Turns {

	/*
	 * Metoder:
	 * 
	 * Total Turns: beräknar totala antalet rundor som har spelats. ex. en
	 * spelare vänder två kort de är int lika vilket leder till en runda, om han
	 * däremot för rätt ska en extra runda läggas till då han får spela nästa
	 * runda också.
	 * 
	 * Player turn: Ska bestämma vilken spelares tur det är, den ska ha nån typ
	 * av true/false alt. en modulusliknande operator som i sin tur ger
	 * true/false
	 * 
	 */
	// Sätter antalet spelade rundor plus ett och retunerar antalet spelade
	// rundor för utskrift
	int numOfTurns;
	int pTurn;

	int totalTurns() {
		numOfTurns++;
		return numOfTurns;
	}

	// Återställer antalet spelade rundor om man t.ex. startar om spelet.
	// Bör
	// kallas av den funktion som återställer spelet till ett nytt spel
	void resetTurns() {
		numOfTurns -= numOfTurns;
	}

	boolean playerTurn() {
		pTurn++;
		if (pTurn % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
