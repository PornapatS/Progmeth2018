package items;

import character.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Heart extends Item {
	
	public Image heartPic = new Image("firstaidkid.png");

	public Heart() {
		super();
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(heartPic,x,y);
	}
	
	@Override
	public void effect(Player player) {
		player.gainLife();
	}

}