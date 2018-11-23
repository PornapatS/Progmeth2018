package character;

import javafx.scene.image.Image;

public class AlienA extends Position{

	public AlienA() {
		super(1.0, 1.0);
		this.image = new Image("alienA.png");
		this.life = 1;
		this.score = 100;
		this.speed = 10;
	}
}
