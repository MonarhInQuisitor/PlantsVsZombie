package pz;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
	Music music;
	Matrix matrix = new Matrix();
	Money money;
	Text text;
	Text life;
	Text textZ;
	Plants box = Plants.Null;
	ArrayList<Shot> shots = new ArrayList<Shot>();
	ArrayList<Plant> plant = new ArrayList<Plant>();
	public List<Zombie> z = new ArrayList<Zombie>();
	final static int H = 600;
	final static int V = 400;
	final static int hcount = 5;
	final static int wcount = 9;
	int countzomb = 0;
	static Pane root;
	int countZomb = 100;

	public Parent CreatContent() {
		root = new Pane();
		root.setPrefSize(H, V);
		CreatGrid();
		CreatMagazine();
		return root;
	}

	int transformX(double x) {
		if (((int) x) / 66 > 0) {
			return (((int) x) / 66) * 66 + 10;
		} else
			return 10;

	}

	int transformY(double y) {
		if (((int) y) / 50 > 0) {
			return (((int) y) / 50) * 50 + 5;
		} else
			return 5;

	}

	void CreatMagazine() {
		FlowPane fp = new FlowPane();
		Text();
		fp.setTranslateY(260);
		for (int i = 0; i < 3; i++) {

			ImageView image;
			Image im = new Image(this.getClass().getResource("/images/phon.png").toString());
			image = new ImageView(im);
			image.setFitWidth(66);
			fp.getChildren().add(image);

		}

		root.setOnMouseClicked(event -> {
			chosemag(event.getX(), event.getY());
		});
		root.getChildren().addAll(fp);
		root.getChildren().add(new Peashooter(15, 265, root, shots, matrix, plant));
		root.getChildren().add(new sunflower(80, 265, root, matrix, money, plant));
		root.getChildren().addAll(new Walnut(145, 265, root, matrix, plant));
	}

	void chosemag(double x, double y) {
		if (x <= 66 && money.getMoney() >= 100 && y >= 260 && y <= 320) {
			if (box != Plants.Shoter) {
				CreatCursor();
				box = Plants.Shoter;
				root.getChildren().add(new Peashooter(345, 265, root, shots, matrix, plant));
			} else {
				box = Plants.Null;
				CreatCursor();
			}
		} else if (x > 66 && x <= 132 && money.getMoney() >= 50 && y >= 260 && y <= 320) {
			if (box != Plants.SunFlower) {
				CreatCursor();
				root.getChildren().add(new sunflower(345, 265, root, matrix, money, plant));
				box = Plants.SunFlower;
			} else {
				box = Plants.Null;
				CreatCursor();
			}
		} else if (x > 132 && x <= 198 && money.getMoney() >= 50 && y >= 260 && y <= 320) {
			if (box != Plants.Wallnut) {
				CreatCursor();
				root.getChildren().add(new Walnut(345, 265, root, matrix, plant));
				box = Plants.Wallnut;
			} else {
				box = Plants.Null;
				CreatCursor();
			}
		}

	}

	void CreatCursor() {
		ImageView image;

		Image im = new Image(this.getClass().getResource("/images/phon.png").toString());
		image = new ImageView(im);
		image.setFitWidth(66);
		image.setTranslateX(330);
		image.setTranslateY(260);
		root.getChildren().addAll(image);

	}

	void removeText() {
		textZ.setText("Zombie: " + countZomb);
	}

	void Text() {
		textZ = new Text();
		removeText();
		textZ.setTranslateX(440);
		textZ.setTranslateY(360);
		root.getChildren().add(textZ);
	}

	void CreatText() {
		text = new Text();
		Text text1 = new Text("Value :" + 100);
		Text text2 = new Text("Value :" + 50);
		Text text3 = new Text("Value :" + 50);
		life = new Text("Life :" + (5 - countzomb));
		text.setTranslateY(285);
		text.setTranslateX(232);
		text1.setTranslateY(320);
		text1.setTranslateX(5);
		text2.setTranslateY(320);
		text2.setTranslateX(75);
		text3.setTranslateY(320);
		text3.setTranslateX(145);
		life.setTranslateY(285);
		life.setTranslateX(420);
		money = new Money();
		text.setText(money.getText());
		ImageView image;
		Image im = new Image(this.getClass().getResource("/images/life.png").toString());
		image = new ImageView(im);
		image.setFitHeight(60);
		image.setFitWidth(60);
		image.setTranslateX(465);
		image.setTranslateY(250);
		root.getChildren().addAll(text, text1, text2, text3, image, life);

	}

	public void CreatGrid() {
		GridPane gr = new GridPane();
		for (int i = 0; i < wcount; i++) {
			for (int j = 0; j < hcount; j++) {
				ImageView image;
				Image im = new Image(this.getClass().getResource("/images/phon.png").toString());
				image = new ImageView(im);
				image.setFitWidth(66);
				image.setFitHeight(50);

				gr.add(image, i, j);

			}
		}

		gr.setOnMouseClicked(event -> {
			switch (box) {
			case Shoter: {
				if (matrix.isFree(event.getX(), event.getY()) && money.getMoney() >= 100) {
					Peashooter peashooter = new Peashooter(transformX(event.getX()), transformY(event.getY()), root,
							shots, matrix, plant);
					plant.add(peashooter);
					root.getChildren().add(peashooter);
					peashooter.run();
					matrix.add(event.getX(), event.getY());
					money.addMoney(-100);
				}
				break;

			}
			case SunFlower: {
				if (matrix.isFree(event.getX(), event.getY()) && money.getMoney() >= 50) {
					sunflower sf = new sunflower(transformX(event.getX()), transformY(event.getY()), root, matrix,
							money, plant);
					plant.add(sf);
					root.getChildren().add(sf);
					sf.run();
					matrix.add(event.getX(), event.getY());
					money.addMoney(-50);
				}
				break;
			}
			case Wallnut: {
				if (matrix.isFree(event.getX(), event.getY()) && money.getMoney() >= 50) {
					Walnut w = new Walnut(transformX(event.getX()), transformY(event.getY()), root, matrix, plant);
					plant.add(w);
					root.getChildren().add(w);
					w.run();
					matrix.add(event.getX(), event.getY());
					money.addMoney(-50);
				}
				break;
			}

			case Null: {

			}
			}

		});
		root.getChildren().add(gr);
	}

	@Override
	public void start(Stage primaryStage) {

		Scene scene = new Scene(CreatContent());
		FabricZombie fz = new FabricZombie(root, z);
		CreatText();
		matrix.CreatMatrix();
		CreatCursor();
		music = new Music();

		scene.setOnMouseClicked(event -> {
			fz.run();

		});

		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				if (countZomb == 0) {
					music.Win();
					root.getChildren().clear();
					root.getChildren().removeAll();
					Text text = new Text("WIN");
					text.setFill(Color.LIGHTGREEN);
					text.setScaleX(10);
					text.setScaleY(10);
					text.setTranslateX(300);
					text.setTranslateY(100);
					root.getChildren().add(text);
				}
				if (countzomb >= 5) {
					music.Los();
					root.getChildren().clear();
					root.getChildren().removeAll();
					Text text = new Text("LOS");
					text.setFill(Color.DARKRED);
					text.setScaleX(10);
					text.setScaleY(10);
					text.setTranslateX(300);
					text.setTranslateY(100);
					root.getChildren().add(text);
				}
				text.setText(money.getText());

				for (Zombie zomb : z) {
					for (Shot s : shots) {
						if (zomb.getBoundsInParent().intersects(s.getBoundsInParent())) {
							s.removeM();
							if (zomb.getHeals() == 1) {
								countZomb--;
								removeText();
							}
							zomb.setHeals();
						}

					}
				}

				for (Zombie zomb : z) {
					if (zomb.getTranslateX() > 0.15 && zomb.getTranslateX() < 0.35) {
						zomb.getChildren().clear();
						root.getChildren().remove(zomb);
						countzomb++;
						life.setText("Life :" + (5 - countzomb));
					}
					for (Plant p : plant) {
						if (zomb.getBoundsInParent().intersects(p.getBoundsInParent())) {
							p.setHealts();

							zomb.pause(false);
						}

					}
				}
			}
		};
		timer.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("MY Plants VS Zombie by Dmytro version 1.0");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
