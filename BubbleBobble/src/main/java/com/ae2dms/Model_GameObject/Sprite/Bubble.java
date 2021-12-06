package com.ae2dms.Model_GameObject.Sprite;

import com.ae2dms.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * The com.ae2dms.GameObject.Objects.Bubble class handles everything with the main.Hero's special ability, named the bubble.
 * It begins at the hero, and grows covering the whole screen.
 * Once it collides with an enemy, that enemy is bubbled.
 */
public class Bubble extends SpriteObject {
	private int accel;
	private static final int SIZE = 25;

	protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/bubbled.png").toString(), SIZE, SIZE, false, false);
	
	public Bubble(GameScene world, int x, int y) {
		super(x, y, 0, 0, world, image);
		accel = 1;
	}

	@Override
	public void update() {
		if (width >= 2500) {
			markToRemove();
		}
		x -= accel / 2;
		y -= accel / 2;
		width += accel;
		height += accel;
		accel += 1;
	}
	
	@Override
	public void drawOn(GraphicsContext g) {
		if (width <= 2500) {
			g.setFill(new Color(255/255, 204/255, 102/255, (double)(255 - (int) (width * ((double) 255 / 2500)))/255));
		} else {
			g.setFill(new Color(255/255, 204/255, 102/255, 0));
		}
		g.fillOval(x, y, width, height);
		g.setFill(Color.BLACK);
	}

	@Override
	public void collideWithFloor() {
		// Nothing happens
	}

	@Override
	public void collideWithCeiling() {
		// Nothing happens
	}

	@Override
	public void collideWithWall() {
		// Nothing happens
	}
	
	public void collideWith(Enemy enemy) {
		if (this.overlaps(enemy)) {
			enemy.collideWithProjectile();
		}
	}

}
