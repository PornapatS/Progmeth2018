package items;

import character.Player;
import javafx.scene.image.Image;

public class Bomb extends Item {

	public Bomb() {
		super();
		this.itemImage = new Image("bomb.png");
	}
	
	@Override
	public void effect(Player player) {
		if(player.isBarrierOn()) {
			player.setBarrierOn(false);
		} else {
			player.setLife(0);			
		}
	}

}
