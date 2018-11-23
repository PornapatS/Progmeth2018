package character;

import javafx.scene.canvas.GraphicsContext;

public abstract class Position {
	protected double x;
	protected double y;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	public void updatePos() {
		
		// TODO Auto-generated method stub
		
	}
	public boolean isShow() {
		// TODO Auto-generated method stub
		return false;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
}
