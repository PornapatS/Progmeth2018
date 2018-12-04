package graphic;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Buttons;

public class StartScreen {
	private static final Font titleFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 100);;
	private Stage primaryStage;
	private Canvas canvas;
	private GraphicsContext gc;
	private boolean isSoundOn = false;
	public Buttons menu;
	public Image background;
	public AudioClip gameSound = new AudioClip(ClassLoader.getSystemResource("startSound.wav").toString());
	public AudioClip buttonSound = new AudioClip(ClassLoader.getSystemResource("buttonsound.wav").toString());
	private AnimationTimer startscreenAnimation;
	private int timer = 0;
	
	public StartScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		canvas = new Canvas(800, 600);
		gc = canvas.getGraphicsContext2D();
		menu = new Buttons();
		setupButton();
		gameSound.setVolume(0.6);
		buttonSound.setVolume(1);		
	}
	public void draw(GraphicsContext gc) {
		StackPane root = new StackPane();
		root.setPrefSize(800, 600);
		root.getChildren().add(canvas);
		canvas.requestFocus();
		
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("ALIEN");
		gameSound.play();
		isSoundOn = true;

		startscreenAnimation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				setBackground();
				if(!isSoundOn) gameSound.play();
				if(timer == 30) {
					root.getChildren().add(menu);
				}
				timer++;
			}
		};
		startscreenAnimation.start();
	}
	public void setBackground() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		background = new Image("startscreenbg.png");
		gc.drawImage(background, 0, 0);
		gc.setFill(Color.DARKBLUE);
		gc.setLineWidth(5);
		gc.setFont(titleFont);
		gc.fillText("A L I E N", 250, 500);
	}
	public void setupButton() {
		menu.startButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				buttonSound.play();
				GameWindow game = new GameWindow(primaryStage);
				game.draw();
				startscreenAnimation.stop();
				gameSound.stop();
				isSoundOn = false;
			}
		});
		menu.setupExitButton();
	}
	public void startanimation() {
		draw(gc);
	}
}
