package com.ae2dms.model.gameObject.sprite.projectile;

import com.ae2dms.model.gameObject.sprite.character.Boss;
import com.ae2dms.model.gameObject.sprite.character.Enemy;
import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The com.ae2dms.GameObject.Objects.Bubble class handles everything with the main.Hero's special ability, named the bubble.
 * It begins at the hero, and grows covering the whole screen.
 * Once it collides with an enemy, that enemy is bubbled.
 */
public class Bubble extends SpriteObject {
	private int accel;
	private static final int SIZE = 25;

    /**
     * The image of the bubble.
     */
    protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/explosion.png").toString(), SIZE, SIZE, false, false);

    /**
     * Instantiates a new Bubble.
     *
     * @param gameScene the gamescene that the bubble in
     * @param x         the x-coordinate of bubble
     * @param y         the y-coordinate of bubble
     */
    public Bubble(GameScene gameScene, double x, double y) {
		super(x, y, 0, 0, gameScene, image);
		accel = 1;
	}

	@Override
	public void update() {
		if (getWidth() >= 2500) {
			markToRemove();
		}
		setX(getX() - accel / 2);
		setY(getY() - accel / 2);
		setWidth(getWidth() + accel);
		setHeight(getHeight() + accel);
		accel += 1;
	}
	
	@Override
	public void drawOn(GraphicsContext g) {
		if (getWidth() <= 2500) {
			g.setGlobalAlpha((double)(255 - (int) (getWidth() * ((double) 255 / 2500)))/255);
			g.drawImage(image, getX(), getY(), getWidth(), getHeight());
			g.setGlobalAlpha(1);
		} else {
			g.drawImage(image, getX(), getY(), getWidth(), getHeight());
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

    /**
     * Bubble collide with enemy.
     *
     * @param enemy the enemy
     */
    public void collideWith(Enemy enemy) {
		if (this.overlaps(enemy)) {
			enemy.collideWithProjectile();
		}
	}

    /**
     * Collide with.
     *
     * @param boss the boss
     */
    public void collideWith(Boss boss) {
		if (this.overlaps(boss)) {
			boss.collideWithProjectile();
		}
	}

}
