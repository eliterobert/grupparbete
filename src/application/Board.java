package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

public class Board extends BorderPane {

	private Main refToMain;

	private HBox hBox2, hBox3, hBox4;
	private VBox vBox1, vBox2;
	private Label player1, player2, turn, player1Score, player2Score, menu, scoreText1, scoreText2;
	private GridPane gridpane;
	private Image backImage;
	private ArrayList<Image> imageList;

	private Screen screen;
	private Rectangle2D bounds;

	public Board(String cardsPath, String cardsPath2, String imgBgPath, String bgPath, int numOfPics, int col, int row,
			Main mainRef) {

		screen = Screen.getPrimary();
		bounds = screen.getVisualBounds();

		refToMain = mainRef;

		hBox2 = new HBox();
		hBox3 = new HBox();
		hBox4 = new HBox();
		vBox1 = new VBox();
		vBox2 = new VBox();

		setPlayer1(new Label("Player 1"));
		setPlayer2(new Label("Player 2"));

		turn = new Label("Turn: 15");
		setPlayer1Score(new Label("0"));
		setPlayer2Score(new Label("0"));
		setMenu(new Label("Back to Start"));
		getMenu().setFont(Font.font("Segoe Script", 30));
		scoreText1 = new Label("Score: ");
		scoreText2 = new Label("Score: ");
		gridpane = new GridPane();

		BackgroundImage backgroundImage = new BackgroundImage(
				new Image(bgPath, bounds.getWidth() * 0.7, bounds.getHeight() * 0.7, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		backImage = new Image(imgBgPath, bounds.getWidth() * 0.06, bounds.getWidth() * 0.06, true, true);

		setBackground(new Background(backgroundImage));

		getPlayer1().setTextFill(Color.AQUA);
		getPlayer2().setTextFill(Color.AQUA);
		turn.setTextFill(Color.AQUA);
		getMenu().setTextFill(Color.AQUA);
		getMenu().setAlignment(Pos.TOP_CENTER);
		getPlayer1Score().setTextFill(Color.AQUA);
		getPlayer2Score().setTextFill(Color.AQUA);
		scoreText1.setTextFill(Color.AQUA);
		scoreText2.setTextFill(Color.AQUA);

		gridpane.setHgap(bounds.getWidth() * 0.02);
		gridpane.setVgap(bounds.getHeight() * 0.03);

		vBox1.setMinWidth(150);
		vBox1.setMaxWidth(150);
		vBox2.setMinWidth(150);
		vBox2.setMaxWidth(150);

		hBox3.getChildren().addAll(scoreText1, getPlayer1Score());
		hBox4.getChildren().addAll(scoreText2, getPlayer2Score());

		vBox1.getChildren().addAll(getPlayer1(), hBox3);
		vBox2.getChildren().addAll(getPlayer2(), hBox4);
		hBox2.getChildren().addAll(getMenu());

		getMenu().setOnMouseEntered((event) -> {
			Bloom bloom = new Bloom();
			bloom.setThreshold(0.2);
			getMenu().setEffect(bloom);
		});
		getMenu().setOnMouseExited((event) -> {
			getMenu().setEffect(null);
		});

		highligtPlayer1();

		hBox2.setAlignment(Pos.CENTER);
		gridpane.setAlignment(Pos.BASELINE_CENTER);
		this.setPadding(new Insets(55, 0, 25, 55));

		this.setCenter(gridpane);
		this.setLeft(vBox1);
		this.setRight(vBox2);
		this.setBottom(hBox2);

		getPictures(cardsPath, cardsPath2, numOfPics, col, row);
		Collections.shuffle(imageList);
	}

	private void getPictures(String cardsPath, String cardsPath2, int numOfPics, int col, int row) {
		imageList = new ArrayList<>();

		File imageDirectory = new File(cardsPath);
		String[] directoryList = imageDirectory.list();

		for (int i = 0; i < numOfPics; i++) {
			imageList.add(new Image(cardsPath2 + directoryList[i], bounds.getWidth() * 0.06, bounds.getWidth() * 0.06,
					true, true));
			imageList.add(new Image(cardsPath2 + directoryList[i], bounds.getWidth() * 0.06, bounds.getWidth() * 0.06,
					true, true));
		}
		Collections.shuffle(imageList);
		int cnt = 0;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				gridpane.add(new Card(imageList.get(cnt), backImage, refToMain), i, j);
				cnt++;
			}
		}
	}

	public void highligtPlayer1() {
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.3);

		getPlayer1().setFont(Font.font("Segoe Script", FontWeight.BOLD, 20));
		getPlayer2().setFont(Font.font("Segoe Script", FontWeight.NORMAL, 20));

		getPlayer1().setEffect(bloom);
		getPlayer2().setEffect(null);
	}

	public void highligtPlayer2() {
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.3);

		getPlayer1().setFont(Font.font("Segoe Script", FontWeight.NORMAL, 20));
		getPlayer2().setFont(Font.font("Segoe Script", FontWeight.BOLD, 20));

		getPlayer1().setEffect(null);
		getPlayer2().setEffect(bloom);

	}

	public void setScorePlayer1(String score) {
		getPlayer1Score().setText(score);
	}

	public void setScorePlayer2(String score) {
		getPlayer2Score().setText(score);
	}

	public Label getPlayer1() {
		return player1;
	}

	public void setPlayer1(Label player1) {
		this.player1 = player1;
	}

	public Label getPlayer2() {
		return player2;
	}

	public void setPlayer2(Label player2) {
		this.player2 = player2;
	}

	public Label getMenu() {
		return menu;
	}

	public void setMenu(Label menu) {
		this.menu = menu;
	}

	public Label getPlayer1Score() {
		return player1Score;
	}

	public void setPlayer1Score(Label player1Score) {
		this.player1Score = player1Score;
	}

	public Label getPlayer2Score() {
		return player2Score;
	}

	public void setPlayer2Score(Label player2Score) {
		this.player2Score = player2Score;
	}
}
