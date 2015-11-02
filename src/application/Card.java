package application;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Ajmal Bahawodin This class represents a playing card with a face and
 *         a back.
 */
public class Card extends StackPane {

	RotateTransition rotation;
	FadeTransition fade;
	ImageView faceView, backView;

	// Constructor for Card
	public Card(Image faceImg, Image backImg) {
		faceView = new ImageView(faceImg);
		backView = new ImageView(backImg);
		faceView.setRotationAxis(Rotate.Y_AXIS);
		faceView.setRotate(180);

		setOpacity(0);
		fade = new FadeTransition(Duration.millis(2000), this);
		fade.setToValue(1);
		fade.play();

		setAlignment(Pos.CENTER);
		setRotationAxis(Rotate.Y_AXIS);
		getChildren().addAll(faceView, backView);

		setOnMouseClicked(this::handleMouseClick);

	}

	private void handleMouseClick(MouseEvent event) {
		if (isOpen())
			return;

		if (Main.selectedCard == null) {
			Main.selectedCard = this;
			open(() -> {
			});
		} else {
			open(() -> {
				if (!this.isOfSameKind(Main.selectedCard)) {
					highLigtPlayer1(Main.phantasyStarBoard);
					Main.selectedCard.close();
					this.close();
					Main.playerList.add(Main.currentPlayer);
					Main.currentPlayer = Main.playerList.poll();
				} else {
					Main.currentPlayer.increaseScore();
					highLigtPlayer2(Main.phantasyStarBoard);

				}
				Main.selectedCard = null;
			});
		}
	}

	private <Scene> void highLigtPlayer1(Scene scene) {
		if (scene.equals(Main.phantasyStarBoard)) {
			if (Main.currentPlayer.getPlayerNr() == 1) {
				Main.phantasyStarBoard.player2.setFont(Font.font("Verdant", FontWeight.BOLD, 20));
				Main.phantasyStarBoard.player1.setFont((Font.font("Verdant", FontWeight.NORMAL, 15)));
				Main.phantasyStarBoard.player1Score.setText(Main.currentPlayer.getScore() + "");
			} else {
				Main.phantasyStarBoard.player2.setFont(Font.font("Verdant", FontWeight.NORMAL, 15));
				Main.phantasyStarBoard.player1.setFont((Font.font("Verdant", FontWeight.BOLD, 20)));
				Main.phantasyStarBoard.player2Score.setText(Main.currentPlayer.getScore() + "");
			}
		}
	}

	private <Scene> void highLigtPlayer2(Scene scene) {
		if (scene.equals(Main.phantasyStarBoard)) {
			if (Main.currentPlayer.getPlayerNr() == 1) {
				Main.phantasyStarBoard.player2.setFont(Font.font("Verdant", FontWeight.NORMAL, 15));
				Main.phantasyStarBoard.player1.setFont((Font.font("Verdant", FontWeight.BOLD, 20)));
				Main.phantasyStarBoard.player1Score.setText(Main.currentPlayer.getScore() + "");
			} else {
				Main.phantasyStarBoard.player2.setFont(Font.font("Verdant", FontWeight.BOLD, 20));
				Main.phantasyStarBoard.player1.setFont((Font.font("Verdant", FontWeight.NORMAL, 15)));
				Main.phantasyStarBoard.player2Score.setText(Main.currentPlayer.getScore() + "");
			}
		}
	}

	public boolean isOpen() {
		return getRotate() > 0;
	}

	public boolean isOfSameKind(Card otherCard) {
		// return
		// this.faceView.getImage().equals(otherCard.faceView.getImage());

		PixelReader faceImg = faceView.getImage().getPixelReader();
		PixelReader otherFaceImg = otherCard.faceView.getImage().getPixelReader();
		int levelOfAcceptance = 90;
		boolean isOfSameKind = false;

		long machingPixels = 0;
		long totalPixels = (long) ((faceView.getImage().getWidth()) * (faceView.getImage().getHeight()));

		try {
			for (int i = 0; i < faceView.getImage().getHeight(); i++) {
				for (int j = 0; j < faceView.getImage().getWidth(); j++) {
					if (faceImg.getArgb(i, j) == otherFaceImg.getArgb(i, j))
						machingPixels++;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("NullPointerEx Occurred!!");
		}

		// Undvik division med noll samt kolla så acceptans nivån är över 90
		// %
		if (((totalPixels == 0 ? -1 : machingPixels / totalPixels) * 100) > levelOfAcceptance)
			isOfSameKind = true;
		return isOfSameKind;
	}

	public void open(Runnable action) {
		rotation = new RotateTransition(Duration.millis(500), this);
		rotation.setToAngle(90);
		rotation.play();
		rotation.setOnFinished((a) -> {
			moveFaceToFront(action);
		});
	}

	public void moveFaceToFront(Runnable action) {
		getChildren().clear();
		getChildren().addAll(backView, faceView);
		rotation.setToAngle(180);
		rotation.play();
		rotation.setOnFinished((a) -> {
			action.run();
		});

	}

	public void close() {
		rotation.setToAngle(90);
		rotation.play();
		rotation.setOnFinished((a) -> {
			getChildren().clear();
			getChildren().addAll(faceView, backView);
			rotation.setToAngle(0);
			rotation.play();
		});
	}

	public void playerBold(Player player) {

		if (Main.currentPlayer.getPlayerNr() == 0) {
			Main.phantasyStarBoard.player1.setFont(Font.font("Verdant", FontWeight.BOLD, 20));
			Main.phantasyStarBoard.player2.setFont((Font.font("Verdant", FontWeight.NORMAL, 20)));
		} else if (Main.currentPlayer.getPlayerNr() == 1) {
			Main.phantasyStarBoard.player1.setFont(Font.font("Verdant", FontWeight.NORMAL, 20));
			Main.phantasyStarBoard.player2.setFont((Font.font("Verdant", FontWeight.BOLD, 20)));
		}

	}

}
