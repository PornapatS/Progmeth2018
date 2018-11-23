package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Position {
	protected int life;
	protected int score;
	protected int speed;
//	protected final int sizew;
//	protected final int sizeh;
	
	protected String control = "";
	
	protected double x;
	protected double y;
	
	protected boolean isAlive = true;

	public static Image image;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void draw(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}
	public void updatePos() {
		// TODO Auto-generated method stub
		
	}
	public boolean isShow() {
		return true;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public int getLife() {
		return life;
	}
	public int getScore() {
		return score;
	}
	
}
