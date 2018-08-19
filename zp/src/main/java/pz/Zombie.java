package pz;


import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Zombie extends Pane {
	private int heals = 4;

	public int getHeals() {
		return heals;
	}

	public void setHeals() {
		heals -= 1;
	}

	public void IncreaseHeals(int x) {
		heals=x;
	}
	public boolean isAlive() {
		return getHeals() > 0 ? true : false;
	}

	private void move() {
		setTranslateX(getTranslateX() - 0.2);
	}

	void add(double x, double y) {
		ImageView image;
		Image im =new Image(this.getClass().getResource("/images/zombi.png").toString());
			image = new ImageView(im);
			image.setFitWidth(30);
			image.setFitHeight(50);
			getChildren().add(image);
			setTranslateY(y - 15);
			setTranslateX(x);
		
	}

	private boolean x = true;

	public void pause(boolean x) {
		this.x = x;
	}

	private boolean isPause() {
		return x;
	}

	public void run() {

		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				if (isAlive()) {
					if (isPause()) {
						move();
					}
					pause(true);
				} else
					setTranslateY(1000);
			}
		};
		timer.start();
	}
}
