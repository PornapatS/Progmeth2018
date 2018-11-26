package items;

import character.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Heart extends Item {
	
	public Heart() {
		super();
		this.itemImage = new Image("firstaidkid.png");
	}
	
	@Override
	public void effect(Player player) {
		player.gainLife();
	}

}