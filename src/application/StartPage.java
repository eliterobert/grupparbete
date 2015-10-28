package application;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
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
	Spinner<Integer> spin;
	HBox radioButtonBox;
	HBox boxLabel;

	// Label topLabel=new Label("Memory Game");
	// Label antalSpelare = new Label("Antal Spelare");

	public StartPage() {
		setAlignment(Pos.CENTER);
		setSpacing(200);

		topLabel = new Label("Memory Game");
		topLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 80));
		topLabel.setTextFill(Color.RED);
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		topLabel.setEffect(r);

		antalSpelare = new Label("Antal Spelare");
		startButton = new Button("Start");
		spin = new Spinner<>(1, 2, 1, 1);

		r1 = new RadioButton("8 Cards");
		r2 = new RadioButton("16 Cards");
		r3 = new RadioButton("32 Cards");
		tg = new ToggleGroup();
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r2.setSelected(true);
		r3.setToggleGroup(tg);

		radioButtonBox = new HBox();
		radioButtonBox.getChildren().addAll(r1, r2, r3);
		radioButtonBox.setAlignment(Pos.CENTER);
		boxLabel = new HBox();
		boxLabel.setAlignment(Pos.CENTER);
		boxLabel.getChildren().addAll(antalSpelare, spin);

		getChildren().addAll(topLabel, radioButtonBox, boxLabel, startButton);

//		BackgroundImage pic = new BackgroundImage(
//				new Image("/Backgroundpictures/starwars.jpg", 1000, 1000, true, false), BackgroundRepeat.REPEAT,
//				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//
//		this.setBackground(new Background(pic));
	}

}
