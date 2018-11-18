package graphic;

import character.Alien;
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
	
	private boolean isShow = false;
	private boolean isOver = false;
	private boolean isAddedBoss = false;
	
	private Player player;
	private Boss boss;
	private Alien alienA;
	private Alien alienB;	
	private Alien alienC;
	
	public AudioClip gameSound = new AudioClip(ClassLoader.getSystemResource("Tempo.mp3").toString());
	public AudioClip bossSound;
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
	
	public void isGameOver() {
		
		// Fill code!
		
	}
	public void addBoss() {
		isAddedBoss = true;
		boss = new Boss();

		// Fill code!
		
	}
}
