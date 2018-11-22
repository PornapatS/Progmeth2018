package character;

public class Player extends Character{
	private int level = 1;
	private int life = 10;
	private int score = 9999;
	
	public Player() {
		
	}
	public int getLevel() {
		return level;
	}
	public int getLife() {
		return life;
	}
	public int getScore() {
		return score;
	}
	
}
