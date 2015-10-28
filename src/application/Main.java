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
	private ArrayList<Image> imageList;
	private Scene startScene, gameScene, boardScene;
	public static Card selectedCard = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		startPage = new StartPage();
		board = new Board();
		startScene = new Scene(startPage, 470, 766);
		boardScene = new Scene(board, 470, 766);
		
		startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		boardScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setMinHeight(766);
		primaryStage.setMaxHeight(766);
		primaryStage.setMinWidth(470);
		primaryStage.setMaxWidth(470);
		primaryStage.setScene(boardScene);
		

		primaryStage.setScene(startScene);
		primaryStage.show();
		
		startPage.startButton.setOnAction((a) -> primaryStage.setScene(boardScene));

	}

	private void getPictures() {
		imageList = new ArrayList<>();

		File imageDirectory = new File("src/Pictures");
		String[] directoryList = imageDirectory.list();

		for (int i = 0; i < directoryList.length; i++) {
			imageList.add(new Image("Pictures/" + directoryList[i]));
		}
	}
}
