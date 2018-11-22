package character;

import javafx.scene.image.Image;

public class AlienC extends Alien{
	
	public AlienC() {
		super();
		this.alienImage = new Image("alienC.png");
		this.score = 10;
		this.speed = 5;
	}
}
