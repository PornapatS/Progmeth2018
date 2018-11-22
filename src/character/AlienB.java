package character;

import javafx.scene.image.Image;

public class AlienB extends Alien{
	
	public AlienB() {
		super();
		this.alienImage = new Image("alienB.png");
		this.score = 10;
		this.speed = 5;
	}
}
