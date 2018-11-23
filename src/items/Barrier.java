package items;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Barrier {
	private final double x;
	private final double y;
	public Image barrierImage = new Image("life.png");
	
	public Barrier(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void draw(GraphicsContext gc) {
		gc.drawImage(barrierImage, x, y);
	}
}
