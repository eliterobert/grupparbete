package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {

	public static StartPage startPage;
	public static WinnerPage wp = new WinnerPage();
	private Scene startScene, gameScene;
	private Scene winnerScene = new Scene(wp);
	public static Card selectedCard = null;
	public static int clickCount = 2;

	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
	public static LinkedList<Player> playerList;
	public static Player currentPlayer;
	public static int turnTimer;
	public static int numOfCards;

	private Media musicToPlay;
	private String musicFile = "";
	private MediaPlayer mediaPlayer;
	public static Board board, winnerBoard;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		musicFile = "Sound/testSound3.mp3";
		musicToPlay = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(musicToPlay);
		//mediaPlayer.play();

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
			bloomEffect(startPage.phantasyStartButton, startPage.starWarsButton, startPage.lotrButton);

		});
		startPage.theme2.setOnMouseClicked((evet) -> {
			bloomEffect(startPage.starWarsButton, startPage.lotrButton, startPage.phantasyStartButton);
		});

		startPage.theme3.setOnMouseClicked((evet) -> {
			bloomEffect(startPage.lotrButton, startPage.phantasyStartButton, startPage.starWarsButton);
		});

		startPage.startButton.setOnAction(event -> {

			playerList = new LinkedList<>();
			playerList.add(new Player(startPage.player1.getText(), 1));
			playerList.add(new Player(startPage.player2.getText(), 2));

			numOfCards = 0;
			int row = 0;
			int col = 0;
			if (startPage.cardsChoise8.isSelected()) {
				numOfCards = 6;
				row = 4;
				col = 3;
			} else if (startPage.cardsChoise16.isSelected()) {
				numOfCards = 8;
				row = 4;
				col = 4;
			} else if (startPage.cardsChoise32.isSelected()) {
				numOfCards = 10;
				row = 5;
				col = 4;
			}
			if (startPage.theme1.isSelected()) {
				

				mediaPlayer.stop();
				musicFile = "Sound/DeathPlace.mp3";
				musicToPlay = new Media(new File(musicFile).toURI().toString());
				mediaPlayer = new MediaPlayer(musicToPlay);
				mediaPlayer.play();

				board = new Board("src/PhantasyStarTheme", "PhantasyStarTheme/",
						"/Backgroundpictures/phantasyBackCard.png", "/Backgroundpictures/backgroud.jpg", numOfCards,
						row, col);

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
						"Backgroundpictures/javaNewBackground.jpg", numOfCards, row, col);

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
						"Backgroundpictures/BackgroundLOTR.jpg", numOfCards, row, col);

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

			board.highScoreButton.setOnAction((a) -> {

				if (turnTimer == numOfCards) {
					int player1 = Integer.parseInt(board.player1Score.getText());
					int player2 = Integer.parseInt(board.player2Score.getText());

					if (player1 > player2) {
						wp.playerName.setText(board.player1.getText());
					} else if (player1 == player2) {
						wp.playerName.setText(board.player1.getText() + "" + board.player2.getText());
					} else if (player1 < player2) {
						wp.playerName.setText(board.player2.getText());
					}

					primaryStage.setScene(winnerScene);
					primaryStage.setMaxHeight(450);
					primaryStage.setMinHeight(450);
					primaryStage.setMaxWidth(1000);
					primaryStage.setMinWidth(1000);
					mediaPlayer.stop();
					musicFile = "Sound/winnerSong.mp3";
					musicToPlay = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(musicToPlay);
					mediaPlayer.play();
					turnTimer = 0;

				}

			});

		});

		wp.returnButton.setOnAction(event -> {

			primaryStage.setScene(startScene);
			primaryStage.setMinHeight(bounds.getHeight() * 0.7 + 25);
			primaryStage.setMaxHeight(bounds.getHeight() * 0.7 + 25);
			primaryStage.setMinWidth(bounds.getWidth() * 0.7);
			primaryStage.setMaxWidth(bounds.getWidth() * 0.7);

		});

	}

	private void bloomEffect(ImageView bloomButton, ImageView nullButton1, ImageView nullButton2) {
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.2);
		bloomButton.setEffect(bloom);
		nullButton1.setEffect(null);
		nullButton2.setEffect(null);
	}
	
	public void HighScore (String result) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar cal = Calendar.getInstance();
		
	try {
		
		BufferedWriter bf = new BufferedWriter(new FileWriter("src/Highscore/Highscore.txt"));
		bf.write(result + dateFormat.format(cal.getTime()));
		
		bf.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
