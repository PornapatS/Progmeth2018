package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.IRenderable;

public class GameScreen implements IRenderable {
	private int level = 1;
	private int score = 0;
	private int life = 10;
	private int barrierCount = 0;
	private int extraBulletCount = 0;
	private boolean isBarrierOn = false;
	private Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 25);
	public Image background = new Image("gamescreenbg.png");
	public Image warningbg = new Image("warning.png");
	public Image losebg = new Image("ilose.png");
	public Image lifeImage = new Image("life.png");
	public Image barrierImage = new Image("barriacount.png");
	public Image extraBulletImage = new Image("extrabulletcount.png");
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(background, 0, 0);
		gc.setFont(mainFont);
		gc.setFill(Color.WHITE);
		gc.fillText("Level : " + level, 100, 30);
		gc.fillText("Score : " + score, 230, 30);
		gc.drawImage(lifeImage, 395, 12);
		gc.fillText(" : " + life, 415, 30);
		gc.drawImage(extraBulletImage, 488, 9);
		gc.fillText(" : " + extraBulletCount, 500, 30);
		if (isBarrierOn) {
			gc.drawImage(barrierImage, 570, 10);				
			if (barrierCount > 1) {
				gc.drawImage(barrierImage, 597, 10);				
			} if (barrierCount > 2) {
				gc.drawImage(barrierImage, 624, 10);				
			}
		}
	}
	public void setBgLose(GraphicsContext gc) {
		gc.drawImage(background, 0, 0);
		gc.drawImage(losebg, 0, 0);
	}
	public void setBgWarning(GraphicsContext gc) {
		gc.drawImage(background, 0, 0);
		gc.drawImage(warningbg, 0, 0);
	}
	public boolean isShow() {
		return true;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void setBarrierCount(int barrierCount) {
		this.barrierCount = barrierCount;
	}
	public void setBarrierOn(boolean isBarrierOn) {
		this.isBarrierOn = isBarrierOn;
	}
	public void setExtraBulletCount(int extraBulletCount) {
		this.extraBulletCount = extraBulletCount;
	}
}
