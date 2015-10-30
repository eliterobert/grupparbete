
package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
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
	ToggleGroup tg;
	RadioButton r1, r2, r3;
	HBox radioButtonBox;
	HBox boxLabel;
	TextField p1;
	TextField p2;
	String testp1;

	public StartPage() {
		BackgroundImage pic = new BackgroundImage(
				new Image("/Backgroundpictures/starwars.jpg", 1000, 1000, true, false), BackgroundRepeat.REPEAT,
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

		p1 = new TextField();
		p1.setPromptText("Player 1");
		p2 = new TextField();
		p2.setPromptText("Player 2");

		r1 = new RadioButton("8 Cards");
		r2 = new RadioButton("16 Cards");
		r3 = new RadioButton("32 Cards");

		tg = new ToggleGroup();
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r2.setSelected(true);
		r3.setToggleGroup(tg);

		r1.setTextFill(Color.AQUA);
		r2.setTextFill(Color.AQUA);
		r3.setTextFill(Color.AQUA);

		antalSpelare.setTextFill(Color.AQUA);

		startButton.setTextFill(Color.BLACK);

		radioButtonBox = new HBox();
		radioButtonBox.getChildren().addAll(r1, r2, r3);
		radioButtonBox.setAlignment(Pos.CENTER);

		boxLabel = new HBox();
		boxLabel.setAlignment(Pos.CENTER);
		boxLabel.setSpacing(20);
		boxLabel.getChildren().addAll(p1, p2);

		getChildren().addAll(topLabel, radioButtonBox, boxLabel, startButton);
	}

	public String getTestp1() {
		return testp1;
	}

	public void setTestp1(String testp1) {
		this.testp1 = testp1;
	}

}
