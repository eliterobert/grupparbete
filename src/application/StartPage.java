
package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartPage extends VBox {

	Label topLabel;
	Label antalSpelare;
	Button startButton;
	ToggleGroup tg, themeGroup;
	ToggleButton cardsChoise8, cardsChoise16, cardsChoise32;
	ToggleButton theme1, theme2, theme3;
	HBox toggleButtonBox, themeGroupBox;
	HBox boxLabel;
	TextField player1, player2;
	String testp1;

	public StartPage() {
		BackgroundImage pic = new BackgroundImage(
				new Image("/Backgroundpictures/starwars.jpg", 1325, 750, false, false), BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		setBackground(new Background(pic));

		setAlignment(Pos.CENTER);
		setSpacing(50);

		topLabel = new Label("Memory Game");
		topLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
		topLabel.setTextFill(Color.RED);
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		topLabel.setEffect(r);

		antalSpelare = new Label("Antal Spelare");
		startButton = new Button("Start");
		startButton.setPrefSize(180, 80);

		player1 = new TextField();
		player1.setPromptText("Player 1");
		player2 = new TextField();
		player2.setPromptText("Player 2");

		cardsChoise8 = new ToggleButton("12 Cards");
		cardsChoise8.setPrefSize(100, 50);
		cardsChoise16 = new ToggleButton("16 Cards");
		cardsChoise16.setPrefSize(100, 50);
		cardsChoise32 = new ToggleButton("20 Cards");
		cardsChoise32.setPrefSize(100, 50);

		tg = new ToggleGroup();
		cardsChoise8.setToggleGroup(tg);
		cardsChoise16.setToggleGroup(tg);
		cardsChoise16.setSelected(true);
		cardsChoise32.setToggleGroup(tg);

		ImageView phantasyStartButton = new ImageView(new Image("Backgroundpictures/phantStartButt.png"));
		phantasyStartButton.setFitHeight(75);
		phantasyStartButton.setFitWidth(75);
		theme1 = new ToggleButton("", phantasyStartButton);
		theme1.setStyle("-fx-background-color: rgba(0%,0%,0%,0)}");
		theme1.setPrefSize(100, 50);
		theme1.setSelected(true);

		ImageView starWarsButton = new ImageView(new Image("Backgroundpictures/starwarsbutton.png"));
		starWarsButton.setFitHeight(75);
		starWarsButton.setFitWidth(75);
		theme2 = new ToggleButton("", starWarsButton);
		theme2.setStyle("-fx-background-color: rgba(0%,0%,0%,0)}");
		theme2.setPrefSize(100, 50);

		ImageView lotrButton = new ImageView(new Image("Backgroundpictures/lotrbutton.png"));
		lotrButton.setFitHeight(75);
		lotrButton.setFitWidth(75);
		theme3 = new ToggleButton("", lotrButton);
		theme3.setStyle("-fx-background-color: rgba(0%,0%,0%,0)}");
		theme2.setPrefSize(100, 50);

		themeGroup = new ToggleGroup();
		theme1.setToggleGroup(themeGroup);
		theme2.setToggleGroup(themeGroup);
		theme3.setToggleGroup(themeGroup);

		themeGroupBox = new HBox();
		themeGroupBox.setSpacing(20);
		themeGroupBox.setAlignment(Pos.CENTER);
		themeGroupBox.getChildren().addAll(theme1, theme2, theme3);

		antalSpelare.setTextFill(Color.AQUA);

		startButton.setTextFill(Color.BLACK);

		toggleButtonBox = new HBox();
		toggleButtonBox.setSpacing(20);
		toggleButtonBox.setAlignment(Pos.CENTER);
		toggleButtonBox.getChildren().addAll(cardsChoise8, cardsChoise16, cardsChoise32);

		boxLabel = new HBox();
		boxLabel.setAlignment(Pos.CENTER);
		boxLabel.setSpacing(20);
		boxLabel.getChildren().addAll(player1, player2);

		getChildren().addAll(topLabel, toggleButtonBox, themeGroupBox, boxLabel, startButton);
	}

	public String getTestp1() {
		return testp1;
	}

	public void setTestp1(String testp1) {
		this.testp1 = testp1;
	}

}
