package character;

import javafx.scene.image.Image;

public class AlienC extends Position{
	
	public AlienC() {
		super(1.0, 1.0);
		this.image = new Image("alienA.png");
		this.life = 1;
		this.score = 300;
		this.speed = 30;
	}
}
