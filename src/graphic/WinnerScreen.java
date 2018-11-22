package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WinnerScreen {
	public static final Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 40);
	public static final Font winnerFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 80);
	public static Image background;
	public Button mainmenuButton;
	public AudioClip winnerSound = new AudioClip(ClassLoader.getSystemResource("Lil Touch.mp3").toString());
	public static boolean isDone = false;
	
	public static void draw(GraphicsContext gc) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				gc.drawImage(background, 0, 0);
				gc.setFill(Color.BLACK);
				gc.setFont(winnerFont);
				gc.setLineWidth(5);
				gc.fillText("W I N N E R", 10, 20);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isDone = true;
			}
		});
		t.setDaemon(true);
		t.start();
	}
	public static void startanimation(GraphicsContext gc) {
		draw(gc);
	}
	public static boolean isDone() {
		return isDone;
	}
	
	
}
