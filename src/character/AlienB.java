package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienB extends Alien {
	
	public AlienB(Player player) {
		super(player);
		Alien.setSpeed(2);
		this.score = 10;
		this.alienPic = new Image("alienB.png");

	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.alienPic, x, y);
	}
	
	@Override
	public boolean isDestroyed(double x,double y) {
		if ((this.x < x+38 && x-38 < this.x) && (this.y < y+31 && y-31 < this.y)) {
			setShow(false);
			return true;
		}
		return false;
	}
}
