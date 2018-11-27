package sharedObject;

import java.util.ArrayList;
import java.util.List;

import character.Alien;
import character.Bullet;
import items.Item;
import character.Player;
import character.Boss;
import javafx.scene.canvas.GraphicsContext;

public class RenderableHolder {
	
	private static final RenderableHolder r = new RenderableHolder();
	private List<IRenderable> object;
	
	public RenderableHolder() {
		object = new ArrayList<IRenderable>();
	}
	
	public static RenderableHolder getInstance() {
		return r;
	}
	
	public void draw(GraphicsContext gc) {
		for (int i = 0; i < object.size(); ++i) {
			object.get(i).draw(gc);
		}
	}
	
	public void updatePos(String control, Player player) {
		player.setControl(control);
		player.updatePos();
		for (IRenderable i : object) {
			if (i instanceof Alien) {
				((Alien) i).updatePos();
				Collision(((Alien) i), player);
			}
			if (i instanceof Bullet) {
				((Bullet) i).updatePos();
			}
			if (i instanceof Item) {
				((Item) i).updatePos();
			}
		}
	}
	
	public int setShow() {
		int score = 0;
		for (IRenderable i : object) {
			if (i instanceof Alien) {
				for (IRenderable j : object) {
					if (j instanceof Bullet) {
						if (((Alien) i).isDestroyed(((Bullet) j).getX(),((Bullet) j).getY())) {
							((Alien) i).setShow(false);
							((Bullet) j).setShow(false);
							score += 10;
						}
					}
				}
			}
		}
		return score;
	}
	
	public double getDistance(double x1, double x2, double y1, double y2) {
		double distance = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return distance;
	}
	
	public void Collision(Player player) {
		double x = player.getX();
		double y = player.getY();
		for (IRenderable i : object) {
			if (i instanceof Item) {
				if (getDistance(x, ((Item) i).getX(), y, ((Item) i).getY()) <= 60) {
					((Item) i).effect(player);
					((Item) i).setShow(false);
				}
			}
			if (i instanceof Bullet) {
				if (getDistance(x, ((Bullet) i).getX(), y, ((Bullet) i).getY()) <= 60 && ((Bullet) i).isFromBoss()) {
					player.decreaseLife();
					((Bullet) i).setShow(false);
				} if (player.isBoss()) {
					if (getDistance(x, ((Bullet) i).getX(), y, ((Bullet) i).getY()) <= 60 && !((Bullet) i).isFromBoss()) {
						((Boss) player).decreaseLife();;
						((Bullet) i).setShow(false);
					}
				} 
			}
			if (i instanceof Alien) {
				if (getDistance(x, ((Alien) i).getX(), y, ((Alien) i).getY()) <= 40) {
					player.decreaseLife();
					((Alien) i).setShow(false);
				}
			}
		}
	}
	public void Collision(Alien alien, Player player) {
		double x = alien.getX();
		double y = alien.getY();
		for (IRenderable i : object) {
			if (i instanceof Bullet) {
				if (getDistance(x, ((Bullet) i).getX(), y, ((Bullet) i).getY()) <= 40 && !((Bullet) i).isFromBoss()) {
					alien.setShow(false);
					((Bullet) i).setShow(false);
					player.addScore(alien.getScore());
				}
			}
		}
	}

	public void add(IRenderable i) {
		object.add(i);
	}
	
	public void remove() {
		int n = object.size();
		for (int i = n-1; i >= 0; i--) {
			if (object.get(i).isShow() == false) {
				object.remove(i);
			}
		}
	}
	
	public void clearList() {
		this.object = null;
		this.object = new ArrayList<>();
	}
	
}