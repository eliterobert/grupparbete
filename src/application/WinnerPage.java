package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class WinnerPage extends BorderPane {

	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	HBox hbox3 = new HBox();
	ImageView buttonImage = new ImageView(new Image("Backgroundpictures/playagain.png"));
	Button returnButton = new Button(null, buttonImage);
	BackgroundImage pic = new BackgroundImage(new Image("/Backgroundpictures/winner.gif", 1000, 1600, true, false),
			BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	Label winner = new Label("Winner is: ");
	Label playerName = new Label("PLAYER");
	BorderPane root = new BorderPane();

	public WinnerPage() {

		playerName.setTextFill(Color.YELLOW);
		playerName.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC, 60));
		winner.setTextFill(Color.YELLOWGREEN);
		winner.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC, 60));

		buttonImage.setFitHeight(50);
		buttonImage.setFitWidth(100);

		returnButton.setStyle("-fx-background-color: rgba(0%,0%,0%,0)}");

		setBackground(new Background(pic));

		hbox1.setAlignment(Pos.BOTTOM_LEFT);
		hbox1.getChildren().add(returnButton);

		setBottom(hbox1);
		setCenter(buttonImage);

		MotionBlur blur = new MotionBlur();

		blur.setAngle(-15);
		blur.setRadius(16);
		playerName.setEffect(blur);

		Shadow shadow = new Shadow();
		shadow.setColor(Color.YELLOW);
		shadow.setRadius(10);
		shadow.setWidth(3);
		winner.setEffect(shadow);

	}

}
