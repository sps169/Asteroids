package ies.luisvives.org.asteroids.View;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.paint.Color;

public class Player extends Entity{
	private boolean isMovingUp;
	private boolean isMovingDown;
	private boolean isMovingLeft;
	private boolean isMovingRight;
	private boolean isFiring;
	public Player(ReadOnlyDoubleProperty heightProp, int divide, Color color) {
		super(heightProp, divide, color);
		isMovingUp = false;
		isMovingDown = false;
		isMovingLeft = false;
		isMovingRight = false;
		isFiring = false;
	}


	public boolean isMovingUp() {
		return isMovingUp;
	}

	public void setMovingUp(boolean movingUp) {
		isMovingUp = movingUp;
	}

	public boolean isMovingDown() {
		return isMovingDown;
	}

	public void setMovingDown(boolean movingDown) {
		isMovingDown = movingDown;
	}

	public boolean isMovingLeft() {
		return isMovingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		isMovingLeft = movingLeft;
	}

	public boolean isMovingRight() {
		return isMovingRight;
	}

	public void setMovingRight(boolean movingRight) {
		isMovingRight = movingRight;
	}

	public boolean isFiring() {
		return isFiring;
	}

	public void setFiring(boolean firing) {
		isFiring = firing;
	}
}
