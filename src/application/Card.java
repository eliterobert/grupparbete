package application;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Card extends StackPane{
		ImageView faceView, backView;
		
		//Constructor for Card
		public Card(Image faceImg, Image backImg) {
			faceView = new ImageView(faceImg);
			backView = new ImageView(backImg);
			faceView.setRotationAxis(Rotate.Y_AXIS);
			faceView.setRotate(180);
			faceView.setOpacity(0);
			

			setAlignment(Pos.CENTER);
			setRotationAxis(Rotate.Y_AXIS);
			getChildren().addAll(faceView, backView);
			
//			setOnMouseClicked(value);
			
		}
		
		public boolean isOpen() {
			return getRotate() > 0;
			
		}
		
		public boolean isOfSameKind(Card otherCard) {
			return this.faceView.getImage().equals(otherCard.faceView.getImage());
			
		}
		
		public void open(Runnable action) {
			FadeTransition faceOpacity = new FadeTransition(Duration.millis(1), faceView);
			faceOpacity.setToValue(1);
			faceOpacity.setDelay(Duration.millis(500));
			faceOpacity.play();

			FadeTransition backOpacity = new FadeTransition(Duration.millis(1), backView);
			backOpacity.setToValue(0);
			backOpacity.setDelay(Duration.millis(500));
			backOpacity.play();

			RotateTransition rotateForward = new RotateTransition(Duration.millis(1000), this);
			rotateForward.setToAngle(180);
			rotateForward.play();

			rotateForward.setOnFinished((a) -> action.run());
		}
		
		public void close() {
			FadeTransition faceOpacity = new FadeTransition(Duration.millis(1), faceView);
			faceOpacity.setToValue(0);
			faceOpacity.setDelay(Duration.millis(1000));
			faceOpacity.play();

			FadeTransition backOpacity = new FadeTransition(Duration.millis(1), backView);
			backOpacity.setToValue(1);
			backOpacity.setDelay(Duration.millis(1000));
			backOpacity.play();

			RotateTransition rotateBackward = new RotateTransition(Duration.millis(2000), this);
			rotateBackward.setToAngle(0);
			rotateBackward.play();	
		}
}
