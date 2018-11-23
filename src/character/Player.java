package character;

import items.Barrier;
import items.Heart;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Player extends Position {
	
	private int level = 1;
	private int barrierCount;

	private boolean isBarrierOn = false;
	
	public AudioClip receiveItemSound = new AudioClip(ClassLoader.getSystemResource("receiveitem.wav").toString());
	//TODO public AudioClip collideSound = new AudioClip(ClassLoader.getSystemResource("animesound.wav").toString());
	
	public Player() {
		super(400, 500);
		this.life = 10;
		this.score = 0;
		this.speed = 2;
		this.image = new Image("player.png");
	}
		
	@Override
	public void updatePos() {
		if (control.contains("a")) {
			if (x >= 80) {
				x -= speed;
			}
		}
		if (control.contains("d")) {
			if (x + 80 <= 800) {
				x += speed; 	
			}
		}
		if (control.contains("w")) {
			if (y >= 70) {
				y -= speed;
			}
		}
		if (control.contains("s")) {
			if (y + 65 <= 600) {
				y += speed;
			}
		}
	}
//	public boolean isAttacked(double x,double y) {
//		if (Math.abs(this.x - x) <= 75 && Math.abs(this.y - y) <= 54) {
//			if (isBarrierOn) {
//				barrierCount--;
//				if (barrierCount == 0) {
//					isBarrierOn = false;
//				}
//			} else {
//				life--;
//				//TODO insert music   collidesound.play();
//			}
//			return true;
//		}
//		return false;
//	}
//	public Bullet attack(char c) {
//		Bullet bullet = new Bullet(x,y,c);
//		RenderableHolder.getinstance().add(bullet);
//		bullet.setFromPlayer(true);
//		bullet.setBullet();
//		return bullet;
//	}
//	public void setControl(String control) {
//		this.control = control;
//	}
	public void receiveItem(Object o) {
		receiveItemSound.play();
		if(o instanceof Barrier) {
			isBarrierOn = true;
			barrierCount = 3;			
		}
		if(o instanceof Heart) {
			life++;
		}
	}
	public void moveLeft() {
		control += "a";
	}
	public void moveRight() {
		control += "d";
	}
	public void moveUp() {
		control += "w";
	}
	public void moveDown() {
		control += "s";
	}
	public void levelUp() {
		level++;
	}
	public void addScore(int score) {
		this.score += score;
	}
	public void decreaseLife() {
		life--;
		if(life == 0) {
			isAlive = false;
		}
	}
	public int getLevel() {
		return level;
	}
}
