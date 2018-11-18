package graphic;

import character.Boss;
import character.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.media.AudioClip;

public class GameWindow extends Canvas{
	private AnimationTimer windowAnimation;
	private GameScreen gameScreen;
	
	private boolean isOver;
	
	private Player player;
	private Boss boss;
	
	private Scene scene;
	
	public AudioClip gameSound;
	public AudioClip bossSound;
	public AudioClip winnerSound;
	public AudioClip gameoverSound;
}
