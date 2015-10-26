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
	HBox hbox;

	//		Label topLabel=new Label("Memory Game");
	//		Label antalSpelare = new Label("Antal Spelare");

	public StartPage(){
		topLabel = new Label("Memory Game");
		antalSpelare= new Label("Antal Spelare");
		startButton=new Button("Start");

		hbox=new HBox(hbox);
	}






}
