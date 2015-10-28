package application;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	private StartPage startPage;
	private Board board;
	private ArrayList<Image> imageList;
	private Scene startScene, gameScene, boardScene;
	private Card selectedCard = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		startPage = new StartPage();
		//startScene = new Scene(startPage, 800, 800);
		boardScene = new Scene(board, 470, 766);

		startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(boardScene);
		primaryStage.show();

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
