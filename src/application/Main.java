package application;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {

	public Main main;

	private StartPage startPage;
	private Scene startScene;
	private Scene gameScene;
	private Card selectedCard = null;
	private int clickCount = 2;

	private Screen screen;
	private Rectangle2D bounds;

	private LinkedList<Player> playerList;
	private Player currentPlayer;
	private int pointCount;
	private int numOfCards;

	private Media musicToPlay;
	private String musicFile = "";
	private MediaPlayer mediaPlayer;
	private Board board, winnerBoard;
	private Stage mainStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		screen = Screen.getPrimary();
		bounds = screen.getVisualBounds();

		main = this;

		mainStage = primaryStage;

		musicFile = "Sound/testSound3.mp3";
		musicToPlay = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(musicToPlay);
		mediaPlayer.setVolume(0.1);
		mediaPlayer.play();

		startPage = new StartPage();
		startScene = new Scene(startPage, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);

		setBounds();

		primaryStage.setTitle("Memory Game");
		primaryStage.setScene(startScene);
		primaryStage.show();

		startPage.getTheme1().setOnMouseClicked((evet) -> {
			bloomEffect(startPage.getPhantasyStartButton(), startPage.getStarWarsButton(), startPage.getLotrButton());

		});
		startPage.getTheme2().setOnMouseClicked((evet) -> {
			bloomEffect(startPage.getStarWarsButton(), startPage.getLotrButton(), startPage.getPhantasyStartButton());
		});

		startPage.getTheme3().setOnMouseClicked((evet) -> {
			bloomEffect(startPage.getLotrButton(), startPage.getPhantasyStartButton(), startPage.getStarWarsButton());
		});

		startPage.getStartButton().setOnAction(event -> {

			playerList = new LinkedList<>();
			playerList.add(new Player(startPage.getPlayer1().getText(), 1));
			playerList.add(new Player(startPage.getPlayer2().getText(), 2));

			numOfCards = 0;
			int row = 0;
			int col = 0;
			if (startPage.getCardsChoise12().isSelected()) {
				numOfCards = 6;
				row = 3;
				col = 4;
			} else if (startPage.getCardsChoise16().isSelected()) {
				numOfCards = 8;
				row = 4;
				col = 4;
			} else if (startPage.getCardsChoise32().isSelected()) {
				numOfCards = 10;
				row = 5;
				col = 4;
			}

			if (startPage.getTheme1().isSelected()) {

				mediaPlayer.stop();
				musicFile = "Sound/DeathPlace.mp3";
				musicToPlay = new Media(new File(musicFile).toURI().toString());
				mediaPlayer = new MediaPlayer(musicToPlay);
				mediaPlayer.setVolume(0.4);
				mediaPlayer.play();

				board = new Board("src/PhantasyStarTheme", "PhantasyStarTheme/",
						"/Backgroundpictures/phantasyBackCard.png", "/Backgroundpictures/backgroud.jpg", numOfCards,
						row, col, main);

				gameScene = new Scene(board, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);
				board.getPlayer1().setText(playerList.get(0).getName());
				board.getPlayer2().setText(playerList.get(1).getName());

				primaryStage.setScene(gameScene);

				currentPlayer = playerList.poll();

				primaryStage.setScene(gameScene);
				board.getMenu().setOnMouseClicked((a) -> {

					mediaPlayer.stop();
					musicFile = "Sound/testSound3.mp3";
					musicToPlay = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(musicToPlay);
					mediaPlayer.setVolume(0.1);
					mediaPlayer.play();
					primaryStage.setScene(startScene);
				});
			}

			else if (startPage.getTheme2().isSelected()) {

				mediaPlayer.stop();
				musicFile = "Sound/TestSound1.mp3";
				musicToPlay = new Media(new File(musicFile).toURI().toString());
				mediaPlayer = new MediaPlayer(musicToPlay);
				mediaPlayer.play();

				board = new Board("src/Pictures", "Pictures/", "Backgroundpictures/backgroundCard.png",
						"Backgroundpictures/javaNewBackground.jpg", numOfCards, row, col, main);

				gameScene = new Scene(board, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);
				gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				board.getPlayer1().setText(playerList.get(0).getName());
				board.getPlayer2().setText(playerList.get(1).getName());

				primaryStage.setScene(gameScene);

				currentPlayer = playerList.poll();

				primaryStage.setScene(gameScene);
				board.getMenu().setOnMouseClicked((a) -> {

					mediaPlayer.stop();
					musicFile = "Sound/testSound3.mp3";
					musicToPlay = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(musicToPlay);
					mediaPlayer.setVolume(0.1);
					mediaPlayer.play();

					primaryStage.setScene(startScene);
				});
			}

			else if (startPage.getTheme3().isSelected()) {

				mediaPlayer.stop();
				musicFile = "Sound/LOTR.mp3";
				musicToPlay = new Media(new File(musicFile).toURI().toString());
				mediaPlayer = new MediaPlayer(musicToPlay);
				mediaPlayer.play();

				board = new Board("src/LOTRThemePics", "LOTRThemePics/", "Backgroundpictures/BackgroundCardLOTR.png",
						"Backgroundpictures/BackgroundLOTR.jpg", numOfCards, row, col, main);

				gameScene = new Scene(board, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7);
				gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				board.getPlayer1().setText(playerList.get(0).getName());
				board.getPlayer2().setText(playerList.get(1).getName());

				primaryStage.setScene(gameScene);

				currentPlayer = playerList.poll();
				board.getMenu().setOnMouseClicked((a) -> {

					mediaPlayer.stop();
					musicFile = "Sound/testSound3.mp3";
					musicToPlay = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(musicToPlay);
					mediaPlayer.setVolume(0.1);
					mediaPlayer.play();

					primaryStage.setScene(startScene);
				});
			}

		});

	}

	private void bloomEffect(ImageView bloomButton, ImageView nullButton1, ImageView nullButton2) {
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.2);
		bloomButton.setEffect(bloom);
		nullButton1.setEffect(null);
		nullButton2.setEffect(null);
	}

	public void HighScoreInput() {

		// Player 1
		int scoreP1 = playerList.get(0).getScore();
		String Scorep1S = Integer.toString(scoreP1);
		String nameP1 = playerList.get(0).getName();
		String totaltP1 = nameP1 + " Score: " + Scorep1S;

		// Player 2

		int scoreP2 = currentPlayer.getScore();
		String Scorep2s = Integer.toString(scoreP2);
		String nameP2 = currentPlayer.getName();
		String totaltP2 = nameP2 + " Score: " + Scorep2s;

		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH:mm");
		Calendar cal = Calendar.getInstance();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/Highscore/Highscore.txt"), true))) {
			bw.append(dateFormat.format(cal.getTime()) + "\n" + totaltP1 + " vs " + totaltP2 + "\n\n");

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public LinkedList<String> readScores() {
		LinkedList<String> scores = new LinkedList<>();

		try (BufferedReader buff = new BufferedReader(new FileReader("src/Highscore/Highscore.txt"))) {
			while (buff.readLine() != null) {
				scores.addFirst(buff.readLine() + "\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scores;
	}

	public void setBounds() {
		mainStage.setMinHeight(bounds.getHeight() * 0.7 + 25);
		mainStage.setMaxHeight(bounds.getHeight() * 0.7 + 25);
		mainStage.setMinWidth(bounds.getWidth() * 0.7);
		mainStage.setMaxWidth(bounds.getWidth() * 0.7);
	}

	public void startWinnerScene() {
		
		

		WinnerPage winnerPage = new WinnerPage(main);

		mediaPlayer.stop();
		musicFile = "Sound/winnerSong.mp3";
		musicToPlay = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(musicToPlay);

		mediaPlayer.play();

		gameScene = new Scene(winnerPage);
		gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainStage.setMaxHeight(450);
		mainStage.setMinHeight(450);
		mainStage.setMaxWidth(1000);
		mainStage.setMinWidth(1000);
		mainStage.setScene(gameScene);
		if (pointCount == numOfCards) {
			int player1 = Integer.parseInt(board.getPlayer1Score().getText());
			int player2 = Integer.parseInt(board.getPlayer2Score().getText());
			if (player1 > player2) {
				winnerPage.getPlayerName().setText(board.getPlayer1().getText());
			} else if (player1 == player2) {
				winnerPage.getWinner().setText("NO ONE WON!");
				winnerPage.getPlayerName().setText("PlaYAGAIN!");
			} else if (player1 < player2) {
				winnerPage.getPlayerName().setText(board.getPlayer2().getText());
			}
		}
	}

	public StartPage getStartPage() {
		return startPage;
	}

	public void setStartPage(StartPage startPage) {
		this.startPage = startPage;
	}

	public Scene getStartScene() {
		return startScene;
	}

	public void setStartScene(Scene startScene) {
		this.startScene = startScene;
	}

	public Scene getGameScene() {
		return gameScene;
	}

	public void setGameScene(Scene gameScene) {
		this.gameScene = gameScene;
	}

	public Card getSelectedCard() {
		return selectedCard;
	}

	public void setSelectedCard(Card selectedCard) {
		this.selectedCard = selectedCard;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Rectangle2D getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle2D bounds) {
		this.bounds = bounds;
	}

	public LinkedList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(LinkedList<Player> playerList) {
		this.playerList = playerList;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getPointCount() {
		return pointCount;
	}

	public void setPointCount(int pointCount) {
		this.pointCount = pointCount;
	}

	public int getNumOfCards() {
		return numOfCards;
	}

	public void setNumOfCards(int numOfCards) {
		this.numOfCards = numOfCards;
	}

	public Media getMusicToPlay() {
		return musicToPlay;
	}

	public void setMusicToPlay(Media musicToPlay) {
		this.musicToPlay = musicToPlay;
	}

	public String getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(String musicFile) {
		this.musicFile = musicFile;
	}

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getWinnerBoard() {
		return winnerBoard;
	}

	public void setWinnerBoard(Board winnerBoard) {
		this.winnerBoard = winnerBoard;
	}

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
}
