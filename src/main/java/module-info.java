module ies.luisvives.org.asteroids {
	requires javafx.controls;
	requires javafx.fxml;


	opens ies.luisvives.org.asteroids to javafx.fxml;
	exports ies.luisvives.org.asteroids;
}