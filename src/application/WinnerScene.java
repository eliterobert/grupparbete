package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class WinnerScene extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("FX");
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setPrefSize(100, 1000);
		Scene scene = new Scene(root, 1000, 450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setMaxHeight(450);
		primaryStage.setMinHeight(450);
		primaryStage.setMaxWidth(1000);
		primaryStage.setMinWidth(1000);
		primaryStage.setScene(scene);
		primaryStage.show();

		Label winner = new Label("Winner is: ");
		Label playerName = new Label("PLAYER");
		playerName.setTextFill(Color.YELLOW);
		playerName.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC, 80));
		winner.setTextFill(Color.YELLOWGREEN);
		winner.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC, 80));

//		Image view = new Image("Image/winner.gif");
//		ImageView buttonImage = new ImageView("Image/Namnlös.png");
//		buttonImage.setFitHeight(20);
//		buttonImage.setFitWidth(20);
//		Button returnButton = new Button(null, buttonImage);

		BackgroundImage pic = new BackgroundImage(new Image("/Backgroundpictures/winner.gif", 1000, 1600, true, false),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		
		Image image = new Image("/Backgroundpictures/Disco.gif", 90, 90, false, false);
		
		ImageView im = new ImageView(image);
		
		

		root.setBackground(new Background(pic));
		root.add(winner, 0, 1);
		root.add(playerName, 1, 2);
		root.add(im, 1, 0);

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

	public static void main(String[] args) {
		launch(args);
	}
}
