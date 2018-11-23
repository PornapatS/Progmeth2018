package graphic;

import java.util.ArrayList;

import character.AlienA;
import character.AlienB;
import character.AlienC;
import character.Boss;
import character.Player;
import character.Position;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class GameWindow extends Canvas{
	private AnimationTimer windowAnimation;
	private GameScreen gameScreen;
	private GraphicsContext gc;
	private StackPane root;
	private Scene scene;
	private Stage primaryStage;
	
	private boolean isStageOn = true;
	private boolean isOver = false;
	private boolean isLvSix = false;
	private boolean isAddedBoss = false;
		
	private Player player;
	private Position boss = new Boss();
	private Position alienA;
	private Position alienB;	
	private Position alienC;
	private ArrayList<Position> characters;
	
	public AudioClip gameSound = new AudioClip(ClassLoader.getSystemResource("Tempo.mp3").toString());
	public AudioClip bossSound = new AudioClip(ClassLoader.getSystemResource("Tempo.mp3").toString());
	
	
	public GameWindow(Stage primaryStage) {
		setWidth(800);
		setHeight(600);
		gc = getGraphicsContext2D();
		root = new StackPane();
		root.getChildren().add(gc.getCanvas());
		requestFocus();
		
		// TODO Fill code!
		
		player = new Player();
		gameScreen = new GameScreen();
		
		scene = new Scene(root);
		
		this.primaryStage = primaryStage;
		this.primaryStage.setScene(scene);
		gameSound.play();
	}
	public void draw() {
		addMove(gc);
		gameScreen.draw(gc);		
		windowAnimation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				Thread updatethread = new Thread(new Runnable() {					
					@Override
					public void run() {
						while(!isOver || isStageOn) {
							updateData();
							player.addScore(10);
							player.decreaseLife();
							// TODO updateallPos();
							if(!isOver) {
								gameScreen.draw(gc);
							} else {
								changeScreen();								
							}
							System.out.println("hello");
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
				updatethread.start();
			}
		};
		windowAnimation.start();
	}
	public void addMove(GraphicsContext gc) {
		this.setOnKeyPressed((KeyEvent) -> {
			if (KeyEvent.getCode() == KeyCode.LEFT) {
				player.moveLeft();
			}
			if (KeyEvent.getCode() == KeyCode.RIGHT) {
				player.moveRight();
			}
			if (KeyEvent.getCode() == KeyCode.UP) {
				player.moveUp();
			}
			if (KeyEvent.getCode() == KeyCode.DOWN ) {
				player.moveDown();
			}
		});
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
	public void addBoss() {
		boss = new Boss();
		isAddedBoss = true;
	}
	public void changeScreen() {
		isStageOn = false;
		gameSound.stop();
		bossSound.stop();
		windowAnimation.stop();
		if(!player.isAlive()) {
			GameOverScreen.startanimation(gc);
		}
		if(isAddedBoss && !boss.isAlive()) {
			WinnerScreen.startanimation(gc, player.getScore());
		}			
	}
	public void updateData() {
		gameScreen.setScore(player.getScore());
		gameScreen.setLevel(player.getLevel());
		gameScreen.setLife(player.getLife());
		if(!player.isAlive() || (isAddedBoss && !boss.isAlive())) {
			isOver = true;
		}
	}
	public void updateallPos() {
		player.updatePos();
		for(Position c : characters) {
			c.updatePos();
		}
	}
}