package items;

import items.Item;
import character.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb extends Item {

	public Bomb() {
		super();
		this.itemImage = new Image("bomb.png");
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.itemImage, x, y);
	}
	
	@Override
	public void effect(Player player) {
		player.setlife(0);
	}

}
