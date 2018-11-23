package character;

import javafx.scene.canvas.GraphicsContext;

public abstract class Position {
	protected double x;
	protected double y;
	
	public Position() {
		this.x = 0;
		this.y = 0;
	}
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
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
	
}
