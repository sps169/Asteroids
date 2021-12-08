package ies.luisvives.org.asteroids.View;

import ies.luisvives.org.asteroids.Controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class GamePanel extends StackPane {
	private Player player;
	private Walls walls;
	private List<Blaster> blasters;
	private List<Entity> asteroids;
	private GameController controller;

	public GamePanel () {
		initComponents();
		initController();
	}

	private void initController() {
		controller = new GameController(player, walls, blasters, asteroids, this);
	}

	private void initComponents() {
		player = new Player(this.heightProperty(), 40, Color.AQUA);
		walls = new Walls(this.heightProperty(), this.widthProperty());
		blasters = new LinkedList<>();
		asteroids = new LinkedList<>();
		this.getChildren().add(player);
		this.getChildren().addAll(walls.getWalls());

		//positioning
		setAlignment(walls.getTopWall(), Pos.TOP_CENTER);
		setAlignment(walls.getBottomWall(), Pos.BOTTOM_CENTER);
		setAlignment(walls.getLeftWall(), Pos.CENTER_LEFT);
		setAlignment(walls.getRightWall(), Pos.CENTER_RIGHT);
	}

}
