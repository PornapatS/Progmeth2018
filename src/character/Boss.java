package character;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss extends Player {
	
	private int time = 0;
	private boolean isCoolDown = false;
	private Random rand = new Random();
	private int life = 25;
	private boolean isShow = true;
	public Image bossPic = new Image("boss.png");

	public Boss() {
		super();
		setX(400);
		setY(150);
		setBoss(true);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(bossPic,x,y);
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
	
	@Override
	public boolean isShow() {
		return isShow;
	}
	
	public boolean isDead() {
		if (life<=0) return true;
		return false;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

}

                 