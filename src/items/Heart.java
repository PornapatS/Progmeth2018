package items;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Heart {
	private final double x;
	private final double y;
	public Image heartImage = new Image("life.png");
	
	public Heart(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void draw(GraphicsContext gc) {
		gc.drawImage(heartImage, x, y);
	}

}
