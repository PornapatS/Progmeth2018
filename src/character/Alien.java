package character;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Alien extends Position {
	
	private int way;
	private static double speed = 1 ;
	private Random rand = new Random();
	private Player player;
	public int score;
	public Image alienPic;
	
	public Alien(Player player) {
		super(0,0);
		double x = 0;
		double y = 0;
		way = rand.nextInt(6)+1;
		if (way == 1) {
			x = 25;
		} else if (way == 2) {
			x = 150;
		} else if (way == 3) {
			x = 275;
		} else if (way == 4) {
			x = 400;
		} else if (way == 5) {
			x = 525;
		} else if (way == 6) {
			x = 650;
		} else if (way == 7) {
			x = 775;
		} 
		setX(x);
		setY(y);
		this.player = player;
	}
	
	@Override
	public abstract void draw(GraphicsContext gc);
		
	public void updatePos() {
		int state = player.getLevel(); 
		if (state==2) {
			if (this instanceof AlienA) {
				x += getSpeed() * (Cos(player.getX(),player.getY()));
				y += getSpeed() * (Sin(player.getX(),player.getY()));	
			} else {
				y += getSpeed();	
			}
		} else if (state==4) {
			if (this instanceof AlienB) {
				x += getSpeed() * (Cos(player.getX(),player.getY()));
				y += getSpeed() * (Sin(player.getX(),player.getY()));	
			} else {
				y += getSpeed();	
			}
		} else {
			x += getSpeed() * (Cos(player.getX(),player.getY()));
			y += getSpeed() * (Sin(player.getX(),player.getY()));
		} 
		if (player.isAttacked(x, y) || y > 600) {
			setShow(false);
		}
	}
	
	public double Cos(double playerx, double playery) {
		double kam = playery-this.y;
		double chid = playerx-this.x;
		double chack = Math.sqrt((kam*kam)+(chid*chid));
		double cos = chid/chack;	
		return cos;
	}
	
	public double Sin(double playerx, double playery) {
		double kam = playery-this.y;
		double chid = playerx-this.x;
		double chack = Math.sqrt((kam*kam)+(chid*chid));
		double sin = kam/chack;
		return sin;
	}
	
	public abstract boolean isDestroyed(double x,double y);
	
	public static double getSpeed() {
		return speed;
	}

	public static void setSpeed(double speed) {
		Alien.speed = speed;
	}

	public int getScore() {
		return score;
	}

}
