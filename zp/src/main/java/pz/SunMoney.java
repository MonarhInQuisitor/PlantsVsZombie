package pz;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SunMoney extends Pane{

public SunMoney(double x,double y){
	ImageView image;
	Image im =new Image(this.getClass().getResource("/images/Sun.png").toString());
		image = new ImageView(im);
		image.setFitWidth(50);
		image.setFitHeight(50);
		getChildren().add(image);

	
setTranslateX(x);
setTranslateY(y);
}

}
