package ies.luisvives.org.asteroids.View;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Entity extends Circle {
	public Entity(ReadOnlyDoubleProperty heightProp) {
		setFill(Color.AQUA);
		initSize(heightProp);
	}

	private void initSize(ReadOnlyDoubleProperty heightProp) {
		radiusProperty().bind(heightProp.divide(40));
	}
}
