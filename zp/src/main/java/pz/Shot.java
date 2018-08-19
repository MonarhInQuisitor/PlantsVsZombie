package pz;

import java.util.ArrayList;


import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Shot extends Pane {
	ArrayList<Shot> shots;
	AnimationTimer timer;
public Shot(ArrayList<Shot> shots) {
	this.shots=shots;
}
	private boolean isAlive() {
	return getTranslateX()<=MainApp.H-1?true:false;
	
}
//	void rem() {
//		timer.stop();
//	}
	Pane getPane() {
		return this;
	}
	public void removeM() {
		setTranslateY(1000);
	}
	public void remove() {
//		return this;
		shots.remove(getPane());
		MainApp.root.getChildren().remove(getPane());
}
	private void move(){

	setTranslateX(getTranslateX()+4);
}
public void add(double x, double y){
	getChildren().add(new Circle(5,Color.GREEN));
	setTranslateY(y+8);
	setTranslateX(x+30);
}
public void run() {

		 timer = new AnimationTimer() {

	@Override
	public void handle(long now) {
		if(isAlive())
		move();
		else  {
			remove();
		};
   
	}
			
		};
		timer.start();

		
	
}
}
