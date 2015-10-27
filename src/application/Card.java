package application;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;

public class Card extends StackPane{
		ImageView faceView, backView;
		
		//Konstruktor för Card
		public Card(Image faceImg, Image backImg) {
			faceView = new ImageView(faceImg);
			backView = new ImageView(backImg);
			faceView.setRotationAxis(Rotate.Y_AXIS);
			faceView.setRotate(180);
			faceView.setOpacity(0);
			

			setAlignment(Pos.CENTER);
			setRotationAxis(Rotate.Y_AXIS);
			getChildren().addAll(faceView, backView);
			
		}
		
		public boolean isOpen() {
			return false;
			
		}
		
		public boolean isOfSameKind() {
			return false;
			
		}
		
		public void open() {
			
		}
		
		public void close() {
			
		}
}
