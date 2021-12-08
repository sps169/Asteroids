package ies.luisvives.org.asteroids.View;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Entity extends Circle {
	private int moveX;
	private int moveY;

	public Entity(ReadOnlyDoubleProperty heightProp, int divide, Color color) {
		setFill(color);
		initSize(heightProp, divide);
		moveX = 0;
		moveY = 0;

	}

	private void initSize(ReadOnlyDoubleProperty heightProp, int divide) {
		radiusProperty().bind(heightProp.divide(divide));
	}

	public int getMoveX() {
		return moveX;
	}

	public void setMoveX(int moveX) {
		this.moveX = moveX;
		if (this.moveX > 1)
			this.moveX = 1;
		if (this.moveX < -1)
			this.moveX = -1;
	}

	public int getMoveY() {
		return moveY;
	}

	public void setMoveY(int moveY) {
		this.moveY = moveY;
		if (this.moveY > 1)
			this.moveY = 1;
		if (this.moveY < -1)
			this.moveY = -1;
	}
}
