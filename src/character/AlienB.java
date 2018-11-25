package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienB extends Alien {
	
	public int score = 10;
	public Image alienBPic = new Image("alienB.png");

	public AlienB(Player player) {
		super(player);
		Alien.setSpeed(2);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(alienBPic,x,y);
	}
	
	@Override
	public boolean isDestroyed(double x,double y) {
		if ((this.x < x+38 && x-38 < this.x) && (this.y < y+31 && y-31 < this.y)) {
			setShow(false);
			return true;
		}
		return false;
	}
	
	public int getScore() {
		return score;
	}

}
