package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

public class Board extends VBox {

	HBox hBox1, hBox2;
	VBox vBox1, vBox2;
	Label player1, player2, turn, player1Score, player2Score, menu;
	GridPane gridpane;
	Image backImage;
	public ArrayList<Image> imageList;
	Button button1;

	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();

	public Board(String cardsPath, String cardsPath2, String imgBgPath, String bgPath, int numOfPics, int col, int row){
		hBox1 = new HBox();
		hBox2 = new HBox();
		vBox1 = new VBox();
		vBox2 = new VBox();

		player1 = new Label("Player 1");
		player2 = new Label("Player 2");
		turn = new Label("Turn: 15");
		player1Score = new Label("0");
		player2Score = new Label("0");
		menu = new Label("Menu");
		
		button1 = new Button("Done");

		gridpane = new GridPane();

		BackgroundImage backgroundImage = new BackgroundImage(new Image(bgPath, bounds.getWidth()*0.7, bounds.getHeight()*0.7,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		backImage = new Image(imgBgPath, bounds.getWidth()*0.06, bounds.getWidth()*0.06, true, true);

		setSpacing(5);

		setBackground(new Background(backgroundImage));

		player1.setTextFill(Color.AQUA);
		player2.setTextFill(Color.AQUA);
		turn.setTextFill(Color.AQUA);
		menu.setTextFill(Color.AQUA);
		player1Score.setTextFill(Color.AQUA);
		player2Score.setTextFill(Color.AQUA);

		gridpane.setHgap(bounds.getWidth()*0.02);
		gridpane.setVgap(bounds.getHeight()*0.03);

		vBox1.getChildren().addAll(player1, player1Score);
		vBox2.getChildren().addAll(player2, player2Score);
		hBox1.getChildren().addAll(vBox1, gridpane, vBox2);
		hBox2.getChildren().addAll(menu,button1);

		hBox1.setTranslateY(bounds.getHeight()*0.065);
		hBox1.setAlignment(Pos.BASELINE_CENTER);
		hBox1.setSpacing(bounds.getWidth()*0.11);
		hBox2.setTranslateX(bounds.getWidth()*0.7/2);
		hBox2.setTranslateY(bounds.getHeight()*0.10);

		menu.setOnMouseEntered((event)->{
			Bloom bloom = new Bloom();
			bloom.setThreshold(0.2);
			menu.setEffect(bloom);
		});
		menu.setOnMouseExited((event)->{
			menu.setEffect(null);
		});

		highligtPlayer1();

		getChildren().addAll(hBox1, hBox2);
		getPictures(cardsPath, cardsPath2, numOfPics, col, row);
		Collections.shuffle(imageList);
	}
	
	private void getPictures(String cardsPath, String cardsPath2, int numOfPics, int col, int row) {
		imageList = new ArrayList<>();

		File imageDirectory = new File(cardsPath);
		String[] directoryList = imageDirectory.list();

			for (int i = 0; i < numOfPics; i++) {
				imageList.add(new Image(cardsPath2 + directoryList[i], bounds.getWidth() * 0.06,
						bounds.getWidth() * 0.06, true, true));
				imageList.add(new Image(cardsPath2 + directoryList[i], bounds.getWidth() * 0.06,
						bounds.getWidth() * 0.06, true, true));
			}
			Collections.shuffle(imageList);
			int cnt = 0;
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					gridpane.add(new Card(imageList.get(cnt), backImage), i, j);
					cnt++;
				}
			}
	}

	public void highligtPlayer1() {
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.3);
		player1.setFont(Font.font("Verdant", FontWeight.BOLD, 20));
		player2.setFont(Font.font("Verdant", FontWeight.NORMAL, 20));
		player1.setEffect(bloom);
		player2.setEffect(null);
	}

	public void highligtPlayer2() {
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.3);
		player1.setFont(Font.font("Verdant", FontWeight.NORMAL, 20));
		player2.setFont(Font.font("Verdant", FontWeight.BOLD, 20));
		player1.setEffect(null);
		player2.setEffect(bloom);

	}

	public void setScorePlayer1(String score) {
		player1Score.setText(score);
	}

	public void setScorePlayer2(String score) {
		player2Score.setText(score);		
	}
}
