package items;

import character.Player;
import javafx.scene.image.Image;

public class ExtraBullet extends Item {

	public ExtraBullet() {
		super();
		this.itemImage = new Image("extrabullet.png");
	}
	
	@Override
	public void effect(Player player) {
		player.getExtraBullet();
	}

}