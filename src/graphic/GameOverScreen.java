package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverScreen {
	public static final Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 40);
	public static final Font gameoverFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 100);
	public static final Image background  = new Image("gameoverscreenbg.png");

	public static void draw(GraphicsContext gc, int score) {				
		gc.drawImage(background, 0, 0);
		gc.setFont(gameoverFont);
		gc.setFill(Color.WHITE);
		gc.setLineWidth(2);
		gc.fillText("GAME OVER!", 150, 100);
		gc.setFont(mainFont);
		gc.fillText("SCORE : " + score, 300, 150);
	}

	public static void startanimation(GraphicsContext gc, int score) {
		draw(gc, score);
	}
}
