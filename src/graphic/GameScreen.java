package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameScreen {
	private int level = 1;
	private int score = 0;
	private int life = 10;
	private Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 20);
	public Image background;
	
	public GameScreen() {
		background = new Image("gamescreenbg.png");
	}
	public void draw(GraphicsContext gc) {
		gc.drawImage(background, 0, 0);
		gc.setFont(mainFont);
		gc.setFill(Color.BLACK);
		gc.fillText("Level : " + level, 50, 20);
		gc.fillText("Score : " + score, 150, 20);
		gc.fillText("Life : " + life, 250, 20);
	}
	public boolean isShow() {
		return true;
	}
}
