package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienA extends Alien {
	
	public int score = 5;
	public Image alienAPic = new Image("alienA.png");

	public AlienA(Player player) {
		super(player);
		Alien.setSpeed(1);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(alienAPic,x,y);
	}
	
	@Override
	public boolean isDestroyed(double x,double y) {
		if ((this.x < x+35 && x-35 < this.x) && (this.y < y+23 && y-23 < this.y)) {
			setShow(false);
			return true;
		}
		return false;
	}
	
	public int getScore() {
		return score;
	}

}
