package application;

import java.io.File;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {

	public static StartPage startPage;
	private Scene startScene, gameScene;
	public static Card selectedCard = null;

	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
	public static LinkedList<Player> playerList;
	public static Player currentPlayer;

	public static Media musicToPlay;
	public static String musicFile = "";
	public static MediaPlayer mediaPlayer;
	public static Board board;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		musicFile = "Sound/testSound3.mp3";
		musicToPlay = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(musicToPlay);
		mediaPlayer.play();

		startPage = new StartPage();
		startScene = new Scene(startPage, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);

		startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setMinHeight(bounds.getHeight() * 0.7 + 25);
		primaryStage.setMaxHeight(bounds.getHeight() * 0.7 + 25);
		primaryStage.setMinWidth(bounds.getWidth() * 0.7);
		primaryStage.setMaxWidth(bounds.getWidth() * 0.7);
		primaryStage.setTitle("Mamory Game");

		primaryStage.setScene(startScene);
		primaryStage.show();
		startPage.theme1.setOnMouseClicked((evet) -> {
			Bloom bloom = new Bloom();
			bloom.setThreshold(0.2);
			startPage.phantasyStartButton.setEffect(bloom);
			startPage.starWarsButton.setEffect(null);
			startPage.lotrButton.setEffect(null);

		});
		startPage.theme2.setOnMouseClicked((evet) -> {
			Bloom bloom = new Bloom();
			bloom.setThreshold(0.2);
			startPage.starWarsButton.setEffect(bloom);
			startPage.phantasyStartButton.setEffect(null);
			startPage.lotrButton.setEffect(null);
		});

		startPage.theme3.setOnMouseClicked((evet) -> {
			Bloom bloom = new Bloom();
			bloom.setThreshold(0.2);
			startPage.lotrButton.setEffect(bloom);
			startPage.phantasyStartButton.setEffect(null);
			startPage.starWarsButton.setEffect(null);
		});

		startPage.startButton.setOnAction(event -> {

			playerList = new LinkedList<>();
			playerList.add(new Player(startPage.player1.getText(), 1));
			playerList.add(new Player(startPage.player2.getText(), 2));

			if (startPage.theme1.isSelected()) {

				mediaPlayer.stop();
				musicFile = "Sound/DeathPlace.mp3";
				musicToPlay = new Media(new File(musicFile).toURI().toString());
				mediaPlayer = new MediaPlayer(musicToPlay);
				mediaPlayer.play();

				board = new Board("src/PhantasyStarTheme", "PhantasyStarTheme/",
						"/Backgroundpictures/phantasyBackCard.png", "/Backgroundpictures/backgroud.jpg", 8, 4, 4);

				gameScene = new Scene(board, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);
				gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				board.player1.setText(playerList.get(0).getName());
				board.player2.setText(playerList.get(1).getName());

				primaryStage.setScene(gameScene);

				currentPlayer = playerList.poll();

				primaryStage.setScene(gameScene);
				board.menu.setOnMouseClicked((a) -> {

					mediaPlayer.stop();
					musicFile = "Sound/testSound3.mp3";
					musicToPlay = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(musicToPlay);
					mediaPlayer.play();

					primaryStage.setScene(startScene);
				});
			}

			else if (startPage.theme2.isSelected()) {

				mediaPlayer.stop();
				musicFile = "Sound/TestSound1.mp3";
				musicToPlay = new Media(new File(musicFile).toURI().toString());
				mediaPlayer = new MediaPlayer(musicToPlay);
				mediaPlayer.play();

				board = new Board("src/Pictures", "Pictures/", "Backgroundpictures/backgroundCard.png",
						"Backgroundpictures/javaNewBackground.jpg", 8, 4, 4);

				gameScene = new Scene(board, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);
				gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				board.player1.setText(playerList.get(0).getName());
				board.player2.setText(playerList.get(1).getName());

				primaryStage.setScene(gameScene);

				currentPlayer = playerList.poll();

				primaryStage.setScene(gameScene);
				board.menu.setOnMouseClicked((a) -> {

					mediaPlayer.stop();
					musicFile = "Sound/testSound3.mp3";
					musicToPlay = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(musicToPlay);
					mediaPlayer.play();

					primaryStage.setScene(startScene);
				});
			}

			else if (startPage.theme3.isSelected()) {

				mediaPlayer.stop();
				musicFile = "Sound/LOTR.mp3";
				musicToPlay = new Media(new File(musicFile).toURI().toString());
				mediaPlayer = new MediaPlayer(musicToPlay);
				mediaPlayer.play();

				board = new Board("src/LOTRThemePics", "LOTRThemePics/", "Backgroundpictures/BackgroundCardLOTR.png",
						"Backgroundpictures/BackgroundLOTR.jpg", 8, 4, 4);

				gameScene = new Scene(board, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);
				gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				board.player1.setText(playerList.get(0).getName());
				board.player2.setText(playerList.get(1).getName());

				primaryStage.setScene(gameScene);

				currentPlayer = playerList.poll();
				board.menu.setOnMouseClicked((a) -> {

					mediaPlayer.stop();
					musicFile = "Sound/testSound3.mp3";
					musicToPlay = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(musicToPlay);
					mediaPlayer.play();

					primaryStage.setScene(startScene);
				});
			}
		});

	}

}
