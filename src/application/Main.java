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
	@Override
	public void start(Stage primaryStage) {
		
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		
			
	}
	
	public void picsFromFile()
	{
		File f = new File("Pictures\\");
		ArrayList<File> imageList = new ArrayList<>(Arrays.asList(f.listFiles()));
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
