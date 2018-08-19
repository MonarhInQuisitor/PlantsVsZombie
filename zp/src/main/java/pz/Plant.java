package pz;

import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.scene.layout.Pane;

public class Plant extends Pane {
	protected double x, y;
	protected Pane root;
	protected int healts = 180;
	protected Matrix matrix;
	ArrayList<Plant> plant;

	protected int getHealts() {
		return healts;
	}

	protected void newHealts(int x) {
		healts = x;
	}

	protected void setHealts() {
		healts -= 1;
	}

	protected Plant(double x, double y, Pane root, Matrix matrix,ArrayList<Plant> plant) {
		setTranslateY(y);
		setTranslateX(x);
		this.x = x;
		this.y = y;
		this.root = root;
		this.matrix = matrix;
		this.plant=plant;
	}

	protected boolean isHealts() {
		return healts > 0 ? true : false;
	}

	protected void stop() {
		if (!isHealts()) {
			timeline();
			matrix.remove(getTranslateX(), getTranslateY());
			root.getChildren().remove(this);
			plant.remove(this);
		}

	}

	protected void timeline() {
		timeline.stop();
	}

	protected Timeline timeline;

	protected void run() {

	}

}
