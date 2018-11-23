package character;

import javafx.scene.image.Image;

public class AlienB extends Position{
	
	public AlienB() {
		super(1.0, 1.0);
		this.image = new Image("alienB.png");
		this.life = 1;
		this.score = 200;
		this.speed = 20;
	}
}
