package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StartPage extends VBox {

	Label topLabel;
	Label antalSpelare;
	Button startButton;
	ToggleGroup tg;
	RadioButton r1, r2, r3;
	Spinner spin;
	HBox radioButtonBox;
	HBox boxLabel;

	// Label topLabel=new Label("Memory Game");
	// Label antalSpelare = new Label("Antal Spelare");

	public StartPage() {
		topLabel = new Label("Memory Game");
		antalSpelare = new Label("Antal Spelare");
		startButton = new Button("Start");
		spin=new Spinner(1, 2, 1, 1);
		
		r1 = new RadioButton("8 Cards");
		r2 = new RadioButton("16 Cards");
		r3 = new RadioButton("32 Cards");
		tg = new ToggleGroup();
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r2.setSelected(true);
		r3.setToggleGroup(tg);

		radioButtonBox = new HBox();
		radioButtonBox.getChildren().addAll(r1,r2,r3);
		
		boxLabel=new HBox();
		boxLabel.getChildren().addAll(antalSpelare,spin);
	
        getChildren().addAll(topLabel,radioButtonBox,boxLabel,startButton);
	}

}
