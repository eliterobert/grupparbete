package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import application.Card;

public class PhantasyStarBoard extends VBox {
	private ArrayList<Image> imageList;
	public boolean isSelectedTheme;

	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();

	HBox hBox1 = new HBox();
	HBox hBox2 = new HBox();
	VBox vBox1 = new VBox();
	VBox vBox2 = new VBox();

	GridPane gridpane = new GridPane();

	Label player1 = new Label("Player 1");
	Label player2 = new Label("Player 2");
	Label turn = new Label("Turn: 15");
	Label player1Score = new Label("Score: 0");
	Label player2Score = new Label("Score: 0");
	Label menu = new Label("Menu");

	// BackgroundImage backgroundImage = new BackgroundImage(new
	// Image("Background pictures/javaNewBackground.jpg", 1920*0.7,
	// 1080*0.7,false,true),
	// BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
	// BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	BackgroundImage backgroundImage = new BackgroundImage(
			new Image("Backgroundpictures/backgroud.jpg", bounds.getWidth() * 0.7, bounds.getHeight() * 0.7, false,
					true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	Image image = new Image("Backgroundpictures/phantasyBackCard.png", bounds.getWidth() * 0.06,
			bounds.getWidth() * 0.06, true, true);

	public PhantasyStarBoard() {

		getPictures();
		Collections.shuffle(imageList);
		sound();

		setSpacing(5);

		setBackground(new Background(backgroundImage));

		player1.setTextFill(Color.AQUA);
		player2.setTextFill(Color.AQUA);
		turn.setTextFill(Color.AQUA);
		menu.setTextFill(Color.AQUA);
		player1Score.setTextFill(Color.AQUA);
		player2Score.setTextFill(Color.AQUA);

		/*
		 * player1.setTranslateX(50); player2.setTranslateX(300);
		 * turn.setTranslateX(175);
		 * 
		 * player1Score.setTranslateX(50); player2Score.setTranslateX(300);
		 * menu.setTranslateX(175);
		 */

		gridpane.setHgap(bounds.getWidth() * 0.02);
		gridpane.setVgap(bounds.getHeight() * 0.03);

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				gridpane.add(new Card(imageList.get(cnt), image), i, j);
				cnt++;
			}
		}

		vBox1.getChildren().addAll(player1, player1Score);
		vBox2.getChildren().addAll(player2, player2Score);
		hBox1.getChildren().addAll(vBox1, gridpane, vBox2);
		hBox2.getChildren().add(menu);

		hBox1.setTranslateY(bounds.getHeight() * 0.065);
		// hBox1.setTranslateX(bounds.getWidth()*0.03);
		hBox1.setAlignment(Pos.BASELINE_CENTER);
		hBox1.setSpacing(bounds.getWidth() * 0.11);
		hBox2.setTranslateX(bounds.getWidth() * 0.7 / 2);
		hBox2.setTranslateY(bounds.getHeight() * 0.10);

		getChildren().addAll(hBox1, hBox2);

		/*
		 * hBox1.getChildren().addAll(player1, turn, player2);
		 * hBox1.setTranslateY(110); hBox2.getChildren().addAll(player1Score,
		 * menu, player2Score); hBox2.setTranslateY(120);
		 * gridpane.setTranslateX(320); gridpane.setTranslateY(75);
		 * getChildren().addAll(gridpane, hBox1, hBox2);
		 */
		// getChildren().addAll(hBox1, hBox2);

	}

	private void getPictures() {
		imageList = new ArrayList<>();

		File imageDirectory = new File("src/PhantasyStarTheme");
		String[] directoryList = imageDirectory.list();

		for (int i = 0; i < directoryList.length; i++) {
			imageList.add(new Image("PhantasyStarTheme/" + directoryList[i], bounds.getWidth() * 0.06,
					bounds.getWidth() * 0.06, true, true));
			imageList.add(new Image("PhantasyStarTheme/" + directoryList[i], bounds.getWidth() * 0.06,
					bounds.getWidth() * 0.06, true, true));

		}
	}

	public static void sound() {

		String musicFile = "Sound/DeathPlace.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(10);
		mediaPlayer.play();
	}
}