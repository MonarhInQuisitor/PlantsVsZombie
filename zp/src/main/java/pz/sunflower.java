package pz;


import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class sunflower extends Plant {

	private SunMoney sm;
	private Money money;
	

	public sunflower(double x, double y, Pane root,Matrix matrix,Money money,ArrayList<Plant> plant) {
		super(x, y,root, matrix, plant);
		addImage();
		this.money=money;
	}
	private void addImage(){
		ImageView image;
		Image im =new Image(this.getClass().getResource("/images/sunflower.png").toString());
			image = new ImageView(im);
			image.setFitWidth(40);
			image.setFitHeight(40);
			getChildren().add(image);

		
	}
	
	private int count = 0;
	private boolean exist = false;

	public void run() {
		
		timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), ev -> {
			stop();
			count++;
			if (exist==false) {
			if(count==20) {
				count=0;
				sm = new SunMoney(x,y);
				exist=!exist; 
				sm.setOnMouseClicked(event->{
					root.getChildren().remove(sm);
					money.addMoney(25);
					exist=!exist; 
				});
				root.getChildren().add(sm);
			}
			}else count=0;
			
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
	}

}
