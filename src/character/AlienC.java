package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienC extends Alien {
	
	public int score = 20;
	public Image alienCPic = new Image("alienC.png");

	public AlienC(Player player) {
		super(player);
		Alien.setSpeed(4);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(alienCPic,x,y);
	}
	
	@Override
	public boolean isDestroyed(double x,double y) {
		if ((this.x < x+43 && x-43 < this.x) && (this.y < y+29 && y-29 < this.y)) {
			setShow(false);
			return true;
		}
		return false;
	}

	public int getScore() {
		return score;
	}

}
