package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Board extends VBox {
	
	HBox hBox1 = new HBox();
	HBox hBox2 = new HBox();
	
	
	//GridPane gridpane = new GridPane();
	
	Label player1 = new Label("Player 1");
	Label player2 = new Label("Player 2");
	Label turn = new Label("Turn: 15");
	Label player1Score = new Label("Score: 5");
	Label player2Score = new Label("Score: 10");
	Label menu = new Label("Menu");
	
	
	/*BackgroundImage backgroundImage = new BackgroundImage(new Image("Pictures/javaStarwarsBackground1.jpg", 470, 766,false,true),
	        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	
	Image image = new Image("Pictures/backgroundCard.png", 90, 90, false, false);
	*/
	public Board(){
		
		setSpacing(5);
		
		//setBackground(new Background(backgroundImage));
		
		player1.setTextFill(Color.AQUA);
		player2.setTextFill(Color.AQUA);
		turn.setTextFill(Color.AQUA);
		menu.setTextFill(Color.AQUA);
		player1Score.setTextFill(Color.AQUA);
		player2Score.setTextFill(Color.AQUA);
		
		player1.setTranslateX(50);
		player2.setTranslateX(300);
		turn.setTranslateX(175);
		
		player1Score.setTranslateX(50);
		player2Score.setTranslateX(300);
		menu.setTranslateX(175);
		
		//gridpane.setHgap(10);
		//gridpane.setVgap(30);
		
		/*
		for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
            	ImageView view = new ImageView(image);
            	gridpane.add(view, i, j);
            }
        }
		*/
		
		hBox1.getChildren().addAll(player1, turn, player2);
		hBox1.setTranslateY(110);
		hBox2.getChildren().addAll(player1Score, menu, player2Score);
		hBox2.setTranslateY(120);
		//gridpane.setTranslateX(40);
		//gridpane.setTranslateY(60);
		//getChildren().addAll(gridpane, hBox1, hBox2);
		getChildren().addAll(hBox1, hBox2);

	}
}
