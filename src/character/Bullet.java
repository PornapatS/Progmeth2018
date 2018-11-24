package character;

import javafx.scene.image.Image;

public class Bullet extends Position {
	private Position owner;
	
	public Bullet(double x, double y, String bulletname) {
		super(x, y);
		this.image = new Image(bulletname);
	}
}
