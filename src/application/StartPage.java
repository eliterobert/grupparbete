
package application;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Bloom;
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
import javafx.stage.Screen;

public class StartPage extends VBox {

	private Label topLabel;
	private Label startGameLabel;
	private Label antalSpelare;
	private Button startButton;
	private ToggleGroup tg, themeGroup;
	private ToggleButton cardsChoise12, cardsChoise16, cardsChoise32;
	private ToggleButton theme1, theme2, theme3;
	private HBox toggleButtonBox, themeGroupBox;
	private HBox boxLabel;
	private TextField player1, player2;
	private String testp1;
	private ImageView phantasyStartButton, starWarsButton, lotrButton, twelveButton, sixteenButton, twentyButton;

	private Screen screen;
	private Rectangle2D bounds;

	public StartPage() {
		screen = Screen.getPrimary();
		bounds = screen.getVisualBounds();
		BackgroundImage pic = new BackgroundImage(
				new Image("/Backgroundpictures/startPageBackground.png", bounds.getWidth() * 0.7,
						bounds.getHeight() * 0.7, false, false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		setBackground(new Background(pic));

		setAlignment(Pos.CENTER);
		setSpacing(50);

		topLabel = new Label("Memory Game");
		topLabel.setFont(Font.font("Segoe Script", 55));

		antalSpelare = new Label("Antal Spelare");
		startGameLabel = new Label("Start Game");
		startGameLabel.setFont(Font.font("Segoe Script", 20));
		startGameLabel.setTextFill(Color.YELLOW);
		setStartButton(new Button("", startGameLabel));
		getStartButton().setStyle("-fx-background-color: rgba(7%,5%,5%,1)}");
		getStartButton().setPrefSize(140, 60);
		getStartButton().setOnMouseEntered((event) -> {
			Bloom bloom = new Bloom();
			bloom.setThreshold(0.2);
			getStartButton().setEffect(bloom);
		});
		getStartButton().setOnMouseExited((event) -> {
			getStartButton().setEffect(null);
		});

		setPlayer1(new TextField());
		getPlayer1().setPromptText("Player 1");
		getPlayer1().setStyle("-fx-background-color: rgba(7%,5%,5%,1); -fx-text-fill: white;");
		setPlayer2(new TextField());
		getPlayer2().setPromptText("Player 2");
		getPlayer2().setStyle("-fx-background-color: rgba(7%,5%,5%,1); -fx-text-fill: white;");

		twelveButton = new ImageView(new Image("Backgroundpictures/12.jpg"));
		twelveButton.setFitHeight(50);
		twelveButton.setFitWidth(100);
		setCardsChoise12(new ToggleButton("", twelveButton));
		getCardsChoise12().setPrefSize(100, 50);
		sixteenButton = new ImageView(new Image("Backgroundpictures/16.jpg"));
		sixteenButton.setFitHeight(50);
		sixteenButton.setFitWidth(100);
		setCardsChoise16(new ToggleButton("", sixteenButton));
		getCardsChoise16().setPrefSize(100, 50);
		twentyButton = new ImageView(new Image("Backgroundpictures/20.jpg"));
		twentyButton.setFitHeight(50);
		twentyButton.setFitWidth(100);
		setCardsChoise32(new ToggleButton("", twentyButton));
		getCardsChoise32().setPrefSize(100, 50);

		tg = new ToggleGroup();
		getCardsChoise12().setToggleGroup(tg);
		getCardsChoise16().setToggleGroup(tg);
		getCardsChoise16().setSelected(true);
		getCardsChoise32().setToggleGroup(tg);

		setPhantasyStartButton(new ImageView(new Image("Backgroundpictures/phantStartButt.png")));
		getPhantasyStartButton().setFitHeight(75);
		getPhantasyStartButton().setFitWidth(150);
		setTheme1(new ToggleButton("", getPhantasyStartButton()));
		getTheme1().setStyle("-fx-background-color: rgba(0%,0%,0%,0)}");
		getTheme1().setPrefSize(100, 50);

		setStarWarsButton(new ImageView(new Image("Backgroundpictures/starwarsbutton.png")));
		getStarWarsButton().setFitHeight(75);
		getStarWarsButton().setFitWidth(150);
		setTheme2(new ToggleButton("", getStarWarsButton()));
		getTheme2().setStyle("-fx-background-color: rgba(0%,0%,0%,0)}");
		getTheme2().setPrefSize(100, 50);

		setLotrButton(new ImageView(new Image("Backgroundpictures/lotrbutton.png")));
		getLotrButton().setFitHeight(75);
		getLotrButton().setFitWidth(150);
		setTheme3(new ToggleButton("", getLotrButton()));
		getTheme3().setStyle("-fx-background-color: rgba(0%,0%,0%,0)}");
		getTheme3().setPrefSize(100, 50);

		themeGroup = new ToggleGroup();
		getTheme1().setToggleGroup(themeGroup);
		getTheme2().setToggleGroup(themeGroup);
		getTheme3().setToggleGroup(themeGroup);

		themeGroupBox = new HBox();
		themeGroupBox.setSpacing(20);
		themeGroupBox.setAlignment(Pos.CENTER);
		themeGroupBox.getChildren().addAll(getTheme1(), getTheme2(), getTheme3());

		antalSpelare.setTextFill(Color.AQUA);

		toggleButtonBox = new HBox();
		toggleButtonBox.setSpacing(20);
		toggleButtonBox.setAlignment(Pos.CENTER);
		toggleButtonBox.getChildren().addAll(getCardsChoise12(), getCardsChoise16(), getCardsChoise32());

		boxLabel = new HBox();
		boxLabel.setAlignment(Pos.CENTER);
		boxLabel.setSpacing(20);
		boxLabel.getChildren().addAll(getPlayer1(), getPlayer2());

		getChildren().addAll(topLabel, toggleButtonBox, themeGroupBox, boxLabel, getStartButton());
	}

	public String getTestp1() {
		return testp1;
	}

	public void setTestp1(String testp1) {
		this.testp1 = testp1;
	}

	public ToggleButton getTheme1() {
		return theme1;
	}

	public void setTheme1(ToggleButton theme1) {
		this.theme1 = theme1;
	}

	public ImageView getPhantasyStartButton() {
		return phantasyStartButton;
	}

	public void setPhantasyStartButton(ImageView phantasyStartButton) {
		this.phantasyStartButton = phantasyStartButton;
	}

	public ImageView getStarWarsButton() {
		return starWarsButton;
	}

	public void setStarWarsButton(ImageView starWarsButton) {
		this.starWarsButton = starWarsButton;
	}

	public ImageView getLotrButton() {
		return lotrButton;
	}

	public void setLotrButton(ImageView lotrButton) {
		this.lotrButton = lotrButton;
	}

	public ToggleButton getTheme2() {
		return theme2;
	}

	public void setTheme2(ToggleButton theme2) {
		this.theme2 = theme2;
	}

	public ToggleButton getTheme3() {
		return theme3;
	}

	public void setTheme3(ToggleButton theme3) {
		this.theme3 = theme3;
	}

	public Button getStartButton() {
		return startButton;
	}

	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}

	public TextField getPlayer1() {
		return player1;
	}

	public void setPlayer1(TextField player1) {
		this.player1 = player1;
	}

	public TextField getPlayer2() {
		return player2;
	}

	public void setPlayer2(TextField player2) {
		this.player2 = player2;
	}

	public ToggleButton getCardsChoise12() {
		return cardsChoise12;
	}

	public void setCardsChoise12(ToggleButton cardsChoise12) {
		this.cardsChoise12 = cardsChoise12;
	}

	public ToggleButton getCardsChoise16() {
		return cardsChoise16;
	}

	public void setCardsChoise16(ToggleButton cardsChoise16) {
		this.cardsChoise16 = cardsChoise16;
	}

	public ToggleButton getCardsChoise32() {
		return cardsChoise32;
	}

	public void setCardsChoise32(ToggleButton cardsChoise32) {
		this.cardsChoise32 = cardsChoise32;
	}

}
