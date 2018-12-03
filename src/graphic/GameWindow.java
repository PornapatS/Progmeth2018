package graphic;

import java.util.Random;

import character.Alien;
import character.AlienA;
import character.AlienB;
import character.AlienC;
import character.Boss;
import character.Player;
import items.Barrier;
import items.Bomb;
import items.Heart;
import items.Item;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;

public class GameWindow extends Canvas{
	private AnimationTimer windowAnimation;
	private StartScreen startScreen;
	private GameScreen gameScreen;
	private GraphicsContext gc;
	AnchorPane bosspane = new AnchorPane();
	private StackPane root;
	private Scene scene;
	private Stage primaryStage;
	
	private String control = "";
	private int frame;
	private int state;
	private boolean isStageOn;
	private boolean isOver;
	private boolean isAddedBoss;
	private static Random randitem = new Random();
	private static Random randalien = new Random();
	
	private int timerLevel = 2000;
	private int timerAlien = 80;
	private int timerItem = 800;
	
	private Player player;
	private Boss boss;
	private Alien alienA;
	private Alien alienB;	
	private Alien alienC;
	private Item item;
	private ProgressBar bossBar = new ProgressBar();
	
	public AudioClip gameSound = new AudioClip(ClassLoader.getSystemResource("Tempo.mp3").toString());
	public AudioClip bossSound = new AudioClip(ClassLoader.getSystemResource("winner.wav").toString());
	
	
	public GameWindow(Stage primaryStage) {
		setWidth(800);
		setHeight(600);
		gc = getGraphicsContext2D();
		root = new StackPane();
		root.getChildren().add(gc.getCanvas());
		requestFocus();
				
		startScreen = new StartScreen(primaryStage);
		gameScreen = new GameScreen();
		scene = new Scene(root);
		
		this.primaryStage = primaryStage;
		this.primaryStage.setScene(scene);
		gameSound.play();
	}
	public void draw() {
		addMove(gc);
		setDefault();
		gameScreen.draw(gc);		
		player = new Player();
		RenderableHolder.getInstance().add(player);
		windowAnimation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				updateDetail();
				updateState();
				updateSong();
				isGameEnd();
			}
		};
		windowAnimation.start();
	}
	public void addMove(GraphicsContext gc) {
		scene.setOnKeyPressed((KeyEvent) -> {
			if (KeyEvent.getCode() == KeyCode.LEFT) {
				control += "a";
			}
			if (KeyEvent.getCode() == KeyCode.RIGHT) {
				control += "d";
			}
			if (KeyEvent.getCode() == KeyCode.UP) {
				control += "w";
			}
			if (KeyEvent.getCode() == KeyCode.DOWN ) {
				control += "s";
			}
			if (KeyEvent.getCode() == KeyCode.ENTER && !isStageOn) {
				windowAnimation.stop();
				setDefault();
				startScreen.startanimation();
			}
			if (KeyEvent.getCode() == KeyCode.ESCAPE ) {
				Platform.exit();
			}
			if (KeyEvent.getCode() == KeyCode.B) {
				setState(6);
				addBoss();
			}

		});
		this.setOnKeyReleased((KeyEvent) -> {
			if (KeyEvent.getCode() == KeyCode.LEFT) {
				control = control.replace("a", "");
				RenderableHolder.getInstance().updatePos(control, player);
			}
			if (KeyEvent.getCode() == KeyCode.RIGHT) {
				control = control.replace("d", "");
				RenderableHolder.getInstance().updatePos(control, player);
			}
			if (KeyEvent.getCode() == KeyCode.UP) {
				control = control.replace("w", "");
				RenderableHolder.getInstance().updatePos(control, player);
			}
			if (KeyEvent.getCode() == KeyCode.DOWN ) {
				control = control.replace("s", "");
				RenderableHolder.getInstance().updatePos(control, player);
			}
		});
	}
	public void setDefault() {
		frame = 0;
		setState(1);
		timerAlien = 80;
		timerItem = 800;
		timerLevel = 2000;
		isOver = false;
		isAddedBoss = false;
		isStageOn = true;
		gameScreen.setLevel(1);
		gameScreen.setLife(10);
		gameScreen.setScore(0);
		gameSound.stop();
		bossSound.stop();
		RenderableHolder.getInstance().clearList();
	}
	public void addAlienA() {
		alienA = new AlienA(player);
		RenderableHolder.getInstance().add(alienA);
	}
	public void addAlienB() {
		alienB = new AlienB(player);
		RenderableHolder.getInstance().add(alienB);
	}
	public void addAlienC() {
		alienC = new AlienC(player);
		RenderableHolder.getInstance().add(alienC);
	}
	public void addBoss() {
		boss = new Boss();
		isAddedBoss = true;
		bossBar.setProgress(1);
		
		bosspane.getChildren().add(bossBar);
		bosspane.setTopAnchor(bossBar, boss.getY() - 50);
		bosspane.setLeftAnchor(bossBar, boss.getX() + 110);
		
		root.getChildren().add(bosspane);
		RenderableHolder.getInstance().add(boss);
		gameSound.stop();
		bossSound.play();
	}
	public void addItem() {
		int r = randitem.nextInt(3);
		if(r == 0) {
			item = new Heart();
		}
		if(r == 1) {
			item = new Barrier();
		}
		if(r == 2) {
			item = new Bomb();
		}
		RenderableHolder.getInstance().add(item);
	}
	private void updateSong() {
		if(!isOver && !isAddedBoss) {
			if(!gameSound.isPlaying()) gameSound.play();
		}
		if(!isOver && isAddedBoss && !boss.isDead()) {
			if(!bossSound.isPlaying()) bossSound.play();
		}
	}

	private void updateState() {
		frame++;
		if(frame % 12 == 0) {
			fire();
		}
		if(frame % timerAlien == 0) {			
			int r = randalien.nextInt(2);
			if(getState() == 1) addAlienA();
			if(getState() == 2 && r == 0) addAlienA();
			if(getState() == 2 && r == 1) addAlienB();
			if(getState() == 3) addAlienB();
			if(getState() == 4 && r == 0) addAlienB();
			if(getState() == 4 && r == 1) addAlienC();
			if(getState() == 5) addAlienC();
			if(getState() == 6 && isAddedBoss) addAlienC();
			if(getState() == 6 && !isAddedBoss) addBoss();
		}
		if(frame % timerItem == 0) {
			addItem();
		}
		if(frame % timerLevel == 0 && getState() < 6) {
			player.levelUp();
			setState(getState() + 1);
			gameScreen.setLevel(player.getLevel());
			timerItem -= 50;
			timerAlien -= 5;
			timerLevel += 200;
			frame = 0;
		}
	}
	private void updateDetail() {
		RenderableHolder.getInstance().remove();
		RenderableHolder.getInstance().Collision(player);
		if(isAddedBoss) {
			RenderableHolder.getInstance().Collision(boss);
			bossBar.setProgress(0.02 * boss.getLife());
			bosspane.setTopAnchor(bossBar, boss.getY() - 50);
			bosspane.setLeftAnchor(bossBar, boss.getX() + 110);
		}
		updateData();			
		this.gameScreen.draw(gc);
		RenderableHolder.getInstance().updatePos(control, player);
		this.control = "";
		RenderableHolder.getInstance().draw(gc);
	}
	public void isGameEnd() {
		if(isOver) {
			gameSound.stop();
			bossSound.stop();
			windowAnimation.stop();
			root.getChildren().remove(bosspane);
			isStageOn = false;
			if(player.isDead()) {
				GameOverScreen.startanimation(gc, player.getScore());
			}
			if(isAddedBoss && boss.isDead()) {
				WinnerScreen.startanimation(gc, player.getScore());
			}
		}
	}
	public void updateData() {
		if(player.isDead() || (isAddedBoss && boss.isDead())) {
			if(boss.isDead()) player.addScore(500);
			isOver = true;
		}
		gameScreen.setScore(player.getScore());
		gameScreen.setLife(player.getLife());
		gameScreen.setBarrierOn(player.isBarrierOn());
		gameScreen.setBarrierCount(player.getBarrierCount());
	}
	public void fire() {
		player.attack('w');
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}