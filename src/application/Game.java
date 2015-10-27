package application;

import javax.swing.Timer;

public class Game 
{
	
	int score;
	
	// Constructor 

	public Game(int score) {
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
	
	// dåliga metoder 
	
	void collectScore(int score) {
		
		score++;
		
		this.score = score;
	}
	
	void startClock (boolean startOnAction) {
		
		Timer t = new Timer(1000, startOnAction);
		
		t.start();
		
	}
	
	
		
		

}
