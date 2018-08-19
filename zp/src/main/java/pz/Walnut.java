package pz;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Walnut extends Plant {

	public Walnut(double x, double y, Pane root,Matrix matrix,ArrayList<Plant> plant) {
		super(x, y, root, matrix, plant);	
		ImageView image;
		Image im =new Image(this.getClass().getResource("/images/wallnut.png").toString());
			image = new ImageView(im);
			image.setFitWidth(40);
			image.setFitHeight(40);
			getChildren().add(image);
			newHealts(180*10);
	
		
	}
	public void run() {
		
		timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), ev -> {
			stop();
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
	}


}
