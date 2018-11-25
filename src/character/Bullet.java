package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet extends Position {
	
	private char direction;
	private boolean isShow = true;;
	private boolean isFromBoss = false;
	public Image bulletPic;

	public Bullet(double x,double y,char direction) {
		super(x,y);
		this.direction = direction;
		setBullet();
	}
	
	public void setBullet() {
		if (isFromBoss) bulletPic = new Image("bulletboss.png");
		else bulletPic = new Image("bulletplayer.png");
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(bulletPic,x,y);
	}
	
	@Override
	public void updatePos() {
		if ( x<0 || x>800 || y<0 || y>600 ) isShow = false;
		if (direction=='a') x-=10;
		if (direction=='d') x+=10;
		if (direction=='w') y-=10;
		if (direction=='s') y+=10;
		if (direction=='r') {
			x+=10;
			y+=10;
		}
		if (direction=='t') {
			x+=10;
			y-=10;
		}
		if (direction=='y') {
			x-=10;
			y-=10;
		}
		if (direction=='u') {
			x-=10;
			y+=10;
		}	
	}
	
	@Override
	public boolean isShow() {
		return isShow;
	}
	
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

	public boolean isFromBoss() {
		return isFromBoss;
	}

	public void setFromBoss(boolean isFromBoss) {
		this.isFromBoss = isFromBoss;
	}

}
