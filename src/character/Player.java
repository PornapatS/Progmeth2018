package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Player extends Position {
	
	private int level = 1;
	private int score = 0;
	private int life = 10;
	private int speed = 2;
	private int barrierCount;

	private boolean isBarrierOn = false;

	private String control;

	public Image playerImage = new Image("player.png");
	//public Image barrierImage = new Image("barrier.png");
	
	public AudioClip receiveItemSound = new AudioClip(ClassLoader.getSystemResource("receiveitem.wav").toString());
	//TODO public AudioClip collideSound = new AudioClip(ClassLoader.getSystemResource("animesound.wav").toString());
	
	public Player() {
		super(400, 500);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
	//	if (isBarrierOn) gc.drawImage(barrierImage, x, y);
		gc.drawImage(playerImage, x, y);
	}
	
	@Override
	public void updatePos() {
		if (control.contains("a")) {
			if (x >= 80) {
				x -= speed;
			}
		}
		if (control.contains("d")) {
			if (x+80 <= 800) {
				x += speed; 	
			}
		}
		if (control.contains("w")) {
			if (y >= 70) {
				y -= speed;
			}
		}
		if (control.contains("s")) {
			if (y+65 <= 600) {
				y += speed;
			}
		}
	}
	@Override
	public boolean isShow() {
		return true;
	}
	public void getBarrier() {
		isBarrierOn = true;
		barrierCount = 3;
	}
	public boolean isAttacked(double x,double y) {
		if (Math.abs(this.x - x) <= 75 && Math.abs(this.y - y) <= 54) {
			if (isBarrierOn) {
				barrierCount--;
				if (barrierCount == 0) {
					isBarrierOn = false;
				}
			} else {
				life--;
				//TODO insert music   collidesound.play();
			}
			return true;
		}
		return false;
	}
//	public Bullet attack(char c) {
//		Bullet bullet = new Bullet(x,y,c);
//		RenderableHolder.getinstance().add(bullet);
//		bullet.setFromPlayer(true);
//		bullet.setBullet();
//		return bullet;
//	}
	public void setControl(String control) {
		this.control = control;
	}
	public void levelUp() {
		level++;
	}
	public void addScore(int score) {
		this.score += score;
	}
	public void addLife(int life) {
		this.life += life;
	}
	public int getLife() {
		return life;
	}
	public int getScore() {
		return score;
	}
	public int getLevel() {
		return level;
	}
}
