package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WinnerScreen {
	public static final Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 40);
	public static final Font winnerFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 100);
	public static Image background = new Image("winnerscreenbg.png");
	
	public static void draw(GraphicsContext gc, int score) {
		gc.drawImage(background, 0, 0);
		gc.setFill(Color.WHITE);
		gc.setFont(winnerFont);
		gc.setLineWidth(5);
		gc.fillText("W I N N E R", 100, 300);
		gc.setFill(Color.DARKBLUE);
		gc.setFont(mainFont);
		gc.fillText("SCORE : " + score, 100, 350);
	}
	public static void startanimation(GraphicsContext gc, int score) {
		draw(gc, score);
	}	
}
