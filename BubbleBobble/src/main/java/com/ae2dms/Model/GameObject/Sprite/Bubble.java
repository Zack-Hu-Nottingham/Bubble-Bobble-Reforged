package com.ae2dms.Model.GameObject.Sprite;

import com.ae2dms.Model.Scene.GameScene;
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

	protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/explosion.png").toString(), SIZE, SIZE, false, false);
	
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
			g.setGlobalAlpha((double)(255 - (int) (width * ((double) 255 / 2500)))/255);
			g.drawImage(image, x, y, width, height);
			g.setGlobalAlpha(1);
		} else {
			g.drawImage(image, x, y, width, height);
		}
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

	public void collideWith(Boss boss) {
		if (this.overlaps(boss)) {
			boss.collideWithProjectile();
		}
	}

}
