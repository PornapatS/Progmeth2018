package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet extends Position {
	private boolean isFromBoss = false;
	private char direction;
	
	public Bullet(double x, double y, char direction) {
		super(x, y);
		this.direction = direction;
	}
	public void setBullet() {
		if(isFromBoss) {
			this.image = new Image("bulletboss.png");
		} else {
			this.image = new Image("bulletplayer.png");
		}
	}
	@Override
	public void updatePos(GraphicsContext gc) {
		if (direction=='a') x-=10;
		if (direction=='d') x+=10;
		if (direction=='w') y-=10;
		if (direction=='s') y+=10;
		if (direction=='r') {
			x+=10;
			y+=10;
		}
		if (direction=='t') {
			x+=10;
			y-=10;
		}
		if (direction=='y') {
			x-=10;
			y-=10;
		}
		if (direction=='u') {
			x-=10;
			y+=10;
		}	
		if(x >= 0 && x <= 800 && y >= 0 && y <= 600) {
			draw(gc);
		} else {
			isVisible = false;
		}
	}
	public boolean isFromBoss() {
		return isFromBoss;
	}
	public void setFromBoss(boolean isFromBoss) {
		this.isFromBoss = isFromBoss;
	}

}
