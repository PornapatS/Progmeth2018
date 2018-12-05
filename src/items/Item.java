package items;

import java.util.Random;

import character.Player;
import character.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Item extends Position {
	
	private int timeLife = 200;
	private static Random rand = new Random();
	public Image itemImage;
	
	public Item() {
		super(rand.nextInt(730)+36,rand.nextInt(280)+100);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.itemImage, x, y);
	}
	
	public abstract void effect(Player player);
	
	public void updatePos() {
		timeLife--;
		if (timeLife <= 0) {
			this.setShow(false); 
		}
	}

}