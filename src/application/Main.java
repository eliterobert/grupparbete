package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	private ArrayList<Image> imageList;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
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
