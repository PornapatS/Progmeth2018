package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class Player extends Position {
	
	private int level = 1;
	private int score = 0;
	private int life = 10;
	private int speed = 2;
	private boolean isBarrierOn = false;
	private int barrierCount;
	private String control;
	private boolean isBoss = false;
	public Image playerPic = new Image("player.png");
	public Image barrierPic = new Image("barrier.png");
	
	public Player() {
		super(400,500);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if (isBarrierOn) gc.drawImage(barrierPic,x,y);
		gc.drawImage(playerPic,x,y);
	}
	
	@Override
	public void updatePos() {
		if (control.contains("a")) {
			if (x>=80) {
				x-=speed;
			}
		}
		if (control.contains("d")) {
			if (x+80<=800) {
				x+=speed; 	
			}
		}
		if (control.contains("w")) {
			if (y>=70) {
				y-=speed;
			}
		}
		if (control.contains("s")) {
			if (y+65<=600) {
				y+=speed;
			}
		}
	}
	
	@Override
	public boolean isShow() {
		return true;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void gainLife() {
		life++;
	}
	
	public void decreaseLife() {
		if (isBarrierOn) {
			barrierCount--;
			if (barrierCount == 0) isBarrierOn = false;
		} else {
			life--;
		}
	}
	
	public boolean isDead() {
		if (life<=0) return true;
		return false;
	}
	
	public void getBarrier() {
		isBarrierOn = true;
		barrierCount = 3;
	}
	
	public int getBarrierCount() {
		return barrierCount;
	}
	
	public boolean isBoss() {
		return isBoss;
	}

	public void setBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}

	public Bullet attack(char c) {
		Bullet bullet = new Bullet(x,y,c);
		RenderableHolder.getInstance().add(bullet);
		if (isBoss) bullet.setFromBoss(true);
		bullet.setBullet();
		return bullet;
	}
	
	public boolean isAttacked(double x,double y) {
		if (Math.abs(this.x-x)<=75 && Math.abs(this.y-y)<=54) {
			decreaseLife();
			return true;
		}
		return false;
	}
	
	public void setControl(String control) {
		this.control = control;
	}

}
