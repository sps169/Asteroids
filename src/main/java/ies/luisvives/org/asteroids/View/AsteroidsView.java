package ies.luisvives.org.asteroids.View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class AsteroidsView extends BorderPane {
	private StackPane gamePanel;
	private Label title;
	private Label stats;
	public AsteroidsView () {
		initComponents();
		size();
	}

	private void size() {

	}

	private void initComponents() {
		this.gamePanel = new GamePanel();
		this.title = new Label("ASTEROIDS");
		this.stats = new Label("Puntuacion: not really");
		setTop(title);
		setCenter(gamePanel);
		setBottom(stats);

		//sizes
		this.gamePanel.minHeightProperty().bind(this.heightProperty().divide(1.25));
		this.gamePanel.minWidthProperty().bind(this.widthProperty().divide(1.25));
	}
}
