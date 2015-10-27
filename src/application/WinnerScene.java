package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class WinnerScene extends Application {

	@Override
	public void start(Stage primaryStage) {
		FlowPane root = new FlowPane(10,10);
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("");
		
		VBox vBox= new VBox();
		Label winLabel = new Label("WINNER IS");
		Label plLabel= new Label("PLAYER 1 - ");
		Label scoreLabel= new Label("Score: 10");
		
		HBox hBox= new HBox();
		hBox.getChildren().addAll(plLabel,scoreLabel);
		vBox.getChildren().addAll(winLabel,hBox);
		root.getChildren().add(vBox);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: Yellow");
		
//		winLabel.setFont();
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		winLabel.setEffect(ds);
		winLabel.setCache(true);
		winLabel.setTextFill(Color.ROYALBLUE);
		winLabel.setFont(Font.font(null, FontWeight.BOLD, 32));
		
		

	}

	public static void main(String[] args) {
		launch(args);
	}
}
