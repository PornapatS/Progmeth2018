package character;

public class Boss extends Position {
	private int score = 300;
	private int life = 50;
	private int speed = 10;
	
	public Boss() {

	}
	public boolean isAlive() {
		return life > 0;
	}
	
}
