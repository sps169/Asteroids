package ies.luisvives.org.asteroids;

import ies.luisvives.org.asteroids.View.AsteroidsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Asteroids extends Application {
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new AsteroidsView(), 500, 300);
		stage.setTitle("Asteroids");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}