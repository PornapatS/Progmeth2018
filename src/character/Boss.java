package character;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss extends Position {
	private int time = 0;
	private boolean isCoolDown = false;
	private Random rand = new Random();
	
	public Boss() {
		super(400, 150);
		this.image = new Image("boss.png");
		this.life = 25;
		this.score = 3000;
		this.speed = 10;
	}
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.image, x, y);
		if (!isCoolDown) {
			if (time%5 == 0) {
				attack('a');
				attack('d');
				attack('s');
				attack('r');
				attack('u');
			}
		}
		if (time==100) isCoolDown = true;
		if (time==200) {
			setX(rand.nextDouble()*680);
			isCoolDown = false;
			time = 0;
		}
		time++;
	}
	public Bullet attack(char c) {
		Bullet bullet = new Bullet(x,y,c);
		bullet.setFromBoss(true);
		bullet.setBullet();
//		RenderableHolder.getInstance().add(bullet);
		return bullet;
	}
}
