package character;

import javafx.scene.image.Image;

public class Bullet extends Position {
	public Image bulletImage;
	private boolean isFromPlayer = false;
	private boolean isFromRocket = false;
	private boolean isFromBoss = false;
	private boolean isOnScreen;
	private char direction;	
	
	public Bullet(double x, double y) {

	}
}
