package ies.luisvives.org.asteroids.Controller;

import ies.luisvives.org.asteroids.View.*;
import javafx.animation.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.List;

public class GameController {
	private Player player;
	private Walls walls;
	private List<Blaster> blasters;
	private List<Entity> asteroids;
	private GamePanel panel;
	private Timeline animation;

	public GameController (Player player, Walls walls, List<Blaster> blasters, List<Entity> asteroids, GamePanel panel) {
		this.player = player;
		this.walls = walls;
		this.blasters = blasters;
		this.asteroids = asteroids;
		this.panel = panel;
		initAnimation();
	}

	private void initAnimation() {
		this.animation = new Timeline(new KeyFrame(Duration.millis(17), t -> {
			movePlayer();
			if (System.currentTimeMillis() %  10 == 0)
				createAsteroid();
			checkCollitions();
		}));

		this.animation.setCycleCount(Animation.INDEFINITE);
		this.panel.setOnKeyPressed(e -> {
			switch(e.getCode().getChar()) {
				case "A":
					if (!this.player.isMovingLeft()) {
						this.player.setMoveX(this.player.getMoveX()-1);
						this.player.setMovingLeft(true);
					}
					break;
				case "D":
					if (!this.player.isMovingRight()) {
						this.player.setMoveX(this.player.getMoveX() + 1);
						this.player.setMovingRight(true);
					}
					break;
				case "W":
					if (!this.player.isMovingUp()) {
						this.player.setMoveY(this.player.getMoveY() - 1);
						this.player.setMovingUp(true);
					}
					break;
				case "S":
					if (!this.player.isMovingDown()) {
						this.player.setMoveY(this.player.getMoveY() + 1);
						this.player.setMovingDown(true);
					}
					break;
				case " ":
					this.player.setFiring(true);
					break;
			}
			animation.play();
		});
		this.panel.setOnKeyReleased(e -> {
			switch(e.getCode().getChar()) {
				case "A":
					if (player.isMovingLeft()) {
						this.player.setMoveX(this.player.getMoveX() + 1);
						this.player.setMovingLeft(false);
					}
					break;
				case "D":
					if (player.isMovingRight()) {
						this.player.setMoveX(this.player.getMoveX() - 1);
						this.player.setMovingRight(false);
					}
					break;
				case "W":
					if (player.isMovingUp()) {
						this.player.setMoveY(this.player.getMoveY() + 1);
						this.player.setMovingUp(false);
					}
					break;
				case "S":
					if (player.isMovingDown()) {
						this.player.setMoveY(this.player.getMoveY() - 1);
						this.player.setMovingDown(false);
					}
					break;
				case " ":
					this.player.setFiring(false);
					break;
			}
//			if (player.getMoveX() == 0 && player.getMoveY() == 0 && !player.isFiring())
//				animation.stop();
		});
		this.panel.setOnMousePressed(e -> {
			this.player.setFiring(true);
			createBlaster(e);
		});
		this.panel.setOnMouseReleased(e -> {
			this.player.setFiring(false);
		});
		this.panel.setFocusTraversable(true);

	}

	private void checkCollitions() {
		System.out.println(asteroids.size() + " " + blasters.size());
		while (asteroids.iterator().hasNext()) {
			Entity asteroid = asteroids.iterator().next();
			while (blasters.iterator().hasNext()) {
				Blaster blaster = blasters.iterator().next();
				if (blaster.getBoundsInLocal().intersects(asteroid.getBoundsInLocal()))
				{
					blaster.setVisible(false);
					panel.getChildren().remove(blaster);
					blasters.remove(blaster);
					asteroid.setVisible(false);
					panel.getChildren().remove(asteroid);
					asteroids.remove(asteroid);
				}
			}
		}

	}

	private void initBlasterAnimation(Blaster blaster, MouseEvent e) {

		TranslateTransition blasterAnimation = new TranslateTransition(Duration.millis(500), blaster);
		blasterAnimation.setFromX(player.getTranslateX());
		blasterAnimation.setFromY(player.getTranslateY());
		blasterAnimation.setToX((e.getX() - panel.widthProperty().divide(2).get()));
		blasterAnimation.setToY((e.getY() - panel.heightProperty().divide(2).get()));
		blasterAnimation.setOnFinished(s -> {
			blaster.setVisible(false);
			blasters.remove(blaster);
			this.panel.getChildren().remove(blaster);
		});
		blasterAnimation.play();
	}

	private void createAsteroid () {
		double modifierX = 1;
		double modifierY = 1;
		double modifierToX = 1;
		double modifierToY = 1;
		Entity asteroid = new Entity(this.panel.heightProperty(), 30, Color.BLACK);
		asteroid.setVisible(false);
		FadeTransition fadeTransition = new FadeTransition(Duration.millis(100), asteroid);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		TranslateTransition asteroidAnimation = new TranslateTransition(Duration.millis(10000), asteroid);
		ParallelTransition sequentialTransition = new ParallelTransition(fadeTransition, asteroidAnimation);
		sequentialTransition.play();
		if (Math.random() > 0.5)
		{
			modifierY = Math.random()* 2 - 1;
			if(Math.random() > 0.5)
				modifierX = -1;
		}
		else
		{
			modifierX = Math.random() * 2 - 1;
			if(Math.random() > 0.5)
				modifierY = -1;
		}
		asteroidAnimation.setFromX((panel.widthProperty().divide(2).get() + asteroid.getRadius()) * modifierX);
		asteroidAnimation.setFromY((panel.widthProperty().divide(2).get() + asteroid.getRadius()) * modifierY);
		if (Math.random() > 0.5)
		{
			modifierToY = Math.random();
			if (modifierY < 0)
				modifierToY *= -1;
		}
		else
		{
			modifierToX = Math.random();
			if (modifierX < 0)
				modifierToX *= 0;
		}
		asteroidAnimation.setToX((panel.widthProperty().divide(2).get() * modifierToX * -1 + asteroid.getRadius() * -1));
		asteroidAnimation.setToY((panel.widthProperty().divide(2).get() * modifierToY * -1 + asteroid.getRadius()) * -1);
		this.panel.getChildren().add(asteroid);
		this.asteroids.add(asteroid);
		asteroidAnimation.setOnFinished(s -> {
			asteroid.setVisible(false);
			this.panel.getChildren().remove(asteroid);
			asteroids.remove(asteroid);
		});
		asteroid.setVisible(true);
	}

	private void createBlaster(MouseEvent e) {
		if (player.isFiring()){
			Blaster blaster = new Blaster(this.panel.heightProperty(), 50);
			this.blasters.add(blaster);
			this.panel.getChildren().add(blaster);
//			if (this.blasters.size() > 10)
//				this.panel.getChildren().remove(this.blasters.remove(0));
			initBlasterAnimation(blaster, e);
		}
	}

	private void movePlayer() {
		this.player.setTranslateX(this.player.getTranslateX()+this.player.getMoveX() * panel.widthProperty().divide(400).get());//*this.player.getSpeedX());
		this.player.setTranslateY(this.player.getTranslateY()+this.player.getMoveY() * panel.heightProperty().divide(300).get());//*this.player.getSpeedY());
	}
}