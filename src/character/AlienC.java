package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienC extends Alien {

	public AlienC(Player player) {
		super(player);
		Alien.setSpeed(4);
		this.score = 20;
		this.alienPic = new Image("alienC.png");

	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.alienPic, x, y);
	}
	
	@Override
	public boolean isDestroyed(double x,double y) {
		if ((this.x < x+43 && x-43 < this.x) && (this.y < y+29 && y-29 < this.y)) {
			setShow(false);
			return true;
		}
		return false;
	}
}
