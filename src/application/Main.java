package application;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	private StartPage startPage;
	private Board board;
	private Scene startScene, gameScene, boardScene;
	public static Card selectedCard = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		startPage = new StartPage();
		board = new Board();
		startScene = new Scene(startPage, 1920*0.7, 1080*0.7);
		boardScene = new Scene(board, 1920*0.7, 1080*0.7);
		
		startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		boardScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setMinHeight(1080*0.73);
		primaryStage.setMaxHeight(1080*0.73);
		primaryStage.setMinWidth(1920*0.7);
		primaryStage.setMaxWidth(1920*0.7);
		primaryStage.setScene(boardScene);
		

		primaryStage.setScene(startScene);
		primaryStage.show();
		
		startPage.startButton.setOnAction((a) -> primaryStage.setScene(boardScene));

	}
}
