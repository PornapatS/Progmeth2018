package items;

import character.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb extends Item {

	public Image bombPic = new Image("bomb.png");

	public Bomb() {
		super();
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(bombPic,x,y);
	}
	
	@Override
	public void effect(Player player) {
		player.setLife(0);
	}

}
