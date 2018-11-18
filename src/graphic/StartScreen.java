package graphic;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartScreen {
	private final Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 40);
	private final Font titleFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 80);;
	private Stage primaryStage;
	private Canvas canvas;
	private HBox menu;
	private GraphicsContext gc;
	private boolean isSoundOn = false;
	private boolean isGameStart = false;
	public Button startButton;
	public Button exitButton;
	public Image background;
	public AudioClip gameSound = new AudioClip(ClassLoader.getSystemResource("Tempo.mp3").toString());
	public AudioClip buttonSound = new AudioClip(ClassLoader.getSystemResource("buttonsound.wav").toString());
	private AnimationTimer startscreenAnimation;
	private int timer = 0;
	
	public StartScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		canvas = new Canvas(800, 600);
		gc = canvas.getGraphicsContext2D();
		startButton = new Button("Start");
		exitButton = new Button("Exit");
		setupButton();
		gameSound.play();
		isSoundOn = true;
	}
	public void draw(GraphicsContext gc) {
		StackPane root = new StackPane();
		root.setPrefSize(800, 600);
		
		menu = new HBox(50);
		menu.setPrefWidth(800);
		menu.setPrefHeight(100);
		menu.setAlignment(Pos.BOTTOM_CENTER);
		root.getChildren().add(canvas);
		root.getChildren().add(menu);
		canvas.requestFocus();
		
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("ALIEN");

		startscreenAnimation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				setBackground();
				if(!isSoundOn) gameSound.play();
				if(timer == 50) {
					setBackground();
				}
				if(timer == 100) {
					menu.getChildren().addAll(startButton, exitButton);
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
		gc.setFill(Color.BISQUE);
		gc.setFont(titleFont);
		gc.fillText("ALIEN", 310, 500);
	}
	public void setupButton() {
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				isGameStart = true;
				startscreenAnimation.stop();
			}
		});
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				
			}
		});
	}
	public void startanimation() {
		draw(gc);
	}
}
