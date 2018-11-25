package graphic;

import java.util.ArrayList;

import character.Alien;
import character.AlienA;
import character.AlienB;
import character.AlienC;
import character.Boss;
import character.Player;
import character.Position;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	private Position boss;
	private Position alienA;
	private Position alienB;	
	private Position alienC;
	private ArrayList<Position> characters = new ArrayList<>();
	
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
		player.draw(gc);
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
							if(!isOver) {
								gameScreen.draw(gc);
								updateallPos(gc);
							} else {
								changeScreen();								
							}
							try {
								Thread.sleep(1000);
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
		scene.setOnKeyPressed((KeyEvent) -> {
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
			if (KeyEvent.getCode() == KeyCode.SPACE ) {
				isOver = true;
			}
		});
	}
	public void addAlienA() {
		alienA = new AlienA(player);
		characters.add(alienA);
		alienA.draw(gc);
	}
	public void addAlienB() {
		alienB = new AlienB(player);
		characters.add(alienB);
		alienB.draw(gc);
	}
	public void addAlienC() {
		alienC = new AlienC(player);
		characters.add(alienC);
		alienC.draw(gc);
	}
	public void addBoss() {
		boss = new Boss();
		characters.add(boss);
		isAddedBoss = true;
		gameSound.stop();
		bossSound.play();
		boss.draw(gc);
	}
	public void changeScreen() {
		isStageOn = false;
		gameSound.stop();
		bossSound.stop();
		windowAnimation.stop();
		if(!player.isAlive()) {
			GameOverScreen.startanimation(gc, player.getScore());
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
		if(player.getLevel() == 6) {
			isLvSix = true;
			addBoss();
		}
	}
	public void updateallPos(GraphicsContext gcReal) {
		GraphicsContext gc = getGraphicsContext2D();
		player.updatePos(gc);

		for(int i = 0; i < characters.size(); i++) {
			Position c = characters.get(i);
			c.updatePos(gc);
			if (!c.isVisible()) characters.remove(i);
		}
		gcReal = gc;
	}
}