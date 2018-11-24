package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Position {
	protected int life;
	protected int score;
	protected int speed;
	
	protected String control = "";
	
	protected double x;
	protected double y;
	
	protected boolean isAlive = true;
	protected boolean isVisible = true;

	public static Image image;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void draw(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}
	public void updatePos(GraphicsContext gc) {
		if (control.contains("a")) {
			x -= speed;
		}
		if (control.contains("d")) {
			x += speed; 	
		}
		if (control.contains("w")) {
			y -= speed;
		}
		if (control.contains("s")) {
			y += speed;
		}
		control = "";
		if(x >= 0 && x <= 800 && y >= 0 && y <= 600) {
			draw(gc);
		} else {
			isVisible = false;
		}
	}
	public boolean isShow() {
		return true;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public int getLife() {
		return life;
	}
	public int getScore() {
		return score;
	}
	public String getControl() {
		return control;
	}
	
	
}
