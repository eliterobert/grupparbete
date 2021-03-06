package application;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class WinnerPage extends BorderPane {

	private TextArea textArea;
	private LinkedList<String> scores;
	private HBox hbox1, hbox2, hbox3;;
	private ImageView buttonImage;
	private Button returnButton;
	private BackgroundImage pic;

	private Label winner;
	private Label playerName;

	public WinnerPage(Main mainRef) {
		buttonImage = new ImageView(new Image("Backgroundpictures/playagain.png"));
		returnButton = new Button(null, buttonImage);

		setWinner(new Label("Winner is: "));
		setPlayerName(new Label("PLAYER"));

		pic = new BackgroundImage(new Image("/Backgroundpictures/winner.gif", 1000, 1600, true, false),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		hbox1 = new HBox();
		hbox2 = new HBox();
		hbox3 = new HBox();

		textArea = new TextArea();
		textArea.setMaxHeight(350);
		textArea.setMaxWidth(240);
		scores = mainRef.readScores();

		Collections.reverse(scores);
		for (int i = 0; i < scores.size(); i++) {
			textArea.setText(scores.get(i) + textArea.getText());

		}
		textArea.setStyle("-fx-background-color: transparent");

		hbox3.getChildren().add(textArea);
		hbox3.setAlignment(Pos.CENTER_RIGHT);
		hbox3.setPadding(new Insets(0, 30, 0, 0));

		getPlayerName().setTextFill(Color.CORAL);
		getPlayerName().setFont(Font.font("Segoe Script", FontWeight.NORMAL, FontPosture.ITALIC, 60));
		getWinner().setTextFill(Color.CORAL);
		getWinner().setFont(Font.font("Segoe Script", FontWeight.NORMAL, FontPosture.ITALIC, 60));

		buttonImage.setFitHeight(50);
		buttonImage.setFitWidth(100);

		returnButton.setStyle("-fx-background-color: rgba(0%,0%,0%,0)}");
		returnButton.setOnAction(action -> {
			mainRef.getMediaPlayer().stop();
			mainRef.setMusicFile("Sound/testSound3.mp3");
			mainRef.getMediaPlayer().setCycleCount(10);
			mainRef.setMusicToPlay(new Media(new File(mainRef.getMusicFile()).toURI().toString()));
			mainRef.setMediaPlayer(new MediaPlayer(mainRef.getMusicToPlay()));
			mainRef.getMediaPlayer().setVolume(0.1);
			mainRef.getMediaPlayer().play();
			mainRef.setBounds();
			mainRef.getMainStage().setScene(mainRef.getStartScene());
			mainRef.setPointCount(0);
		});

		setBackground(new Background(pic));

		hbox1.setAlignment(Pos.BOTTOM_LEFT);
		hbox1.getChildren().add(returnButton);
		hbox2.getChildren().addAll(getWinner(), getPlayerName());

		setTop(hbox2);
		setBottom(hbox1);
		setCenter(hbox3);

	}

	public Label getPlayerName() {
		return playerName;
	}

	public void setPlayerName(Label playerName) {
		this.playerName = playerName;
	}

	public Label getWinner() {
		return winner;
	}

	public void setWinner(Label winner) {
		this.winner = winner;
	}

}
