package items;

import character.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Barrier extends Item {
	
	public Barrier() {
		super();
		this.itemImage = new Image("barria.png");
	}
	
	@Override
	public void effect(Player player) {
		player.getBarrier();
	}

}