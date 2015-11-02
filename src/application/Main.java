package application;

import java.io.File;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {

	private StartPage startPage;
	public static Board board;
	private Scene startScene, boardScene, phantasyStarScene;
	public static Card selectedCard = null;
	public static PhantasyStarBoard phantasyStarBoard;

	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
	public static LinkedList<Player> playerList;
	public static Player currentPlayer;

	public static void main(String[] args) {
		sound();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		startPage = new StartPage();
		startScene = new Scene(startPage, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);

		startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// primaryStage.setMinHeight(1080 * 0.73);
		// primaryStage.setMaxHeight(1080 * 0.73);
		// primaryStage.setMinWidth(1920 * 0.7);
		// primaryStage.setMaxWidth(1920 * 0.7);
		// primaryStage.setScene(boardScene);

		primaryStage.setMinHeight(bounds.getHeight() * 0.7 + 25);
		primaryStage.setMaxHeight(bounds.getHeight() * 0.7 + 25);
		primaryStage.setMinWidth(bounds.getWidth() * 0.7);
		primaryStage.setMaxWidth(bounds.getWidth() * 0.7);
		primaryStage.setTitle("Mamory Game");

		primaryStage.setScene(startScene);
		primaryStage.show();

		startPage.startButton.setOnAction(event -> {

			playerList = new LinkedList<>();
			playerList.add(new Player(startPage.player1.getText()));
			playerList.add(new Player(startPage.player2.getText()));
			
			if (startPage.theme1.isSelected()) {

				phantasyStarBoard = new PhantasyStarBoard();
				phantasyStarBoard.player1.setText(playerList.get(0).getName());
				phantasyStarBoard.player2.setText(playerList.get(1).getName());

				phantasyStarScene = new Scene(phantasyStarBoard, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);
				phantasyStarScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				currentPlayer = playerList.poll();
				
				primaryStage.setScene(phantasyStarScene);
			}

			else if (startPage.theme2.isSelected()) {

				board = new Board();
				board.player1.setText(playerList.get(0).getName());
				board.player2.setText(playerList.get(1).getName());

				board.player1Score.setText(playerList.get(0).getScore() + "");
				board.player2Score.setText(playerList.get(1).getScore() + "");

				// boardScene = new Scene(board, 1920 * 0.7, 1080 * 0.7);
				// boardScene = new Scene(board, bounds.getWidth() * 0.7,
				// bounds.getHeight() * 0.7);
				// boardScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				boardScene = new Scene(board, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);
				boardScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				currentPlayer = playerList.poll();
				
				primaryStage.setScene(boardScene);
			}
		});

	}

	public static void sound() {

		String musicFile = "Sound/testSound1.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
	}

}
