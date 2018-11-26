package character;

import sharedObject.IRenderable;

public abstract class Position implements IRenderable {
	
	protected double x;
	protected double y;
	private boolean isShow = true;
	
	public Position(double x,double y) {
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
	
	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

	public abstract void updatePos();

}