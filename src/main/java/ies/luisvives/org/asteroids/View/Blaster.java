package ies.luisvives.org.asteroids.View;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.paint.Color;

public class Blaster extends Entity {

	public Blaster(ReadOnlyDoubleProperty heightProp, int divide) {
		super(heightProp, divide, Color.YELLOWGREEN);
		super.setMoveX(1);
		super.setMoveY(1);
	}
}
