package ies.luisvives.org.asteroids.View;

import ies.luisvives.org.asteroids.Controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

import java.util.List;

public class GamePanel extends StackPane {
	private Entity player;
	private Walls walls;
	private List<Blaster> blasters;
	private List<Entity> asteroids;
	private GameController controller;

	public GamePanel () {
		initComponents();
		initController();
	}

	private void initController() {
		controller = new GameController(player, walls, blasters, asteroids);
	}

	private void initComponents() {
		player = new Entity(this.heightProperty());
		walls = new Walls(this.heightProperty(), this.widthProperty());
		this.getChildren().add(player);
		this.getChildren().addAll(walls.getWalls());

		//positioning
		setAlignment(walls.getTopWall(), Pos.TOP_CENTER);
		setAlignment(walls.getBottomWall(), Pos.BOTTOM_CENTER);
		setAlignment(walls.getLeftWall(), Pos.CENTER_LEFT);
		setAlignment(walls.getRightWall(), Pos.CENTER_RIGHT);
	}

}
