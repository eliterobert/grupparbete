package application;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * @author Ajmal Bahawodin This class represents a playing card with a face and
 *         a back.
 */
public class Card extends StackPane {

	private Main refToMain;
	private RotateTransition rotation;
	private FadeTransition fade;
	private ImageView faceView, backView;

	// Constructor for Card
	public Card(Image faceImg, Image backImg, Main mainRef) {
		refToMain = mainRef;
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
		if (isOpen() && refToMain.getClickCount() != 0)
			return;

		refToMain.setClickCount(refToMain.getClickCount() - 1);

		if (refToMain.getSelectedCard() == null) {
			refToMain.setSelectedCard(this);
			open(() -> {
			});
		} else {
			open(() -> {
				if (!this.isOfSameKind(refToMain.getSelectedCard())) {
					refToMain.getSelectedCard().close();
					this.close();
					refToMain.getPlayerList().add(refToMain.getCurrentPlayer());
					refToMain.setCurrentPlayer(refToMain.getPlayerList().poll());

					if (refToMain.getCurrentPlayer().getPlayerNr() == 1) {
						refToMain.getBoard().highligtPlayer1();
					} else {
						refToMain.getBoard().highligtPlayer2();
					}

				} else {
					refToMain.getCurrentPlayer().increaseScore();
					refToMain.setPointCount(refToMain.getPointCount() + 1);
					if (refToMain.getCurrentPlayer().getPlayerNr() == 1) {
						refToMain.getBoard().highligtPlayer1();
						refToMain.getBoard().setScorePlayer1(refToMain.getCurrentPlayer().getScore() + "");
					} else {
						refToMain.getBoard().highligtPlayer2();
						refToMain.getBoard().setScorePlayer2(refToMain.getCurrentPlayer().getScore() + "");
					}

				}
				if (refToMain.getPointCount() == refToMain.getNumOfCards()) {

					refToMain.startWinnerScene();
					refToMain.HighScoreInput();
				}
				refToMain.setSelectedCard(null);
				refToMain.setClickCount(2);
			});
		}
	}

	private boolean isOpen() {
		return getRotate() > 0;
	}

	private boolean isOfSameKind(Card otherCard) {

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

	private void open(Runnable action) {
		rotation = new RotateTransition(Duration.millis(500), this);
		rotation.setToAngle(90);
		rotation.play();
		rotation.setOnFinished((a) -> {
			moveFaceToFront(action);
		});
	}

	private void moveFaceToFront(Runnable action) {
		getChildren().clear();
		getChildren().addAll(backView, faceView);
		rotation.setToAngle(180);
		rotation.play();
		rotation.setOnFinished((a) -> {
			action.run();
		});

	}

	private void close() {
		rotation.setToAngle(90);
		rotation.play();
		rotation.setOnFinished((a) -> {
			getChildren().clear();
			getChildren().addAll(faceView, backView);
			rotation.setToAngle(0);
			rotation.play();
		});
	}

}
