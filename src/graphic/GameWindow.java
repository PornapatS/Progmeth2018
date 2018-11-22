package graphic;

import character.Alien;
import character.AlienA;
import character.AlienB;
import character.AlienC;
import character.Boss;
import character.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class GameWindow extends Canvas{
	private AnimationTimer windowAnimation;
	private GameScreen gameScreen;
	private GraphicsContext gc;
	private Scene scene;
	private Stage primaryStage;
	
	private int frame = 0;
	
	private boolean isShow = false;
	private boolean isOver = false;
	private boolean isLvSix = false;
	private boolean isAddedBoss = false;
	private boolean toMainmenu = false;
	
	private Player player;
	private Boss boss;
	private Alien alienA;
	private Alien alienB;	
	private Alien alienC;
	
	public AudioClip gameSound = new AudioClip(ClassLoader.getSystemResource("Tempo.mp3").toString());
	public AudioClip bossSound = new AudioClip(ClassLoader.getSystemResource("Tempo.mp3").toString());
	public AudioClip winnerSound;
	public AudioClip gameoverSound;
	
	public GameWindow(Stage primaryStage) {
		setWidth(800);
		setHeight(600);
		gc = getGraphicsContext2D();
		StackPane root = new StackPane();
		root.getChildren().add(gc.getCanvas());
		requestFocus();
		
		// Fill code!
		
		player = new Player();
		
		scene = new Scene(root);
		
		this.primaryStage = primaryStage;
		this.primaryStage.setScene(scene);
		gameSound.play();
	}
	public void addAlienA() {
		alienA = new AlienA();
	}
	public void addAlienB() {
		alienB = new AlienB();
	}
	public void addAlienC() {
		alienC = new AlienC();
	}
	public void draw() {
		windowAnimation = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				frame = 0;
				update();
				isGameOver();
			}
		};
	}
	public void update() {
		// Fill code!		
	}
	
	public void isGameOver() {
		if(player.getLife() < 0) {
			windowAnimation.stop();
			isOver = true;
			
		}
		// Fill code!
		
	}
	public void addBoss() {
		isAddedBoss = true;
		boss = new Boss();

		// Fill code!
		
	}
}
