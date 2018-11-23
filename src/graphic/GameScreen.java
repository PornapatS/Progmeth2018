package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.IRenderable;

public class GameScreen implements IRenderable {
	private int level = 1;
	private int score = 0;
	private int life = 10;
	private Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 25);
	public Image background = new Image("gamescreenbg.png");
	public Image lifeImage = new Image("life.png");
	
	public GameScreen() {
	
	}
	public void draw(GraphicsContext gc) {
		gc.drawImage(background, 0, 0);
		gc.setFont(mainFont);
		gc.setFill(Color.WHITE);
		gc.fillText("Level : " + level, 100, 30);
		gc.fillText("Score : " + score, 230, 30);
		gc.drawImage(lifeImage, 395, 12);
		gc.fillText(" : " + life, 415, 30);
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
}
