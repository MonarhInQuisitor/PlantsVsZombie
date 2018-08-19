package pz;

import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;


import javafx.util.Duration;

public class FabricZombie extends Pane {
    private int zombHeals=4;
    private boolean flag= true;
    private Pane root;
    private List<Zombie> zomb;
	public FabricZombie( Pane root , List<Zombie> z) {
		this.root = root;
		zomb=z;
	}

	private int RandomC() {
return  (((int)(Math.random()*250))/50*50+25-10);
	}
	private int time=15;
	private int count=0;
	private int count1=0;
	private Timeline TimeLine(int x) {
	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(x), ev -> {
		
		Zombie z = new Zombie();
		z.IncreaseHeals(zombHeals);
		z.add(MainApp.H,RandomC() );
		z.run();
		root.getChildren().add(z);
		zomb.add(z);
		
}));
	
timeline.setCycleCount(Animation.INDEFINITE);
timeline.play();
return timeline;
}
	public void run() {
		
		if(flag) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(time), ev -> {
			
			count++;
			Zombie z = new Zombie();
			z.IncreaseHeals(zombHeals);
			z.add(MainApp.H,RandomC() );
			z.run();
			root.getChildren().add(z);
			zomb.add(z);
			
			if(count==3) {
				System.out.println("ускорение");
				zombHeals();
				count1++;
				time-=2;
				count=0;
				if(time<4) time=4;
				if(count1==2) {
					System.out.println("+ zombie");
					count=0;
					TimeLine(5);
					count1=0;
				}
			}
			
		
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		}
		flag=false;
		
	}
	private void zombHeals(){
		if (zombHeals<6) {
			zombHeals++;
		}


}
}
