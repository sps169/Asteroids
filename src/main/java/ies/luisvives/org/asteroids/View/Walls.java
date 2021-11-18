package ies.luisvives.org.asteroids.View;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Walls {
	private Rectangle leftWall, topWall, rightWall, bottomWall;

	public Walls (ReadOnlyDoubleProperty windowHeight, ReadOnlyDoubleProperty windowWidth) {
		initComponents();
		setSize(windowHeight, windowWidth);
	}

	private void setSize(ReadOnlyDoubleProperty windowHeight, ReadOnlyDoubleProperty windowWidth) {
		leftWall.heightProperty().bind(windowHeight);
		leftWall.widthProperty().bind(windowWidth.divide(30));
		rightWall.heightProperty().bind(windowHeight);
		rightWall.widthProperty().bind(windowWidth.divide(30));
		topWall.heightProperty().bind(windowWidth.divide(30));
		topWall.widthProperty().bind(windowWidth);
		bottomWall.heightProperty().bind(windowWidth.divide(30));
		bottomWall.widthProperty().bind(windowWidth);
	}

	private void initComponents() {
		//instantiate
		leftWall = new Rectangle();
		topWall = new Rectangle();
		rightWall = new Rectangle();
		bottomWall = new Rectangle();

		//fill colors
		leftWall.setFill(Color.RED);
		topWall.setFill(Color.RED);
		rightWall.setFill(Color.RED);
		bottomWall.setFill(Color.RED);
	}

	public List<Rectangle> getWalls () {
		return List.of(leftWall, topWall, rightWall, bottomWall);
	}

	public Rectangle getLeftWall() {
		return leftWall;
	}

	public Rectangle getTopWall() {
		return topWall;
	}

	public Rectangle getRightWall() {
		return rightWall;
	}

	public Rectangle getBottomWall() {
		return bottomWall;
	}
}
