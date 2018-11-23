package character;

import javafx.scene.image.Image;

public class Bullet extends Position {
	private boolean isFromPlayer = false;
	private boolean isFromRocket = false;
	private boolean isFromBoss = false;
	private boolean isOnScreen = true;
	private char direction;	
	
	public Bullet(double x, double y, String bulletname) {
		super(x, y);
		this.image = new Image(bulletname);
	}
}
