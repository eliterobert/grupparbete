package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	private StartPage startPage;
	private Board board;
	private Scene startScene, boardScene;
	public static Card selectedCard = null;

	public LinkedList<Player> playerList;

	public static void main(String[] args) {
		sound();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		startPage = new StartPage();
		startScene = new Scene(startPage, 1920 * 0.7, 1080 * 0.7);

		startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setMinHeight(1080 * 0.73);
		primaryStage.setMaxHeight(1080 * 0.73);
		primaryStage.setMinWidth(1920 * 0.7);
		primaryStage.setMaxWidth(1920 * 0.7);
		primaryStage.setScene(boardScene);

		primaryStage.setScene(startScene);
		primaryStage.show();
		startPage.startButton.setOnAction(event -> {
			playerList = new LinkedList<>();

			playerList.add(new Player(startPage.p1.getText(), 0));
			playerList.add(new Player(startPage.p2.getText(), 0));

			board = new Board();
			board.player1.setText(playerList.get(0).getName());
			board.player2.setText(playerList.get(1).getName());

			board.player1Score.setText(playerList.get(0).getScore() + "");
			board.player2Score.setText(playerList.get(1).getScore() + "");

			boardScene = new Scene(board, 1920 * 0.7, 1080 * 0.7);
			boardScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(boardScene);
			primaryStage.show();
		});

	}

	public static void sound() {

		String musicFile = "Sound/testSound1.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}

}
