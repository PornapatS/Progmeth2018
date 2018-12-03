package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienA extends Alien {

	public AlienA(Player player) {
		super(player);
		Alien.setSpeed(2);
		this.score = 5;
		this.alienPic = new Image("alienA.png");
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.alienPic, x, y);
	}
	
	@Override
	public boolean isDestroyed(double x,double y) {
		if ((this.x < x+35 && x-35 < this.x) && (this.y < y+23 && y-23 < this.y)) {
			setShow(false);
			return true;
		}
		return false;
	}
	
}
