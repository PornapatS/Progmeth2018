package character;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class Boss extends Player {
	
	private int timer = 0;
	private boolean isCoolDown = false;
	private Random rand = new Random();

	public Boss() {
		super();
		setX(400);
		setY(100);
		setBoss(true);
		this.setLife(25);	
		this.ownerPic = new Image("boss.png");
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.ownerPic, x, y);
		if (!isCoolDown) {
			if (timer % 20 == 0) {
				attack('a');
				attack('d');
				attack('s');
				attack('r');
				attack('u');
			}
		}
		if (timer == 100) {
			isCoolDown = true;
		}
		if (timer == 500) {
			setX(rand.nextDouble() * 680);
			isCoolDown = false;
			timer = 0;
		}
		timer++;
	}

	@Override
	public Bullet attack(char c) {
		Bullet bullet = new Bullet(x + 150, y + 120, c);
		RenderableHolder.getInstance().add(bullet);
		bullet.setFromBoss(true);
		bullet.setBullet();
		return bullet;
	}	
	
}

                 