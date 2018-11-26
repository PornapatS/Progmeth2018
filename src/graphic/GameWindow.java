package graphic;

import character.Alien;
import character.AlienA;
import character.AlienB;
import character.AlienC;
import character.Boss;
import character.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;

public class GameWindow extends Canvas{
	private AnimationTimer windowAnimation;
	private GameScreen gameScreen;
	private GraphicsContext gc;
	private StackPane root;
	private Scene scene;
	private Stage primaryStage;
	
	private String control = "";
	private int frame = 0;	
	private boolean isStageOn = true;
	private boolean isOver = false;
	private boolean isLvSix = false;
	private boolean isAddedBoss = false;
		
	private Player player;
	private Boss boss;
	private Alien alienA;
	private Alien alienB;	
	private Alien alienC;
	
	public AudioClip gameSound = new AudioClip(ClassLoader.getSystemResource("Tempo.mp3").toString());
	public AudioClip bossSound = new AudioClip(ClassLoader.getSystemResource("winner.wav").toString());
	
	
	public GameWindow(Stage primaryStage) {
		setWidth(800);
		setHeight(600);
		gc = getGraphicsContext2D();
		root = new StackPane();
		root.getChildren().add(gc.getCanvas());
		requestFocus();
		
		// TODO Fill code!
		
		player = new Player();
		RenderableHolder.getInstance().add(player);
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
			if (KeyEvent.getCode() == KeyCode.ESCAPE ) {
				Platform.exit();
			}

		});
		this.setOnKeyReleased((KeyEvent) -> {
			if (KeyEvent.getCode() == KeyCode.LEFT) {
				control = control.replace("a","");
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
		RenderableHolder.getInstance().add(boss);
	}
	public void addItem() {
		//TODO
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
		// TODO Auto-generated method stub
		frame++;
		if ((frame % 600) < 500) {
			if(frame % 10 == 0) {
				fire();
			}
			if(frame % 100 == 0) {
				addAlienA();
			}
			if(frame % 500 == 0) {
				player.levelUp();
			}
			if(frame % 500 == 0) {
				addItem();
			}
		}
		if(!isOver) {
			if(player.getLevel() == 6 && !isAddedBoss) {
				addBoss();
				isLvSix = true;
				gameSound.stop();
				bossSound.play();
			}
		}		
	}

	private void updateDetail() {
		RenderableHolder.getInstance().remove();
		RenderableHolder.getInstance().Collision(player);
		if(isAddedBoss) {
			RenderableHolder.getInstance().Collision(boss);
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
			if(player.isDead()) {
				GameOverScreen.startanimation(gc, player.getScore());
			}
			if(isAddedBoss && boss.isDead()) {
				WinnerScreen.startanimation(gc, player.getScore());
			}
		}
	}
	public void updateData() {
		gameScreen.setScore(player.getScore());
		gameScreen.setLevel(player.getLevel());
		gameScreen.setLife(player.getLife());
		if(player.isDead() || (isAddedBoss && boss.isDead())) {
			isOver = true;
		}
	}
	public void fire() {
		player.attack('w');
	}

}