package graphic;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverScreen {
	public static final Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 40);
	public static final Font gameoverFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 100);
	public static Image background;
	public static AudioClip gameoverSound;
	private static Thread t;
	public Button mainmenuButton;
	private boolean isDone;
	
	public GameOverScreen() {

	}
	public static void draw(GraphicsContext gc) {
		background = new Image("gameoverscreenbg.png");
		gameoverSound = new AudioClip(ClassLoader.getSystemResource("Lil Touch.mp3").toString());
		gameoverSound.play();
		
		t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setUpGameover(gc);
				try {
					Thread.sleep(1000);
					System.out.println("DONE!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});
		t.start();
	}
	public static void setUpGameover(GraphicsContext gc) {
		gc.setFont(gameoverFont);
		gc.setFill(Color.BLACK);
		gc.setLineWidth(2);
		gc.fillText("Game Over!", 100, 100);
		gc.setFont(mainFont);
//		gc.fillText("Score : ", 300, 250);
		
	}
	public static void startanimation(GraphicsContext gc) {
		draw(gc);
	}
	
	
}
