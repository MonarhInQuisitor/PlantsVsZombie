package pz;

import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Peashooter extends Plant {

	private ArrayList<Shot> shots;
	
	public Peashooter(double x, double y, Pane root,ArrayList<Shot> shots,Matrix matrix,ArrayList<Plant> plant) {
		super(x,y,root, matrix, plant);
		
		ImageView image;
		Image im =new Image(this.getClass().getResource("/images/shoter.png").toString());
			image = new ImageView(im);
			image.setFitWidth(40);
			image.setFitHeight(40);
			getChildren().add(image);
		
		this.shots = shots;
	}
	private int count = 0;
	public void run() {
		
		timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), ev -> {
			stop();
			count++;
			if(count==8) {
				count=0;
			Shot as = new Shot(shots);
			as.add(x, y);
			as.run();
			root.getChildren().add(as);
			shots.add(as);
			}
			
			
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
	}

}
