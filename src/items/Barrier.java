package items;

import character.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Barrier extends Item {
	
	public Image barrierPic = new Image("barria.png");

	public Barrier() {
		super();
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(barrierPic,x,y);
	}
	
	@Override
	public void effect(Player player) {
		player.getBarrier();
	}

}