package application;

import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Card extends StackPane{

	RotateTransition rotation;
	ImageView faceView, backView;

	//Constructor for Card
	public Card(Image faceImg, Image backImg) {
		faceView = new ImageView(faceImg);
		backView = new ImageView(backImg);
		faceView.setRotationAxis(Rotate.Y_AXIS);
		faceView.setRotate(180);

		setAlignment(Pos.CENTER);
		setRotationAxis(Rotate.Y_AXIS);
		getChildren().addAll(faceView, backView);

		setOnMouseClicked(this::handleMouseClick);

	}
	
	private void handleMouseClick(MouseEvent event) {
		if (isOpen()) 
			return; 
		
		if(Main.selectedCard == null) {
			Main.selectedCard = this;
			open(() -> {});
		}
		else { open(() -> {
			if(!isOfSameKind(Main.selectedCard)) {
				Main.selectedCard.close();
				this.close();
			}
			Main.selectedCard = null;
		});
		}
	}

	public boolean isOpen() {
		return getRotate() > 0;
	}

	public boolean isOfSameKind(Card otherCard) {
		return this.faceView.getImage().equals(otherCard.faceView.getImage());
	}

	public void open(Runnable action){
		rotation = new RotateTransition(Duration.millis(1000), this);
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
		rotation.setOnFinished((a) -> { action.run(); });
		
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
}
