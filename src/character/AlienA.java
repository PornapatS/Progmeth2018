package character;

import javafx.scene.image.Image;

public class AlienA extends Alien{

	public AlienA() {
		super();
		this.alienImage = new Image("alienA.png");
		this.score = 10;
		this.speed = 5;
	}
}
